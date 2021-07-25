package com.meli.dentinhosmongo.dto;

import com.meli.dentinhosmongo.entity.enums.ScheduleStatus;

import java.time.LocalDateTime;

public class ScheduleDTO {

    private String id;

    private UserScheduleDTO patient;

    private DentistScheduleDTO dentist;

    private LocalDateTime date;

    private ScheduleStatus turnStatus;

    public ScheduleDTO(String id, UserScheduleDTO patient, DentistScheduleDTO dentist, LocalDateTime date, ScheduleStatus turnStatus) {
        this.id = id;
        this.patient = patient;
        this.dentist = dentist;
        this.date = date;
        this.turnStatus = turnStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserScheduleDTO getPatient() {
        return patient;
    }

    public void setPatient(UserScheduleDTO patient) {
        this.patient = patient;
    }

    public DentistScheduleDTO getDentist() {
        return dentist;
    }

    public void setDentist(DentistScheduleDTO dentist) {
        this.dentist = dentist;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public ScheduleStatus getTurnStatus() {
        return turnStatus;
    }

    public void setTurnStatus(ScheduleStatus turnStatus) {
        this.turnStatus = turnStatus;
    }
}
