package com.meli.aula2pedidos.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.meli.aula2pedidos.dto.PedidoDTO;
import com.meli.aula2pedidos.dto.PratoDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private int idMesa;
    private List<Prato> pratosSolicitados;
    private BigDecimal total;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime dataPedido;

    public Pedido(int id, int idMesa, List<Prato> pratosSolicitados, BigDecimal total, LocalDateTime dataPedido) {
        this.id = id;
        this.idMesa = idMesa;
        this.pratosSolicitados = pratosSolicitados;
        this.total = total;
        this.dataPedido = dataPedido;
    }

    public Pedido(int id, int idMesa, List<Prato> pratos) {
        this.id = id;
        this.idMesa = idMesa;
        this.pratosSolicitados = pratos;
        this.total = BigDecimal.valueOf(0);
        for (Prato prato:this.pratosSolicitados) {
            var soma = prato.getValor().multiply(BigDecimal.valueOf(prato.getQuantidade()));
            this.total = this.total.add(soma);
        }
        this.dataPedido = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public List<Prato> getPratosSolicitados() {
        return pratosSolicitados;
    }

    public void setPratosSolicitados(List<Prato> pratosSolicitados) {
        this.pratosSolicitados = pratosSolicitados;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public PedidoDTO castToDTO(){
        var pratosDto = new ArrayList<PratoDTO>();

        for (Prato prato:this.pratosSolicitados) {
            pratosDto.add(prato.castToDTO());
        }

        return new PedidoDTO(pratosDto,this.total);
    }
}
