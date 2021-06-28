package Aula2TT.domain;

import java.math.BigDecimal;

public class Analista extends CLT{
    public Analista(String nome, int metasAlcancadas) {
        super(nome, 40, BigDecimal.valueOf(4000), metasAlcancadas);
    }

    @Override
    public BigDecimal pagarSalario() {
        var bonificacao = getSalarioBase().multiply(BigDecimal.valueOf(0.08).multiply(BigDecimal.valueOf(getMetasAlcancadas())));
        return getSalarioBase().add(bonificacao);
    }
}
