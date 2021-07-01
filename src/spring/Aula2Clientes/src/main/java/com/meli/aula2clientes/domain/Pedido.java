package com.meli.aula2clientes.domain;

import com.meli.aula2clientes.dto.PedidoDTO;
import com.meli.aula2clientes.dto.ProdutoDTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private List<Produto> produtos;
    private BigDecimal total;

    public Pedido(int id, List<Produto> produtos, BigDecimal total) {
        this.id = id;
        this.produtos = produtos;
        this.total = total;
    }

    public Pedido(int id) {
        this.id = id;
        this.produtos = new ArrayList<>();
        this.total = new BigDecimal(0);
    }

    public void addProduto(Produto produto){
        this.produtos.add(produto);
        var productTotal = produto.getValor().multiply(BigDecimal.valueOf(produto.getQuantidade()));
        this.total = this.total.add(productTotal);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public PedidoDTO castToDTO(){
        var produtosDTO = new ArrayList<ProdutoDTO>();

        for (Produto prod:this.produtos) {
            produtosDTO.add(prod.castToDto());
        }

        return new PedidoDTO(produtosDTO,total);
    }
}
