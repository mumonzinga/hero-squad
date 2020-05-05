package models;

import org.junit.*;
import java.time.LocalDateTime;
import static org.junit.Assert.*;

public class HeroTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {


    }

    @Test
    public void NewHeroObjectGetCorrectlyCreated_true() throws Exception{
        Hero hero = setUpNewHero();
        assertEquals(true, hero instanceof Hero);
    }

    @Test
    public void getName_forHeroesName_String() {
        Hero myH
    }

    //helper methods
    public Hero setUpNewHero(){
        return new Hero("EL", 30, "madem", "madem");
    }
}