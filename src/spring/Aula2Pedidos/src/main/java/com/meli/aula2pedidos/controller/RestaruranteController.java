package com.meli.aula2pedidos.controller;

import com.meli.aula2pedidos.domain.Pedido;
import com.meli.aula2pedidos.domain.Prato;
import com.meli.aula2pedidos.dto.MesaDTO;
import com.meli.aula2pedidos.dto.PedidoDTO;
import com.meli.aula2pedidos.dto.PratoDTO;
import com.meli.aula2pedidos.repository.RestaruranteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/restaurante")
public class RestaruranteController {

    private RestaruranteRepository repository = new RestaruranteRepository();


    @RequestMapping(value = "/mesa", method = RequestMethod.GET)
    public ResponseEntity<Integer> comecarConta(){
        var mesa = repository.createMesa();

        return new ResponseEntity<>(mesa.getId(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/pedir/{idMesa}", method = RequestMethod.POST)
    public ResponseEntity<PedidoDTO> pedir(@RequestBody List<PratoDTO> pratosDto, @PathVariable int idMesa){
        List<Prato> pratos = new ArrayList<>();

        for (PratoDTO dto:pratosDto) {
            pratos.add(dto.castToPrato());
        }

        var pedido =  repository.CreatePedido(pratos,idMesa);
        repository.addPedidoToMesa(pedido,idMesa);

        return new ResponseEntity<>(pedido.castToDTO(),HttpStatus.CREATED);
    }

    @RequestMapping("/mesa/ver-conta/{idMesa}")
    public MesaDTO verConta(@PathVariable int idMesa){
        var mesa = repository.findMesabyId(idMesa);

        return mesa.castToDTO();
    }

    @RequestMapping("/mesa/fechar-conta/{idMesa}")
    public ResponseEntity fecharConta(@PathVariable int idMesa){
        repository.fecharConta(idMesa);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping("/caixa")
    public BigDecimal verCaixa(){
        return repository.getCaixa();
    }
}
