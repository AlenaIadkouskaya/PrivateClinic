package org.example.model;

public abstract class User {
    private final Integer id;
    private final String name;
    private final String surname;
    private final String login;
    private final String password;

    public User(Integer id, String name, String surname, String login, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
