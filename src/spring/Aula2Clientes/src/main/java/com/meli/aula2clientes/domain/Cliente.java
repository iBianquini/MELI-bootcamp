package com.meli.aula2clientes.domain;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String cpf;
    private String nome;
    private List<Pedido> pedidos;

    public Cliente(String cpf, String nome, List<Pedido> pedidos) {
        this.cpf = cpf;
        this.nome = nome;
        this.pedidos = new ArrayList<>();
    }

    public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public void addPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
