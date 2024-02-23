package org.example.model;

public class Doctor extends User {
    private Specialization specialization;

    public Doctor(Integer id, String name, String surname, String login, Specialization specialization) {
        super(id, name, surname, login);
        this.specialization = specialization;
    }

}
