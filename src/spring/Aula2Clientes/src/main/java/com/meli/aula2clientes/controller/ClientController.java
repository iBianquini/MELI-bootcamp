package com.meli.aula2clientes.controller;

import com.meli.aula2clientes.domain.Cliente;
import com.meli.aula2clientes.dto.ClienteDTO;
import com.meli.aula2clientes.dto.PedidoDTO;
import com.meli.aula2clientes.repository.ClientRepsitory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientController {

    private ClientRepsitory clientRepsitory = new ClientRepsitory();

    @RequestMapping(value = "/cadastrar",method = RequestMethod.POST)
    public ResponseEntity cadastroCliente(@RequestBody ClienteDTO clienteDto){
        clientRepsitory.cadastrarCliente(clienteDto);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/fazer-pedido/{clientCPF}",method = RequestMethod.POST)
    public ResponseEntity<PedidoDTO> fazerPedido(@PathVariable String clientCPF, @RequestBody PedidoDTO pedidoDTO){
        clientRepsitory.fazerPedido(clientCPF,pedidoDTO);

        return new ResponseEntity<>(pedidoDTO, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/ver-pedidos/{clientCPF}",method = RequestMethod.GET)
    public List<PedidoDTO> pedidosPorCliente(@PathVariable String clientCPF){
        return clientRepsitory.findPedidoByClientCPF(clientCPF);
    }
}
