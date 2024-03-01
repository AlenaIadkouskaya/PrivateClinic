package org.example.model;

import java.util.UUID;

public abstract class User {
    private final UUID id;
    private final String name;
    private final String surname;
    private final String login;
    private final String password;

    public User(UUID id, String name, String surname, String login, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public UUID getId() {
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
