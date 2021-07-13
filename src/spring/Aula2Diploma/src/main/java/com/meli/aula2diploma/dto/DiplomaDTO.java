package com.meli.aula2diploma.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.meli.aula2diploma.domain.Aluno;

@JsonPropertyOrder({"message", "average", "student"})
public class DiplomaDTO {

    @JsonProperty(value = "average")
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private double mediaFinal;
    @JsonProperty(value = "message")
    private String mensagem;
    @JsonProperty(value = "student")
    private Aluno aluno;


    public DiplomaDTO(Aluno aluno) {
        this.mediaFinal =  aluno.calcularMedia();
        this.mensagem = (this.mediaFinal >= 9) ? "Sua média foi: " + this.mediaFinal + " parabens!" : "Sua média foi: " + this.mediaFinal;
        this.aluno = aluno;
    }

    public double getMediaFinal() {
        return mediaFinal;
    }

    public String getMensagem() {
        return mensagem;
    }

    public Aluno getAluno() {
        return aluno;
    }
}
