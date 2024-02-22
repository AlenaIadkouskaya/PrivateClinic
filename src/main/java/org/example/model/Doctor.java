package org.example.model;

public class Doctor extends User {
    private Specialization specialization;

    public Doctor(Integer id, String name, String surname, Specialization specialization) {
        super(id, name, surname);
        this.specialization = specialization;
    }

}
