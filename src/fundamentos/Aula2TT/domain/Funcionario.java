package fundamentos.Aula2TT.domain;

import java.math.BigDecimal;

public abstract class Funcionario {
    private String nome;
    private int cargaHoraria;

    public Funcionario(String nome, int cargaHoraria) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    public abstract BigDecimal pagarSalario();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}
