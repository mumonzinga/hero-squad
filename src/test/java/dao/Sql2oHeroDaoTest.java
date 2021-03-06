package dao;

import models.Hero;
import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class Sql2oHeroDaoTest {
    private Sql2oHeroDao heroDao; //interface implementation
    private Connection conn; // must be sql2o class conn

    @Before
    public void setUp() throws Exception {
        String connectionString ="jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "mumo", "kyalelove");
        heroDao = new Sql2oHeroDao(sql2o);
        conn = sql2o.open(); // keep the connection open through the entire test so it does not get erased
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingHeroSetId() throws Exception {
        Hero hero = setUpNewHero();
        int originalHeroId = hero.getId();
        heroDao.add(hero);
        assertNotEquals(originalHeroId, hero.getId());
    }

    @Test
    public void existingHeroesCanBeFoundById() throws Exception {
        Hero hero = setUpNewHero();
        heroDao.add(hero); //add to dao (takes care of saving)
        Hero foundHero = heroDao.findById(hero.getId()); //retrieve
        assertEquals(hero, foundHero); //should be the same
    }

    @Test
    public void addedHeroesAreReturnedFromgetAll() throws Exception {
        Hero hero = setUpNewHero();
        heroDao.add(hero);
        assertEquals(1, heroDao.getAll().size());
    }

    @Test
    public void noHeroesReturnsEmptyList() throws Exception {
        assertEquals(0, heroDao.getAll().size());
    }

    @Test
    public void updateChangesHeroContent() throws Exception {
        String initialName = "EL";
        Hero hero = setUpNewHero();
        heroDao.add(hero);

        heroDao.update(hero.getId(),"MC", 30, "mari", "mari");
        Hero updatedHero = heroDao.findById(hero.getId()); //why do I need to refind this?
        assertNotEquals(initialName, updatedHero.getName());
    }

    @Test
    public void deleteByIdDeletesCorrectHero() throws Exception {
        Hero hero = setUpNewHero();
        heroDao.add(hero);
        heroDao.deleteById(hero.getId());
        assertEquals(0, heroDao.getAll().size());
    }

    @Test
    public void clearAllHeroes() throws Exception {
        Hero hero = setUpNewHero();
        Hero otherHero = new Hero("MC", 30, "mari", "mari");
        heroDao.add(hero);
        heroDao.add(otherHero);
        int daoSize = heroDao.getAll().size();
        heroDao.clearAllHeroes();
        assertTrue(daoSize > 0 && daoSize > heroDao.getAll().size()); //this is a little overcomplicated, but illustrates well how we might use `assertTrue` in a different way.
    }

    @Test
    public void cIdIsReturnedCorrectly() throws Exception {
        Hero hero = setUpNewHero();
        int originalCatId = hero.getSquadId();
        heroDao.add(hero);
        assertEquals(originalCatId, heroDao.findById(hero.getId()).getSquadId());
    }


    public Hero setUpNewHero() {
        return new Hero("EL", 30, "madem", "madem");
    }
}



