package com.meli.aula2pedidos.dto;

import com.meli.aula2pedidos.domain.Prato;

import java.math.BigDecimal;
import java.util.List;

public class PedidoDTO {
    private List<PratoDTO> pratosSolicitados;
    private BigDecimal total;

    public PedidoDTO(List<PratoDTO> pratosSolicitados, BigDecimal total) {
        this.pratosSolicitados = pratosSolicitados;
        this.total = total;
    }

    public List<PratoDTO> getPratosSolicitados() {
        return pratosSolicitados;
    }

    public void setPratosSolicitados(List<PratoDTO> pratosSolicitados) {
        this.pratosSolicitados = pratosSolicitados;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
