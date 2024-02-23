package org.example.model;

public class Doctor extends User {
    private Specialization specialization;

    public Doctor(Integer id, String name, String surname, Specialization specialization, String login) {
        super(id, name, surname, login);
        this.specialization = specialization;
    }

    public Specialization getSpecialization() {
        return specialization;
    }
}
