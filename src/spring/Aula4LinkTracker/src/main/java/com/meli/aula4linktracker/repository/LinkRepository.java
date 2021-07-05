package com.meli.aula4linktracker.repository;

import com.meli.aula4linktracker.dto.LinkDTO;
import com.meli.aula4linktracker.exception.RecursoNaoEncontradoException;
import org.springframework.stereotype.Repository;

import java.net.URI;
import java.util.HashMap;

@Repository
public class LinkRepository {

    private final HashMap<Integer, LinkDTO> redirects;

    public LinkRepository() {
        this.redirects = new HashMap<>();
    }

    public int addRedirectLink(int id, LinkDTO link){
        this.redirects.put(id, link);
        return id;
    }

    public void increaseRedirectQtd(int id){
        var result = this.redirects.get(id);

        if (result == null)
            throw new RecursoNaoEncontradoException("Id nao encontrado");
       result.increaseRedirect();
    }

    public int getStatistics(int id){
        var result =  this.redirects.get(id);
        if (result == null)
            throw new RecursoNaoEncontradoException("Id nao encontrado");
        return result.getQtdRedirect();
    }

    public void deleteLink(int id){
         if (this.redirects.remove(id) == null)
             throw new RecursoNaoEncontradoException("Id nao encontrado");
    }

    public URI getLinkedUrl(int id, String password){
        var dto = this.redirects.get(id);

        if (dto == null)
            throw new RecursoNaoEncontradoException("Id nao encontrado");


        if (dto.getPassword().equals(password))
            return dto.getLink();
        throw new RecursoNaoEncontradoException("Senha invalida");
    }
}
