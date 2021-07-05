package com.meli.aula4linktracker.controller;

import com.meli.aula4linktracker.dto.LinkDTO;
import com.meli.aula4linktracker.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;

@RestController
public class LinkController {

    @Autowired
    LinkService service;

    @RequestMapping(value = "/link", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public int setURL(@RequestBody LinkDTO dto){
        return this.service.addLink(dto);
    }

    @RequestMapping(value ="/link/{id}/{pass}", method = RequestMethod.GET)
    public void getURL(@PathVariable int id, @PathVariable String pass, HttpServletResponse response) {

        var link = "https://" + service.getLink(id,pass).toString();
        response.setStatus(302);
        response.setHeader("Location", link);
    }

    @RequestMapping(value = "/metrics/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String getMetrics(@PathVariable int id){

        return this.service.getMetrics(id);
    }

    @RequestMapping(value = "/invalidate/{id}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.GONE)
    public void invalidateRedirect(@PathVariable int id){
         this.service.invalidateRedirect(id);
    }

}
