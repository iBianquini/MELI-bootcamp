package com.meli.aula2diploma.dto;

public class DiplomaDTO {

    private String alunoNome;
    private double mediaFinal;
    private String mensagem;

    public DiplomaDTO(String alunoNome, double mediaFinal) {
        this.alunoNome = alunoNome;
        this.mediaFinal = mediaFinal;

        if (mediaFinal > 9)
            mensagem = "Parabens !";
        else
            mensagem = "";
    }

    public String getAlunoNome() {
        return alunoNome;
    }

    public void setAlunoNome(String alunoNome) {
        this.alunoNome = alunoNome;
    }

    public double getMediaFinal() {
        return mediaFinal;
    }

    public void setMediaFinal(double mediaFinal) {
        this.mediaFinal = mediaFinal;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
