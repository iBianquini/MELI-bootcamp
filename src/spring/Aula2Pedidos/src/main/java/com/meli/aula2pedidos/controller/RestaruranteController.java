package com.meli.aula2pedidos.controller;

import com.meli.aula2pedidos.domain.Pedido;
import com.meli.aula2pedidos.domain.Prato;
import com.meli.aula2pedidos.dto.MesaDTO;
import com.meli.aula2pedidos.dto.PedidoDTO;
import com.meli.aula2pedidos.dto.PratoDTO;
import com.meli.aula2pedidos.repository.RestaruranteRepository;
import com.meli.aula2pedidos.service.RestaruranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/restaurante")
public class RestaruranteController {

    @Autowired
    RestaruranteService service;


    @RequestMapping(value = "/mesa", method = RequestMethod.GET)
    public ResponseEntity<Integer> comecarConta(){
        var mesaId = service.createMesa();

        return new ResponseEntity<>(mesaId, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/pedir/{idMesa}", method = RequestMethod.POST)
    public ResponseEntity<PedidoDTO> pedir(@RequestBody List<PratoDTO> pratosDto, @PathVariable int idMesa){
        List<Prato> pratos = new ArrayList<>();

        for (PratoDTO dto:pratosDto) {
            pratos.add(dto.castToPrato());
        }

        var pedido =  service.createPedido(pratos,idMesa);
        var pedidoDTO = service.addPedidoToMesa(pedido,idMesa);

        return new ResponseEntity<>(pedidoDTO,HttpStatus.CREATED);
    }

    @RequestMapping("/mesa/ver-conta/{idMesa}")
    public MesaDTO verConta(@PathVariable int idMesa){
        var mesaDTO = service.verConta(idMesa);

        return mesaDTO;
    }

    @RequestMapping("/mesa/fechar-conta/{idMesa}")
    public ResponseEntity<String> fecharConta(@PathVariable int idMesa){
        var total= service.fecharConta(idMesa);
        return new ResponseEntity<>(total, HttpStatus.OK);
    }

    @RequestMapping("/caixa")
    public BigDecimal verCaixa(){
        return service.getCaixa(LocalDateTime.now());
    }
}
