package com.meli.aula2clientes.dto;

import com.meli.aula2clientes.domain.Cliente;
import com.meli.aula2clientes.domain.Pedido;
import com.meli.aula2clientes.domain.Produto;

import java.util.List;

public class ClienteDTO {
    private String cpf;
    private String Nome;

    private List<Pedido> produtos;

    public ClienteDTO(String cpf, String nome, List<Pedido> produtos) {
        this.cpf = cpf;
        Nome = nome;
        this.produtos = produtos;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public List<Pedido> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Pedido> produtos) {
        this.produtos = produtos;
    }

    public Cliente castToClient(){
        return new Cliente(this.cpf, this.Nome, this.produtos);
    }
}
