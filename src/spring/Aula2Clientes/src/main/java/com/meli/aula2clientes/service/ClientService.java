package com.meli.aula2clientes.service;

import com.meli.aula2clientes.dto.ClienteDTO;
import com.meli.aula2clientes.dto.PedidoDTO;
import com.meli.aula2clientes.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public void cadastrarCliente(ClienteDTO clienteDto) {
        this.repository.cadastrarCliente(clienteDto);
    }

    public void fazerPedido(String clientCPF, PedidoDTO pedidoDTO) {
        this.repository.fazerPedido(clientCPF, pedidoDTO);
    }

    public List<PedidoDTO> findPedidoByClientCPF(String clientCPF) {
        return this.repository.findPedidoByClientCPF(clientCPF);
    }

    public BigDecimal getEntradasDeCaixa() {
        return this.repository.getEntradasDeCaixa(LocalDate.now());
    }
}
