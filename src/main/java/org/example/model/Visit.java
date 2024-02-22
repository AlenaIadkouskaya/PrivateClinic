package org.example.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Visit {
    private Integer id;
    private LocalDate date;
    private LocalTime time;
    private Doctor doctor;
    private Patient patient;
    public static Integer countVisits = 1;

    public Visit(Integer id, LocalDate date, LocalTime time, Doctor doctor) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.doctor = doctor;
        countVisits++;
//        this.patient = null;
    }

    public LocalDate getDate() {
        return date;
    }
}
