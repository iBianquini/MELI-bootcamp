package com.meli.dentinhosmongo.entity;

import com.meli.dentinhosmongo.dto.TurnCreationDTO;
import com.meli.dentinhosmongo.dto.TurnRetrievalDTO;
import com.meli.dentinhosmongo.dto.UserDTO;
import com.meli.dentinhosmongo.dto.UserRetrievalDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "turns")
public class Turn {

    @Id
    private String id;

    private LocalDateTime startTime;

    private LocalDateTime endingTime;

    private List<Dentist> dentists;

    public Turn() {
    }

    public Turn(LocalDateTime startTime, LocalDateTime endingTime, List<Dentist> dentists) {
        this.startTime = startTime;
        this.endingTime = endingTime;
        this.dentists = dentists;
    }

    public static Turn castToEntity(TurnCreationDTO turnCreationDTO) {
        return new Turn(turnCreationDTO.getStartTime(), turnCreationDTO.getEndTime(), new ArrayList<>());
    }

    public void setDentistToTurn(Dentist dentist) {
        this.dentists.add(dentist);
    }

    public void setDentistsToTurn(List<Dentist> dentists) {
        this.dentists.addAll(dentists);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public TurnRetrievalDTO castToRetrievalDTO(List<UserRetrievalDTO> dentists) {
        return new TurnRetrievalDTO(this.startTime, this.endingTime, dentists);
    }
}
