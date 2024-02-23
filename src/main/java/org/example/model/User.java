package org.example.model;

public abstract class User {
    private Integer id;
    private String name;
    private String surname;
    private String login;

    public User(Integer id, String name, String surname, String login) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
