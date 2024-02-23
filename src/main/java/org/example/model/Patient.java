package org.example.model;

public class Patient extends User {
    private String numberTelephone;

    public Patient(Integer id, String name, String surname, String login, String numberTelephone) {
        super(id, name, surname, login);
        this.numberTelephone = numberTelephone;
    }

    public String getNumberTelephone() {
        return numberTelephone;
    }
}
