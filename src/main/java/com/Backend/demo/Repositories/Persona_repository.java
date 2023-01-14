package com.Backend.demo.Repositories;

import com.Backend.demo.Models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Persona_repository extends JpaRepository<Persona,Integer>{
    
}