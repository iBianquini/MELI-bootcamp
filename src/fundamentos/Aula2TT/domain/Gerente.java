package fundamentos.Aula2TT.domain;

import java.math.BigDecimal;

public class Gerente extends CLT{
    public Gerente(String nome, int metasAlcancadas) {
        super(nome, 36, BigDecimal.valueOf(6000), metasAlcancadas);
    }

    @Override
    public BigDecimal pagarSalario() {
        var bonificacao = getSalarioBase().multiply(BigDecimal.valueOf(0.125).multiply(BigDecimal.valueOf(getMetasAlcancadas())));
        return getSalarioBase().add(bonificacao);
    }

}
