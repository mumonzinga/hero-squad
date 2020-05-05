package dao;

import models.Hero;
import org.sql2o.*;
import java.util.List;

public class Sql2oHeroDao implements HeroDao { //implementing herodao interface

    private final Sql2o sql2o;

    public Sql2oHeroDao(Sql2o sql2o) {
        this.sql2o = sql2o;  //making sql2o public so as to call methods on it
    }

    @Override
    public void add(Hero hero) {
        String sql = "INSERT INTO heroes (name, age, power, weakness) VALUES (:name, :age, :power, :weakness)"; //raw sql
        try (Connection con = sql2o.open()) { //try open a connection
            int id = (int) con.createQuery(sql, true) //make a new variable
                    .bind(hero)
                    .executeUpdate() // run it all
                    .getKey(); //int id is now the row number(row key) of the db
            hero.setId(id); //update object to set id now from db
        } catch (Sql2oException ex) {
            System.out.println(ex); //oops we have an error!


        }
    }


    @Override
    public List<Hero> getAll() {
        try (Connection con = sql2o.open()){ //open a connection
            return con.createQuery("SELECT * FROM heroes") // raw sql
                .executeAndFetch(Hero.class); //fetch a list
        }
    }

    @Override
    public Hero findById(int id) {
        try(Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM heroes WHERE id =:id")
                    .addParameter("id", id) //key/value pair, key must match above
                    .executeAndFetchFirst(Hero.class); //fetch an individual item
        }

    }

    @Override
    public void update(int id, String newName, int newAge,String newPower, String newWeakness) {
        String sql = "UPDATE heroes SET (name,age, power,weakness) = (:name, :age, :power, :weakness) WHERE id = : id"; // raw sql
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("name", newName)
                    .addParameter("age", newAge)
                    .addParameter("power", newPower)
                    .addParameter("weakness", newWeakness)
                    .addParameter("id", id)
                    .executeUpdate();
        }catch (Sql2oException ex) {
            System.out.println(ex);

        }
    }

    @Override
    public void deleteById()
}