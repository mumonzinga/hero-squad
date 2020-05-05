package models;


import java.util.Objects;

public class Squad {
    private String name;
    private int size;
    private String cause;
    private int id;

    public Squad(String name, int size, String cause) {
        this.name = name;
        this.size = size;
        this.cause = cause;
    }

    public String getName() {
        return name;
    }

    public String getCause()  {
        return cause;
    }

    public int getSize() {
        return size;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(int size) {
        this.id = id;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }


    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Squad squad = (Squad) o;

        if (size != squad.size) return false;
        if (id != squad.id) return false;
        if (!name.equals(squad.name)) return false;
        return cause.equals(squad.cause);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + size;
        result = 31 * result + cause.hashCode();
        result = 31 * result + id;
        return result;
    }
}