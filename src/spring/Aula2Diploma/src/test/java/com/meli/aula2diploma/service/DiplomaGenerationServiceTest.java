package com.meli.aula2diploma.service;

import com.meli.aula2diploma.controller.AlunoController;
import com.meli.aula2diploma.domain.Aluno;
import com.meli.aula2diploma.domain.Disciplina;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


public class DiplomaGenerationServiceTest {
    private AlunoController controller;

    @BeforeEach
    public void init (){
        this.controller = new AlunoController();
    }

    @Test
    public void deveria_gerar_diploma_regular(){
        //arrange
        Disciplina d1 = new Disciplina("matematica", 9);
        Disciplina d2 = new Disciplina("Portugues", 9);
        Disciplina d3 = new Disciplina("Geografia", 8);


        Aluno aluno1 = new Aluno("Osvaldo", Arrays.asList(d1,d2,d3));

        //Action
        var response = this.controller.getDiploma(aluno1);

        //Assert
        assertThat(response).isNotNull();
        assertThat(response.getMediaFinal()).isLessThan(9);
        assertThat(response.getMensagem()).doesNotContain("parabens!");
    }

    @Test
    public void deveria_gerar_diploma_com_mensagem_de_parabens_para_media_maior_ou_igual_a_9(){
        //arrange
        Disciplina d1 = new Disciplina("matematica", 9);
        Disciplina d2 = new Disciplina("Portugues", 9);
        Disciplina d3 = new Disciplina("Geografia", 9);


        Aluno aluno1 = new Aluno("Osvaldo", Arrays.asList(d1,d2,d3));

        //Action
        var response = this.controller.getDiploma(aluno1);

        //Assert
        assertThat(response).isNotNull();
        assertThat(response.getMediaFinal()).isGreaterThanOrEqualTo(9);
        assertThat(response.getMensagem()).contains("parabens!");
    }

    @Test
    public void deveria_gerar_media_maior_que_9() {
        //arrange
        Disciplina d1 = new Disciplina("matematica", 10);
        Disciplina d2 = new Disciplina("Portugues", 9);
        Disciplina d3 = new Disciplina("Geografia", 9);


        Aluno aluno1 = new Aluno("Osvaldo", Arrays.asList(d1,d2,d3));

        //Action
        var response = aluno1.calcularMedia();

        //Assert
        assertThat(response).isNotNull();
        assertThat(response).isGreaterThanOrEqualTo(9);
    }

}
