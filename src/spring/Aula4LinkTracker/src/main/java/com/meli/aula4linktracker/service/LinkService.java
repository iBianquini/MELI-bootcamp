package com.meli.aula4linktracker.service;

import com.meli.aula4linktracker.dto.LinkDTO;
import com.meli.aula4linktracker.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class LinkService {
    private static int AUTO_GENERATED_ID = 1;

    private LinkRepository repository = new LinkRepository();

    public int addLink(LinkDTO link){
        return this.repository.addRedirectLink(AUTO_GENERATED_ID++,link);
    }

    public URI getLink(int id, String password){
        this.repository.increaseRedirectQtd(id);
        return this.repository.getLinkedUrl(id, password);
    }

    public String getMetrics(int id){
        return "Total de visitas: " + this.repository.getStatistics(id);
    }

    public void invalidateRedirect(int id){
        this.repository.deleteLink(id);
    }
}
