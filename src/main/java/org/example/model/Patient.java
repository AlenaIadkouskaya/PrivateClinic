package org.example.model;

public class Patient extends User{
    private String numberTelephone;

    public Patient(Integer id, String name, String surname, String numberTelephone) {
        super(id, name, surname);
        this.numberTelephone = numberTelephone;
    }
}
