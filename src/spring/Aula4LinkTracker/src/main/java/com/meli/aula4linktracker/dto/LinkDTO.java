package com.meli.aula4linktracker.dto;

import java.net.URI;

public class LinkDTO {
    private URI link;
    private int qtdRedirect;
    private String password;

    public LinkDTO(URI link, int qtdRedirect, String password) {
        this.link = link;
        this.qtdRedirect = qtdRedirect;
        this.password = password;
    }

    public LinkDTO(URI link) {
        this.link = link;
        this.qtdRedirect = 0;
    }

    public void increaseRedirect(){
        this.qtdRedirect++;
    }

    public URI getLink() {
        return link;
    }

    public void setLink(URI link) {
        this.link = link;
    }

    public int getQtdRedirect() {
        return qtdRedirect;
    }

    public void setQtdRedirect(int qtdRedirect) {
        this.qtdRedirect = qtdRedirect;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
