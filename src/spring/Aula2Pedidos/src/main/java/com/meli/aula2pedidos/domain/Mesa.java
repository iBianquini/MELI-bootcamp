package com.meli.aula2pedidos.domain;

import com.meli.aula2pedidos.dto.MesaDTO;
import com.meli.aula2pedidos.dto.PedidoDTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Mesa {
    private int id;
    private List<Pedido> pedidos;
    private BigDecimal totalConsumido;

    public Mesa(int id, List<Pedido> pedidos, BigDecimal totalConsumido) {
        this.id = id;
        this.pedidos = pedidos;
        this.totalConsumido = totalConsumido;
    }

    public Mesa(int id) {
        this.id = id;
        this.pedidos = new ArrayList<>();
        this.totalConsumido = new BigDecimal(0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public BigDecimal getTotalConsumido() {
        return totalConsumido;
    }

    public void addPedido(Pedido pedido){
        this.pedidos.add(pedido);
        this.totalConsumido = this.totalConsumido.add(pedido.getTotal());
    }

    public void setTotalConsumido(BigDecimal totalConsumido) {
        this.totalConsumido = totalConsumido;
    }

    public void limparMesa(){
        this.totalConsumido = BigDecimal.valueOf(0);
        this.pedidos = new ArrayList<>();
    }

    public MesaDTO castToDTO() {
        var pedidosDto = new ArrayList<PedidoDTO>();

        for (Pedido pedido:this.pedidos) {
            pedidosDto.add(pedido.castToDTO());
        }

        return new MesaDTO(pedidosDto,this.totalConsumido);
    }
}
