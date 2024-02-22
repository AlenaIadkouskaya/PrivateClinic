package org.example.model;

public abstract class User {
    private Integer id;
    private String name;
    private String surname;

    public User(Integer id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }
}
