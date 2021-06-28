package Aula2TT.domain;

import java.math.BigDecimal;

public class PJ extends Funcionario{

    private BigDecimal valorHora;

    public PJ(String nome, int cargaHoraria, BigDecimal valorHora) {
        super(nome, cargaHoraria);
        this.valorHora = valorHora;
    }

    @Override
    public BigDecimal pagarSalario() {
        return this.valorHora.multiply(BigDecimal.valueOf(super.getCargaHoraria()));
    }

    public BigDecimal getValorHora() {
        return valorHora;
    }

    public void setValorHora(BigDecimal valorHora) {
        this.valorHora = valorHora;
    }

    @Override
    public String toString() {
        return "PJ{" +
                " ValorHora=" + valorHora +
                " Carga horaria="+ getCargaHoraria() +
                " Salario Final=" + pagarSalario() +
                '}';
    }
}
