package com.meli.aula1crud.controller;

import com.meli.aula1crud.domain.Produto;
import com.meli.aula1crud.repository.ProdutosRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/produtos")
public class ProdutosController {

    ProdutosRepository produtosRepository = new ProdutosRepository();

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Produto> addProd(@RequestBody Produto prod){
        produtosRepository.addProduto(prod);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Produto>> getAllProds(){
        var prods = produtosRepository.getAll();

        return new ResponseEntity<>(prods, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteProd(@PathVariable int id){
        var isDeleted = produtosRepository.removeProduct(id);

        return isDeleted
                ? new ResponseEntity(HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateProd(@PathVariable int id, @RequestBody Produto produto){
        var isUpdated = produtosRepository.updateProduct(id, produto);

        return isUpdated
                ? new ResponseEntity(HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
