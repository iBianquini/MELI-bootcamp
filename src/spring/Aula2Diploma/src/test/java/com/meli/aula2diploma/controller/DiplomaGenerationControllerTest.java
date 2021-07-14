package com.meli.aula2diploma.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.aula2diploma.domain.Aluno;
import com.meli.aula2diploma.domain.Disciplina;
import com.meli.aula2diploma.dto.DiplomaDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DiplomaGenerationControllerTest {

    @Autowired
    MockMvc mockMvc;


    @Autowired
    ObjectMapper mapper;


    @Test
    public void deveria_invalidar_requisicao_devido_a_nome_muito_curto() throws Exception {
        Disciplina d1 = new Disciplina("matematica", 9);
        Disciplina d2 = new Disciplina("Portugues", 9);
        Disciplina d3 = new Disciplina("Geografia", 8);


        Aluno aluno1 = new Aluno("Igo", Arrays.asList(d1, d2, d3));

        mockMvc.perform(MockMvcRequestBuilders.post("/analyzeNotes")
                .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(aluno1)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void deveria_validar_requisicao_e_retornar_diploma() throws Exception {
        Disciplina d1 = new Disciplina("matematica", 9);
        Disciplina d2 = new Disciplina("Portugues", 9);
        Disciplina d3 = new Disciplina("Geografia", 8);

        Aluno aluno1 = new Aluno("Iago Rosa", Arrays.asList(d1, d2, d3));

        DiplomaDTO dto = DiplomaDTO.generateDiploma(aluno1);

        mockMvc.perform(MockMvcRequestBuilders.post("/analyzeNotes")
                .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON).characterEncoding("UTF-8").content(mapper.writeValueAsString(aluno1)))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.content().json(mapper.writeValueAsString(dto)));
    }

    @Test
    public void nao_deveria_gerar_diploma_quando_media_menor_que_7() throws Exception {
        Disciplina d1 = new Disciplina("matematica", 6);
        Disciplina d2 = new Disciplina("Portugues", 5);
        Disciplina d3 = new Disciplina("Geografia", 6);

        Aluno aluno1 = new Aluno("Iago Rosa", Arrays.asList(d1, d2, d3));

        mockMvc.perform(MockMvcRequestBuilders.post("/analyzeNotes")
                .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON).characterEncoding("UTF-8").content(mapper.writeValueAsString(aluno1)))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }
}
