package org.example.model;

public abstract class User {
    private Integer id;
    protected String name;
    protected String surname;

    public User(Integer id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
