package com.meli.aula2diploma.controller;

import com.meli.aula2diploma.domain.Aluno;
import com.meli.aula2diploma.dto.DiplomaDTO;
import com.meli.aula2diploma.service.DiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AlunoController {

    @Autowired
    DiplomaService service;

    public AlunoController() {
        this.service = new DiplomaService();
    }


    @RequestMapping(value = "/analyzeNotes", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public DiplomaDTO getDiploma(@RequestBody @Valid Aluno incomingAluno) {
        return service.generateDiploma(incomingAluno);
    }
}
