package com.meli.aula1crud.repository;

import com.meli.aula1crud.domain.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutosRepository {

    List<Produto> produtos;

    public ProdutosRepository() {
        this.produtos = new ArrayList<>();
    }

    public void addProduto(Produto produto){
        this.produtos.add(produto);
    }

    private Produto findById(int id) throws RuntimeException{
        var productFound = this.produtos.stream().findFirst().filter(x -> x.getId() == id);

        if (productFound.isEmpty())
            throw new RuntimeException("Produto nao encontrado");

        return productFound.get();
    }

    public boolean removeProduct(int id){
        var productToDelete = this.findById(id);

        return this.produtos.remove(productToDelete);
    }

    public List<Produto> getAll(){
        return this.produtos;
    }

    public boolean updateProduct(int id, Produto prod){
        var productToUpdate = this.findById(id);

        if (productToUpdate == null) return false;

        productToUpdate.setNome(prod.getNome());
        productToUpdate.setMarca(prod.getMarca());
        productToUpdate.setValor(prod.getValor());
        productToUpdate.setQtd(prod.getQtd());

        return true;
    }
}
