package com.meli.aula2diploma.service;

import com.meli.aula2diploma.domain.Aluno;
import com.meli.aula2diploma.dto.DiplomaDTO;
import org.springframework.stereotype.Service;

@Service
public class DiplomaService {

    public DiplomaDTO generateDiploma(Aluno aluno) {
        if (aluno.getDisciplinas().isEmpty())
            return null;
        return new DiplomaDTO(aluno);
    }
}
