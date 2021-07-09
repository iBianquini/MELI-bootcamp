package com.meli.aula2clientes.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.aula2clientes.domain.Cliente;
import com.meli.aula2clientes.domain.Pedido;
import com.meli.aula2clientes.dto.ClienteDTO;
import com.meli.aula2clientes.dto.PedidoDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class ClientRepository {

    private final List<Cliente> clientes;
    private static final String CLIENTES_JSON_FILE = "clientes.json";


    public ClientRepository() {
        this.clientes = new ArrayList<>();
    }

    public Cliente cadastrarCliente(ClienteDTO dto) {
        var cliente = dto.castToClient();

        this.clientes.add(cliente);
        this.saveData();
        return cliente;
    }

    public void fazerPedido(String clientCPF, PedidoDTO pedidoDTO) {
        var pedido = pedidoDTO.castToPedido();
        var cliente = this.findClienteByCPF(clientCPF);
        cliente.addPedido(pedido);
        this.saveData();
    }

    public List<PedidoDTO> findPedidoByClientCPF(String cpf) {
        var cliente = this.findClienteByCPF(cpf);

        var pedidos = new ArrayList<PedidoDTO>();

        for (Pedido ped : cliente.getPedidos()) {
            pedidos.add(ped.castToDTO());
        }
        return pedidos;
    }

    private void saveData() {
        try {
            File file = this.getJson();
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.writeValue(file, this.clientes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File getJson() throws FileNotFoundException, MalformedURLException {
        try {
            return ResourceUtils.getFile("classpath:" + CLIENTES_JSON_FILE);
        } catch (Exception e) {
            return new File(CLIENTES_JSON_FILE);
        }
    }


    public Cliente findClienteByCPF(String cpf) {
        return this.clientes.stream().filter(x -> x.getCpf().equals(cpf)).findFirst().orElseThrow();
    }

    public BigDecimal getEntradasDeCaixa(LocalDate now) {
        var pedidos = this.clientes.stream().map(Cliente::getPedidos).flatMap(Collection::stream);

        return pedidos
                .filter(x -> x.getCreatedAt().isEqual(now))
                .map(Pedido::getTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);


    }
}
