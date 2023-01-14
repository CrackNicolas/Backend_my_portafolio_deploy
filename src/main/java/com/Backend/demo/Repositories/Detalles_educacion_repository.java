package com.Backend.demo.Repositories;

import com.Backend.demo.Models.Detalles_educacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Detalles_educacion_repository extends JpaRepository<Detalles_educacion,Integer>{
    @Query(value = "select *from detalles_educacion where id_educacion = :id_educacion ", nativeQuery = true)
    List<Detalles_educacion> get_detalles_educacion(@Param("id_educacion") int id_educacion);
}