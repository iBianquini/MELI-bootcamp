package com.meli.aula3starwars.service;

import com.meli.aula3starwars.domain.Character;
import com.meli.aula3starwars.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository repository;

    public List<Character> getCharactersByName(String name){
        return repository.getCharactersByName(name);
    }
}
