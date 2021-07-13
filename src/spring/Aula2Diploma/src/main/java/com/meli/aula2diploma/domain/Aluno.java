package com.meli.aula2diploma.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;


public class Aluno {

    @JsonProperty(value = "name")
    @NotBlank(message = "Campo não pode ser vazio")

    @Pattern(message = "Nome deve ter no minimo 8 caracteres e no maximo 40", regexp = "^[a-zA-Z]{2,}(?: [a-zA-Z]+){0,2}$")
    private String nome;


    @JsonProperty(value = "subjects")
    @Valid
    private List<Disciplina> disciplinas;


    public Aluno(String nome) {
        this.nome = nome;
        this.disciplinas = new ArrayList<>();
    }

    public Aluno(String nome, List<Disciplina> disciplinas) {
        this.nome = nome;
        this.disciplinas = disciplinas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public double calcularMedia(){
        double media = 0;
        for (Disciplina d : this.disciplinas) {
            media += d.getNota();
        }
        return media / this.disciplinas.size();
    }


}

