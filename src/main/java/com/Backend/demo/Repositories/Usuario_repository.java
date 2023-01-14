package com.Backend.demo.Repositories;

import com.Backend.demo.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Usuario_repository extends JpaRepository<Usuario,Integer>{
    
}