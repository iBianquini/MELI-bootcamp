package com.meli.aula2clientes.controller;

import com.meli.aula2clientes.dto.ClienteDTO;
import com.meli.aula2clientes.dto.PedidoDTO;
import com.meli.aula2clientes.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastroCliente(@RequestBody ClienteDTO clienteDto) {
        clientService.cadastrarCliente(clienteDto);
    }

    @RequestMapping(value = "/fazer-pedido/{clientCPF}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public PedidoDTO fazerPedido(@PathVariable String clientCPF, @RequestBody PedidoDTO pedidoDTO) {
        clientService.fazerPedido(clientCPF, pedidoDTO);

        return pedidoDTO;
    }

    @RequestMapping(value = "/ver-pedidos/{clientCPF}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.FOUND)
    public List<PedidoDTO> pedidosPorCliente(@PathVariable String clientCPF) {
        return clientService.findPedidoByClientCPF(clientCPF);
    }

    @RequestMapping(value = "/ver-caixa", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal getEntradasDeCaixaDiaria() {
        return clientService.getEntradasDeCaixa();
    }
}
