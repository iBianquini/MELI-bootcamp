package com.meli.aula2clientes.domain;

import com.meli.aula2clientes.dto.ProdutoDTO;
import com.meli.aula2clientes.enums.CoresEnum;

import java.math.BigDecimal;

public class Produto {
    private int id;
    private String descricao;
    private CoresEnum cor;
    private int quantidade;
    private BigDecimal valor;

    public Produto(int id, String descricao, CoresEnum cor, int quantidade, BigDecimal valor) {
        this.id = id;
        this.descricao = descricao;
        this.cor = cor;
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

    public CoresEnum getCor() {
        return cor;
    }

    public void setCor(CoresEnum cor) {
        this.cor = cor;
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

    public ProdutoDTO castToDto(){
        return new ProdutoDTO(this.descricao,this.cor,this.quantidade,this.valor);
    }
}
