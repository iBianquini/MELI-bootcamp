package fundamentos.Aula2TM.src.main.java.domain;


import org.apache.commons.math3.fraction.Fraction;

import java.util.HashMap;
import java.util.Map;

public class Fracao {

    private int numerador;
    private int denominador;

    public Fracao(double valorFracionado) {
        Fraction f = new Fraction(valorFracionado);
        this.numerador = f.getNumerator();
        this.denominador = f.getDenominator();
    }

    public Fracao(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public Map<Integer, Integer> adicionar(int numerador, int denominador){
        Fraction local = new Fraction(this.numerador,this.denominador);
        Fraction f = new Fraction(numerador,denominador);

        local = local.add(f);
        this.denominador = local.getDenominator();
        this.numerador = local.getNumerator();
        return new HashMap<>(local.getNumerator(),local.getDenominator());
    }

    public Map<Integer, Integer> adicionar(double valor){
        Fraction local = new Fraction(this.numerador,this.denominador);
        Fraction f = new Fraction(valor);

        local = local.add(f);
        this.denominador = local.getDenominator();
        this.numerador = local.getNumerator();
        return new HashMap<>(local.getNumerator(),local.getDenominator());
    }

    public Map<Integer, Integer> subtrair(int numerador, int denominador){
        Fraction local = new Fraction(this.numerador,this.denominador);
        Fraction f = new Fraction(numerador,denominador);

        local = local.subtract(f);
        this.denominador = local.getDenominator();
        this.numerador = local.getNumerator();
        return new HashMap<>(local.getNumerator(),local.getDenominator());
    }

    public Map<Integer, Integer> subtrair(double valor){
        Fraction local = new Fraction(this.numerador,this.denominador);
        Fraction f = new Fraction(valor);

        local = local.subtract(f);
        this.denominador = local.getDenominator();
        this.numerador = local.getNumerator();
        return new HashMap<>(local.getNumerator(),local.getDenominator());
    }

    public Map<Integer, Integer> mult(int numerador, int denominador){
        Fraction local = new Fraction(this.numerador,this.denominador);
        Fraction f = new Fraction(numerador,denominador);

        local = local.multiply(f);
        this.denominador = local.getDenominator();
        this.numerador = local.getNumerator();
        return new HashMap<>(local.getNumerator(),local.getDenominator());
    }

    public Map<Integer, Integer> mult(double valor){
        Fraction local = new Fraction(this.numerador,this.denominador);
        Fraction f = new Fraction(valor);

        local = local.multiply(f);
        this.denominador = local.getDenominator();
        this.numerador = local.getNumerator();
        return new HashMap<>(local.getNumerator(),local.getDenominator());
    }

    public Map<Integer, Integer> div(int numerador, int denominador){
        Fraction local = new Fraction(this.numerador,this.denominador);
        Fraction f = new Fraction(numerador,denominador);

        local = local.divide(f);
        this.denominador = local.getDenominator();
        this.numerador = local.getNumerator();
        return new HashMap<>(local.getNumerator(),local.getDenominator());
    }

    public Map<Integer, Integer> div(double valor){
        Fraction local = new Fraction(this.numerador,this.denominador);
        Fraction f = new Fraction(valor);

        local = local.divide(f);
        this.denominador = local.getDenominator();
        this.numerador = local.getNumerator();
        return new HashMap<>(local.getNumerator(),local.getDenominator());
    }

    @Override
    public String toString() {
        return "Fracao{" + numerador + "/" + denominador+
                '}';
    }
}
