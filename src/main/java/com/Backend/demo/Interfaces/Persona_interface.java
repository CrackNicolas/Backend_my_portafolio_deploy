package com.Backend.demo.Interfaces;

import com.Backend.demo.Models.Persona;
import java.util.Optional;

public interface Persona_interface {
    public Persona Add_persona(Persona persona);
    public Optional<Persona> Get_persona(int id_persona);
}