package com.meli.aula1crud.domain;

import java.math.BigDecimal;

public class Produto {
    private Integer id;
    private String nome;
    private String marca;
    private BigDecimal valor;
    private int qtd;

    public Produto(Integer id, String nome, String marca, double valor, int qtd) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.valor = BigDecimal.valueOf(valor);
        this.qtd = qtd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
}
