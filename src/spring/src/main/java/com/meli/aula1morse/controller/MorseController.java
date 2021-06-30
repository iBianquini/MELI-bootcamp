package com.meli.aula1morse.controller;

import com.meli.aula1morse.service.MorseService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController  {

    MorseService morseService = new MorseService();

    @RequestMapping("/morse/{morse}")
    public String decryptMorse(@PathVariable String morse){
        return morseService.morseResolver(morse);
    }

}
