package fundamentos.Aula2TT.domain;

import java.math.BigDecimal;

public class Diretor extends CLT{

    private BigDecimal participacaoLucro;

    public Diretor(String nome, BigDecimal lucrosTotaisEmpresa) {
        super(nome, 0, BigDecimal.valueOf(15000), 0);
        this.participacaoLucro = lucrosTotaisEmpresa.multiply(BigDecimal.valueOf(0.03));
    }

    @Override
    public BigDecimal pagarSalario() {
        return this.getSalarioBase().add(participacaoLucro);
    }

    public BigDecimal getParticipacaoLucro() {
        return participacaoLucro;
    }

    public void setParticipacaoLucro(BigDecimal participacaoLucro) {
        this.participacaoLucro = participacaoLucro;
    }

    @Override
    public String toString() {
        return "Diretor{" + super.toString() +
                "participacaoLucro=" + participacaoLucro +
                '}';
    }
}
