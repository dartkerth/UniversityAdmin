package org.tae.exercises.people;

public abstract class Person {
    private String name;
    private String id;

    public abstract void showYourself();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
