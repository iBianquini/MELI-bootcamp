package com.meli.dentinhosmongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "turns")
public class Turn {

    @Id
    private Integer id;

    private LocalDateTime startTime;

    private LocalDateTime endingTime;

    private List<Dentist> dentists;

    public Turn() {
    }

    public Turn(Integer id, LocalDateTime startTime, LocalDateTime endingTime, List<Dentist> dentists) {
        this.id = id;
        this.startTime = startTime;
        this.endingTime = endingTime;
        this.dentists = dentists;
    }

    public void setDentistToTurn(Dentist dentist) {
        this.dentists.add(dentist);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(LocalDateTime endingTime) {
        this.endingTime = endingTime;
    }

    public List<Dentist> getDentists() {
        return dentists;
    }

    public void setDentists(List<Dentist> dentists) {
        this.dentists = dentists;
    }
}
