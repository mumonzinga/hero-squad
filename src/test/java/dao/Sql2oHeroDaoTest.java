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
        Sql2o sql2o = new Sql2o(connectionString, "", "");
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

    public Hero setUpNewHero() {
        return new Hero("EL", 30, "madem", "madem");
    }
}



