package com.meli.dentinhosmongo.dto;

import java.time.LocalDateTime;
import java.util.List;

public class TurnRetrievalDTO {

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<UserRetrievalDTO> dentists;

    public TurnRetrievalDTO() {
    }

    public TurnRetrievalDTO(LocalDateTime startTime, LocalDateTime endTime, List<UserRetrievalDTO> dentists) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.dentists = dentists;
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

    public List<UserRetrievalDTO> getDentists() {
        return dentists;
    }

    public void setDentists(List<UserRetrievalDTO> dentists) {
        this.dentists = dentists;
    }
}
