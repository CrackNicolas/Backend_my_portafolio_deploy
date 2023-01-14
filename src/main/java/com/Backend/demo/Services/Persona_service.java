package com.Backend.demo.Services;

import com.Backend.demo.Interfaces.Persona_interface;
import com.Backend.demo.Models.Persona;
import com.Backend.demo.Repositories.Persona_repository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Persona_service implements Persona_interface{
    @Autowired
    private Persona_repository persona_repository;
    
    @Override
    public Persona Add_persona(Persona persona) {
        return persona_repository.save(persona);
    }

    @Override
    public Optional<Persona> Get_persona(int id_persona) {
        return persona_repository.findById(id_persona);
    }
}