package com.meli.aula2clientes.dto;

import com.meli.aula2clientes.domain.Produto;
import com.meli.aula2clientes.enums.CoresEnum;

import java.math.BigDecimal;

public class ProdutoDTO {

    private String descricao;
    private CoresEnum cor;
    private int quantidade;
    private BigDecimal valor;

    public ProdutoDTO(String descricao, CoresEnum cor, int quantidade, BigDecimal valor) {
        this.descricao = descricao;
        this.cor = cor;
        this.quantidade = quantidade;
        this.valor = valor;
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

    public Produto castToProduto() {
        int ID = 1;
        return new Produto(ID, this.descricao, this.cor, this.quantidade, this.valor);
    }
}
