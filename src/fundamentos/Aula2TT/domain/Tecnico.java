package fundamentos.Aula2TT.domain;

import java.math.BigDecimal;

public class Tecnico extends CLT{


    public Tecnico(String nome, int metasAlcancadas) {
        super(nome, 40, BigDecimal.valueOf(3200), metasAlcancadas);
    }

    @Override
    public BigDecimal pagarSalario() {
        var bonificacao = getSalarioBase().multiply(BigDecimal.valueOf(0.05)).multiply(BigDecimal.valueOf(getMetasAlcancadas()));
        return getSalarioBase().add(bonificacao);
    }


}
