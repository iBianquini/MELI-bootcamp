package com.meli.aula2pedidos.domain;

import com.meli.aula2pedidos.dto.PratoDTO;

import java.math.BigDecimal;

public class Prato {

    private int id;
    private String descricao;
    private int quantidade;
    private BigDecimal valor;

    public Prato(int id, String descricao, int quantidade, BigDecimal valor) {
        this.id = id;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public PratoDTO castToDTO(){
        return new PratoDTO(this.descricao,this.quantidade,this.valor);
    }
}
