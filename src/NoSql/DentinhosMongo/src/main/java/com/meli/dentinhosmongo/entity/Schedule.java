package com.meli.dentinhosmongo.entity;

import com.meli.dentinhosmongo.dto.DentistScheduleDTO;
import com.meli.dentinhosmongo.dto.ScheduleDTO;
import com.meli.dentinhosmongo.dto.UserScheduleDTO;
import com.meli.dentinhosmongo.entity.enums.ScheduleStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "schedules")
public class Schedule {

    @Id
    private String id;

    private LocalDateTime days;

    private ScheduleStatus scheduleStatus;

    private User patient;

    private Dentist dentist;

    public Schedule() {
    }

    public Schedule(LocalDateTime days, ScheduleStatus turnStatus, User patient, Dentist dentist) {
        this.days = days;
        this.scheduleStatus = turnStatus;
        this.patient = patient;
        this.dentist = dentist;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDays() {
        return days;
    }

    public void setDays(LocalDateTime days) {
        this.days = days;
    }

    public ScheduleStatus getScheduleStatus() {
        return scheduleStatus;
    }

    public void setScheduleStatus(ScheduleStatus scheduleStatus) {
        this.scheduleStatus = scheduleStatus;
    }

    public User getPatient() {
        return patient;
    }

    public void setPatient(User patient) {
        this.patient = patient;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    public ScheduleDTO castToScheduleDTO() {
        UserScheduleDTO userScheduleDTO = this.getPatient().castToUserScheduleDTO();
        DentistScheduleDTO dentistScheduleDTO = this.getDentist().castToDentistScheduleDTO();
        return new ScheduleDTO(this.id, userScheduleDTO, dentistScheduleDTO, this.getDays(), this.getScheduleStatus());
    }
}
