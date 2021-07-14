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


    public DiplomaDTO(double mediaFinal, String mensagem, Aluno aluno) {
        this.mediaFinal = mediaFinal;
        this.mensagem = mensagem;
        this.aluno = aluno;
    }

    public static DiplomaDTO generateDiploma(Aluno aluno) {
        var media = aluno.calcularMedia();
        if (media < 7) return null;
        var mensagem = (media >= 9) ? "Sua média foi: " + media + " parabens!" : "Sua média foi: " + media;
        return new DiplomaDTO(aluno.calcularMedia(), mensagem, aluno);
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
