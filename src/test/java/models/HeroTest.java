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
    public void Hero_instantiatesCorrectly_true() {
        Hero myHero = new Hero("EL", 30, "madem", "madem");
        assertEquals(true, myHero instanceof Hero);
    }
}