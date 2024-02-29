package org.example.model;

import java.util.UUID;

public class Doctor extends User {
    private final Specialization specialization;

    public Doctor(UUID id, String name, String surname, String login, String password, Specialization specialization) {
        super(id, name, surname, login, password);
        this.specialization = specialization;
    }

    public Specialization getSpecialization() {
        return specialization;
    }
}
