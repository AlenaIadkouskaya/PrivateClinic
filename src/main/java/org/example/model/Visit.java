package org.example.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.util.UUID;

public class Visit {
    private final Integer id;
    private final LocalDate date;
    private final LocalTime time;
    private final User doctor;
    private User patient;
    public static Integer countVisits = 1;

    public Visit(LocalDate date, LocalTime time, User doctor) {
        this.id = countVisits++;
        this.date = date;
        this.time = time;
        this.doctor = doctor;
    }

    public Visit(LocalDate date, LocalTime time, User doctor, User patient) {
        this.id = countVisits++;
        this.date = date;
        this.time = time;
        this.doctor = doctor;
        this.patient = patient;
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

    public void setPatient(User patient) {
        this.patient = patient;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Visit visit = (Visit) o;
        return Objects.equals(date, visit.date) && Objects.equals(time, visit.time) && Objects.equals(doctor, visit.doctor) && Objects.equals(patient, visit.patient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, time, doctor, patient);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
