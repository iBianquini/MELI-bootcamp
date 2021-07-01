package com.meli.aula2pedidos.dto;

import com.meli.aula2pedidos.domain.Pedido;

import java.math.BigDecimal;
import java.util.List;

public class MesaDTO {
    private List<PedidoDTO> pedidos;
    private BigDecimal totalConsumido;

    public MesaDTO(List<PedidoDTO> pedidos, BigDecimal totalConsumido) {
        this.pedidos = pedidos;
        this.totalConsumido = totalConsumido;
    }

    public List<PedidoDTO> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<PedidoDTO> pedidos) {
        this.pedidos = pedidos;
    }

    public BigDecimal getTotalConsumido() {
        return totalConsumido;
    }

    public void setTotalConsumido(BigDecimal totalConsumido) {
        this.totalConsumido = totalConsumido;
    }
}
