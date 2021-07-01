package com.meli.aula2pedidos.repository;

import com.meli.aula2pedidos.domain.Mesa;
import com.meli.aula2pedidos.domain.Pedido;
import com.meli.aula2pedidos.domain.Prato;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RestaruranteRepository {
    private static int ID_MESA = 1;
    private static int ID_PEDIDO = 1;
    private List<Mesa> mesas;
    private BigDecimal caixa;

    public RestaruranteRepository() {
        this.mesas = new ArrayList<>();
        this.caixa = new BigDecimal(0);
    }

    public Mesa createMesa(){
        var mesa = new Mesa(ID_MESA);
        this.mesas.add(mesa);
        return mesa;
    }

    public void addPedidoToMesa(Pedido pedido, int id){
        var mesa = findMesabyId(id);
        mesa.addPedido(pedido);
    }

    public Pedido CreatePedido(List<Prato> pratos, int idMesa){
        return new Pedido(ID_PEDIDO,idMesa, pratos);
    }

    public void fecharConta(int idMesa){
        var mesa = this.findMesabyId(idMesa);

        this.caixa = this.caixa.add(mesa.getTotalConsumido());
        mesa.limparMesa();
    }


    public Mesa findMesabyId(int id){
        return mesas.stream().filter(mesa -> mesa.getId() == id).findFirst().get();
    }

    public BigDecimal getCaixa() {
        return caixa;
    }
}
