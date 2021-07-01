package com.meli.aula2diploma.controller;

import com.meli.aula2diploma.domain.Aluno;
import com.meli.aula2diploma.dto.DiplomaDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlunoController {

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public DiplomaDTO getDiploma(@RequestBody Aluno incomingAluno){
        return new DiplomaDTO(incomingAluno.getNome(),incomingAluno.calcularMedia());
    }
}
