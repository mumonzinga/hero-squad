package models;
import java.time.LocalDateTime;

public class Hero {
    private String name;
    private int age;
    private String power;
    private String weakness;
    private int id;
    private LocalDateTime createdAt;
    private int squadId;

    public Hero(String name,int age, String power, String weakness) {
        this.name = name;
        this.age = age;
        this.power = power;
        this.weakness = weakness;
        this.createdAt =LocalDateTime.now();
        this.squadId = squadId;
    }

    public int getSquadId() {
        return squadId;
    }
    public void setSquadId(int squadId) {
        this.squadId = squadId;
    }
    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hero hero = (Hero) o;

        if (age != hero.age) return false;
        if (id != hero.id) return false;
        if (squadId != hero.squadId) return false;
        if (!name.equals(hero.name)) return false;
        if (!power.equals(hero.power)) return false;
        if (!weakness.equals(hero.weakness)) return false;
        return createdAt.equals(hero.createdAt);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        result = 31 * result + power.hashCode();
        result = 31 * result + weakness.hashCode();
        result = 31 * result + id;
        result = 31 * result + createdAt.hashCode();
        result = 31 * result + squadId;
        return result;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPower(String power){
        this.power = power;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }
    public String getName() {
        return name;
    }

    public int getAge(int age){
        return age;
    }

    public String getPower(String power) {
        return power;
    }

    public String getWeakness(String weakness) {
        return weakness;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}