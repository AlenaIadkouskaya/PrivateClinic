package org.example.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Visit {
    private Integer id;
    private LocalDate date;
    private LocalTime time;
    private Doctor doctor;
    private Patient patient;

    public Visit(Integer id, LocalDate date, LocalTime time, Doctor doctor) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.doctor = doctor;
//        this.patient = null;
    }

}
