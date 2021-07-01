package com.meli.aula2clientes.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.meli.aula2clientes.domain.Pedido;
import com.meli.aula2clientes.domain.Produto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PedidoDTO {
    @JsonIgnore
    private static int ID = 1;

    private List<ProdutoDTO> produtos;
    private BigDecimal total;

    public PedidoDTO(List<ProdutoDTO> produtos, BigDecimal total) {
        this.produtos = produtos;

        if (total == null && !produtos.isEmpty()){
            this.total = new BigDecimal(0);
            for (ProdutoDTO dto: produtos) {
                var productTotal = dto.getValor().multiply(BigDecimal.valueOf(dto.getQuantidade()));
                this.total = this.total.add(productTotal);
            }
        }else
            this.total = total;
    }

    public List<ProdutoDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoDTO> produtos) {
        this.produtos = produtos;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Pedido castToPedido(){
        var produtos = new ArrayList<Produto>();

        for (ProdutoDTO dto:this.produtos) {
            produtos.add(dto.castToProduto());
        }

        return new Pedido(ID,produtos,this.total);
    }
}
