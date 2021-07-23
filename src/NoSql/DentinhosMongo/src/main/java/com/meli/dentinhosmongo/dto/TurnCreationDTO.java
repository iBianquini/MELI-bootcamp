package com.meli.dentinhosmongo.dto;

import java.time.LocalDateTime;
import java.util.List;

public class TurnCreationDTO {

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<String> dentistsMP;

    public TurnCreationDTO() {
    }

    public TurnCreationDTO(LocalDateTime startTime, LocalDateTime endTime, List<String> dentistsMP) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.dentistsMP = dentistsMP;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public List<String> getDentistsMP() {
        return dentistsMP;
    }

    public void setDentistsMP(List<String> dentistsMP) {
        this.dentistsMP = dentistsMP;
    }
}
