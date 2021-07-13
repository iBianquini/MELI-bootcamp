package com.meli.aula2diploma.controller;

import com.meli.aula2diploma.domain.Aluno;
import com.meli.aula2diploma.dto.DiplomaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AlunoController {

    @RequestMapping(value = "/analyzeNotes", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public DiplomaDTO getDiploma(@RequestBody @Valid Aluno incomingAluno){
        return new DiplomaDTO(incomingAluno);
    }
}
