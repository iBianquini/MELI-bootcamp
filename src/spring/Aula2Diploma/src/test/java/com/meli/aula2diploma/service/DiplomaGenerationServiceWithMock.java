package com.meli.aula2diploma.service;

import com.meli.aula2diploma.controller.AlunoController;
import com.meli.aula2diploma.domain.Aluno;
import com.meli.aula2diploma.domain.Disciplina;
import com.meli.aula2diploma.dto.DiplomaDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DiplomaGenerationServiceWithMock {
    private AlunoController alunoController;

    @BeforeEach
    public void init() {
        this.alunoController = mock(AlunoController.class);
    }

    @Test
    public void deveria_gerar_media_maior_que_9() {
        //arrange
        Disciplina d1 = new Disciplina("matematica", 10);
        Disciplina d2 = new Disciplina("Portugues", 9);
        Disciplina d3 = new Disciplina("Geografia", 9);

        Aluno aluno1 = new Aluno("Osvaldo", Arrays.asList(d1, d2, d3));

        DiplomaDTO dto = new DiplomaDTO(aluno1);

        when(alunoController.getDiploma(aluno1)).thenReturn(dto);

        //Action
        var response = this.alunoController.getDiploma(aluno1);

        //Assert
        assertThat(response).isNotNull();
        assertThat(response.getMediaFinal()).isGreaterThanOrEqualTo(9);
    }
}
