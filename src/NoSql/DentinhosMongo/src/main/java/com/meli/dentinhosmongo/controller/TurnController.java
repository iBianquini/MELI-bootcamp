package com.meli.dentinhosmongo.controller;

import com.meli.dentinhosmongo.dto.TurnCreationDTO;
import com.meli.dentinhosmongo.entity.Turn;
import com.meli.dentinhosmongo.service.TurnService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turn")
public class TurnController {

    private TurnService turnService;

    public TurnController(TurnService turnService) {
        this.turnService = turnService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Turn setTurn(@RequestBody TurnCreationDTO turnCreationDTO) {
        return this.turnService.createTurn(turnCreationDTO);
    }

    @PostMapping("/set/{turnId}")
    public void setDentistToTurn(@PathVariable String turnId, @RequestBody List<String> dentistsMp) {
        this.turnService.setDentistToTurn(turnId, dentistsMp);
    }
}
