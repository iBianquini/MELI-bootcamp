package dakar.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Corrida {
    private double distancia;
    private BigDecimal premioEmDolares;
    private String nome;
    private int qtdVeiculosPermitidos;
    List<Veiculo> listaVeiculos;

    public Corrida(double distancia, BigDecimal premioEmDolares, String nome, int qtdVeiculosPermitidos) {
        this.distancia = distancia;
        this.premioEmDolares = premioEmDolares;
        this.nome = nome;
        this.qtdVeiculosPermitidos = qtdVeiculosPermitidos;
        this.listaVeiculos = new ArrayList<>();
    }

    public void iniciarCorrida(){
        System.out.println("Corrida iniciou...");
    }


    public void registrarCarro(int velocidade, int aceleracao, int anguloGiro, String placa) throws RuntimeException {
        if (listaVeiculos.size() < qtdVeiculosPermitidos)
            listaVeiculos.add(new Carro(velocidade,aceleracao,anguloGiro,placa));
        else
            throw new RuntimeException("Limite de veiculos atingido.");
    }

    public void registrarMoto(int velocidade, int aceleracao, int anguloGiro, String placa) throws RuntimeException {
        if (listaVeiculos.size() < qtdVeiculosPermitidos){
            listaVeiculos.add(new Moto(velocidade,aceleracao,anguloGiro,placa));
        }else
            throw new RuntimeException("Limite de veiculos atingido.");
    }

    public void removerVeiculo(Veiculo veiculo) throws RuntimeException{
        if (!listaVeiculos.remove(veiculo));
        throw new RuntimeException("Veiculo nao estava pesente na corrida");
    }

    public void removerVeiculo(String placa) throws RuntimeException{
        var veiculoToRemove = listaVeiculos.stream().findFirst().filter(x -> x.getPlaca().equals(placa));
        if (veiculoToRemove.isPresent())
            listaVeiculos.remove(veiculoToRemove.get());
        else
            throw new RuntimeException("Veiculo nao estava pesente na corrida");
    }

    public Veiculo definirVencedor(){
        var context = new Object() {
            Veiculo winner = null;
        };
        listaVeiculos.forEach(x -> {
            if (context.winner == null)
                context.winner = x;
            else {
                var winnerStats = calculateStats(context.winner);
                var currentStats =  calculateStats(x);

                if (currentStats > winnerStats)
                    context.winner = x;
            }
        });

        return context.winner;
    }

    private double calculateStats(Veiculo veiculo) {
        return veiculo.getVelocidade() * veiculo.getAceleracao() / (veiculo.getAnguloDeGiro() * (veiculo.getPeso() - veiculo.getRoda() * 100));
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public BigDecimal getPremioEmDolares() {
        return premioEmDolares;
    }

    public void setPremioEmDolares(BigDecimal premioEmDolares) {
        this.premioEmDolares = premioEmDolares;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdVeiculosPermitidos() {
        return qtdVeiculosPermitidos;
    }

    public void setQtdVeiculosPermitidos(int qtdVeiculosPermitidos) {
        this.qtdVeiculosPermitidos = qtdVeiculosPermitidos;
    }

    public List<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }
}
