package org.example.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class Visit {
    private Integer id;
    private LocalDate date;
    private LocalTime time;
    private User doctor;
    private User patient;
    public static Integer countVisits = 1;

    public Visit(LocalDate date, LocalTime time, User doctor) {

        this.id = countVisits++;
        this.date = date;
        this.time = time;
        this.doctor = doctor;
    }

    public LocalDate getDate() {
        return date;
    }

    public Integer getId() {
        return id;
    }

    public LocalTime getTime() {
        return time;
    }

    public User getDoctor() {
        return doctor;
    }

    public User getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
