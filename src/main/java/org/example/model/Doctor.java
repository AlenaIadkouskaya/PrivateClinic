package org.example.model;

public class Doctor extends User {
    private final Specialization specialization;

    public Doctor(Integer id, String name, String surname, String login, String password, Specialization specialization) {
        super(id, name, surname, login, password);
        this.specialization = specialization;
    }

    public Specialization getSpecialization() {
        return specialization;
    }
}
