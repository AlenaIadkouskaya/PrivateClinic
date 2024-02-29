package org.example.model;

import java.util.UUID;

public class Patient extends User {
    private final String numberTelephone;

    public Patient(UUID id, String name, String surname, String login, String password, String numberTelephone) {
        super(id, name, surname, login, password);
        this.numberTelephone = numberTelephone;
    }

    public String getNumberTelephone() {
        return numberTelephone;
    }
}
