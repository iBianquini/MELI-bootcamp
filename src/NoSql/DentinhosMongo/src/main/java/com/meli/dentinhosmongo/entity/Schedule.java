package com.meli.dentinhosmongo.entity;

import com.meli.dentinhosmongo.entity.enums.ScheduleStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "schedules")
public class Schedule {

    @Id
    private Integer id;

    private LocalDate days;

    private ScheduleStatus turnStatus;

    private User patient;

    public Schedule() {
    }

    public Schedule(Integer id, LocalDate days, ScheduleStatus turnStatus, User patient) {
        this.id = id;
        this.days = days;
        this.turnStatus = turnStatus;
        this.patient = patient;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDays() {
        return days;
    }

    public void setDays(LocalDate days) {
        this.days = days;
    }

    public ScheduleStatus getTurnStatus() {
        return turnStatus;
    }

    public void setTurnStatus(ScheduleStatus turnStatus) {
        this.turnStatus = turnStatus;
    }

    public User getPatient() {
        return patient;
    }

    public void setPatient(User patient) {
        this.patient = patient;
    }
}
