package Aula2TT.domain;

import java.math.BigDecimal;

public abstract class CLT extends Funcionario{

    private BigDecimal salarioBase;
    private int metasAlcancadas;

    public CLT(String nome, int cargaHoraria, BigDecimal salarioBase, int metasAlcancadas) {
        super(nome, cargaHoraria);
        this.salarioBase = salarioBase;
        this.metasAlcancadas = metasAlcancadas;
    }

    public BigDecimal getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(BigDecimal salarioBase) {
        this.salarioBase = salarioBase;
    }

    public int getMetasAlcancadas() {
        return metasAlcancadas;
    }

    public void setMetasAlcancadas(int metasAlcancadas) {
        this.metasAlcancadas = metasAlcancadas;
    }

    @Override
    public String toString() {
        return "CLT{" +
                " SalarioBase=" + salarioBase +
                " Carga horaria=" + getCargaHoraria() +
                " MetasAlcancadas=" + metasAlcancadas +
                " Salario Total=" + pagarSalario() +
                 '}';
    }
}
