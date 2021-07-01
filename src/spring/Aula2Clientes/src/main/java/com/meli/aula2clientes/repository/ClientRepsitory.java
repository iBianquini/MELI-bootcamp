package com.meli.aula2clientes.repository;

import com.meli.aula2clientes.domain.Cliente;
import com.meli.aula2clientes.domain.Pedido;
import com.meli.aula2clientes.dto.ClienteDTO;
import com.meli.aula2clientes.dto.PedidoDTO;

import java.util.ArrayList;
import java.util.List;

public class ClientRepsitory {

    private List<Cliente> clientes;

    public ClientRepsitory() {
        this.clientes = new ArrayList<>();
    }

    public Cliente cadastrarCliente(ClienteDTO dto){
        var cliente = dto.castToClient();

        this.clientes.add(cliente);
        return cliente;
    }

    public void fazerPedido(String clientCPF, PedidoDTO pedidoDTO){
        var pedido = pedidoDTO.castToPedido();
        var cliente = this.findClienteByCPF(clientCPF);
        cliente.addPedido(pedido);
    }

    public List<PedidoDTO> findPedidoByClientCPF(String cpf){
        var cliente = this.findClienteByCPF(cpf);

        var pedidos = new ArrayList<PedidoDTO>();

        for (Pedido ped: cliente.getPedidos()) {
            pedidos.add(ped.castToDTO());
        }
        return pedidos;
    }


    public Cliente findClienteByCPF(String cpf){
        return this.clientes.stream().filter(x -> x.getCpf().equals(cpf)).findFirst().get();
    }
}
