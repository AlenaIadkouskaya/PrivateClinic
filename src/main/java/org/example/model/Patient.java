package org.example.model;

public class Patient extends User {
    private String numberTelephone;

    public Patient(Integer id, String name, String surname, String numberTelephone, String login) {
        super(id, name, surname, login);
        this.numberTelephone = numberTelephone;
    }

    public String getNumberTelephone() {
        return numberTelephone;
    }
}
