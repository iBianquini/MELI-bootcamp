package com.meli.aula2diploma.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class Disciplina {
    @JsonProperty(value = "subject")
    @NotBlank(message = "Campo não pode ser vazio")
    @Pattern(message = "disciplina deve ter no minimo 8 caracteres e no maximo 40", regexp = "^[a-zA-Z]{8,40}")
    private String nome;

    @JsonProperty(value = "note")
    @Min(0)
    @Max(10)
    private int nota;


    public Disciplina(String nome, int nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
}
