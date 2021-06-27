package Aula1.src.com.company.ex2.domain;

import java.util.Arrays;

public class CarrinhoCompra {
    private Produto[] produtos;
    private double total;

    public CarrinhoCompra(Produto[] produtos) {
        this.produtos = produtos;
        this.total = 0;
        for (Produto produto: produtos) {
            this.total += produto.getValor() * produto.getQuantidade();
        }
    }

    public Produto[] getProdutos() {
        return produtos;
    }

    public void setProdutos(Produto[] produtos) {
        this.produtos = produtos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "CarrinhoCompra{" +
                "produtos=" + Arrays.toString(produtos) +
                "\n\ntotal=" + total +
                '}';
    }
}
