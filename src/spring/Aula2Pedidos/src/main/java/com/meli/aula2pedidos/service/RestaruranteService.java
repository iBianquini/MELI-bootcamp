package com.meli.aula2pedidos.service;

import com.meli.aula2pedidos.domain.Mesa;
import com.meli.aula2pedidos.domain.Pedido;
import com.meli.aula2pedidos.domain.Prato;
import com.meli.aula2pedidos.dto.MesaDTO;
import com.meli.aula2pedidos.dto.PedidoDTO;
import com.meli.aula2pedidos.repository.RestaruranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class RestaruranteService {

    private static int ID_MESA = 1;
    private static int ID_PEDIDO = 1;

    @Autowired
    RestaruranteRepository repository;

    public int createMesa(){
        return repository.createMesa(ID_MESA++);
    }

    public Pedido createPedido(List<Prato> pratos, int idMesa){
        return repository.createPedido(pratos,idMesa, ID_PEDIDO++);
    }

    public PedidoDTO addPedidoToMesa(Pedido pedido, int idMesa){
        repository.addPedidoToMesa(pedido,idMesa);
        return pedido.castToDTO();
    }

    public MesaDTO verConta(int idMesa){
        return repository.findMesabyId(idMesa).castToDTO();
    }

    public String fecharConta(int idMesa){
        return "Valor total pedidos: R$" + repository.fecharConta(idMesa).toString();
    }

    public BigDecimal getCaixa(LocalDateTime data){
        return repository.getCaixa(data);
    }
}
