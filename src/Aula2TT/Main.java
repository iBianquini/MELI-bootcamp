package Aula2TT;

import Aula2TT.domain.*;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Funcionario pj = new PJ("Jose CLT",40,BigDecimal.valueOf(120));
        System.out.println(pj);

        Funcionario tecnico = new Tecnico("tec",4);
        System.out.println(tecnico);

        Funcionario ana = new Analista("ana",4);
        System.out.println(ana);

        Funcionario gerente = new Gerente("ger",4);
        System.out.println(gerente);

        Funcionario diretor = new Diretor("Big boss", BigDecimal.valueOf(120000));
        System.out.println(diretor);
    }
}
