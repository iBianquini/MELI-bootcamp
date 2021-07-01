package com.meli.aula2pedidos.dto;

import com.meli.aula2pedidos.domain.Pedido;
import com.meli.aula2pedidos.domain.Prato;

import java.math.BigDecimal;

public class PratoDTO {

    private static int ID = 1;
    private String descricao;
    private int quantidade;
    private BigDecimal valor;

    public PratoDTO(String descricao, int quantidade, BigDecimal valor) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valor = valor;
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

    public Prato castToPrato(){
        return new Prato(ID++,this.descricao,this.quantidade,this.valor);
    }
}
