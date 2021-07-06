package com.meli.aula2pedidos.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.aula2pedidos.domain.Mesa;
import com.meli.aula2pedidos.domain.Pedido;
import com.meli.aula2pedidos.domain.Prato;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RestaruranteRepository {
    private static final String PEDIDOS_JSON_FILE = "restaurante.json";

    private List<Mesa> mesas;

    public RestaruranteRepository() {
        this.mesas = new ArrayList<>();
    }

    public int createMesa(int id){
        var mesa = new Mesa(id);
        this.mesas.add(mesa);
        this.saveData();
        return id;
    }

    public void addPedidoToMesa(Pedido pedido, int id){
        var mesa = findMesabyId(id);
        mesa.addPedido(pedido);
        this.saveData();
    }

    public Pedido createPedido(List<Prato> pratos, int idMesa, int idPedido){
        return new Pedido(idPedido,idMesa, pratos);
    }

    public BigDecimal fecharConta(int idMesa){
        var mesa = this.findMesabyId(idMesa);

        var totalMesa = mesa.getTotalConsumido();

        mesa.fecharMesa();

        this.saveData();

        return totalMesa;
    }


    public Mesa findMesabyId(int id){
        return mesas.stream().filter(mesa -> mesa.getId() == id).findFirst().get();
    }

    public BigDecimal getCaixa(LocalDateTime data) {
        return this.mesas.stream()
                .filter(x -> x.getPedidos().get(0).getDataPedido().truncatedTo(ChronoUnit.DAYS).isEqual(data.truncatedTo(ChronoUnit.DAYS)))
                .map(Mesa::getTotalConsumido)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private void saveData(){
        try {
            File file = this.getJson();
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.writeValue(file, this.mesas);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private File getJson() throws FileNotFoundException, MalformedURLException {
        try {
            return ResourceUtils.getFile("classpath:" + RestaruranteRepository.PEDIDOS_JSON_FILE);
        } catch (Exception e){
            return new File(RestaruranteRepository.PEDIDOS_JSON_FILE);
        }
    }

}
