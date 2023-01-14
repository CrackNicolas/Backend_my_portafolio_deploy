package com.Backend.demo.Controllers;

import com.Backend.demo.Models.Detalles_educacion;
import com.Backend.demo.Models.Educacion;
import com.Backend.demo.Repositories.Detalles_educacion_repository;
import com.Backend.demo.Repositories.Educacion_repository;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/detalles_educacion")
@CrossOrigin(origins = "http://localhost:4200")
public class Detalles_educacion_controller {
    @Autowired
    private Detalles_educacion_repository detalles_educacion_repository;
    @Autowired
    private Educacion_repository educacion_repository;
    
    @GetMapping("/get/id/{id_detalle}")
    public ResponseEntity<Detalles_educacion> Get_detalle_educacion(@PathVariable("id_detalle") int id_detalle){
        Optional<Detalles_educacion> detalles_educacion_optional = detalles_educacion_repository.findById(id_detalle);
        
        if(!detalles_educacion_optional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(detalles_educacion_optional.get());
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Detalles_educacion>> Get_detalles_educaciones(){
        return ResponseEntity.ok(detalles_educacion_repository.findAll());
    }
    
    @GetMapping("/all/count")
    public ResponseEntity<Integer> Get_count_detalles_educaciones(){
        return ResponseEntity.ok(detalles_educacion_repository.findAll().size());
    }
    
    @GetMapping("/all/{id_educacion}")
    public ResponseEntity<List<Detalles_educacion>> Get_detalles_educacion(@PathVariable("id_educacion") int id_educacion){
        return ResponseEntity.ok(detalles_educacion_repository.get_detalles_educacion(id_educacion));
    }
    
    @PostMapping("/add")
    public ResponseEntity<Detalles_educacion> Add_educacion(@Valid @RequestBody Detalles_educacion detalles_educacion){
        List<Educacion> educaciones = educacion_repository.findAll();
        
        Educacion educacion = educaciones.get(educaciones.size()-1);
        detalles_educacion.setEducacion(educacion);
    
        Detalles_educacion save_detalles_educacion = detalles_educacion_repository.save(detalles_educacion);
        URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id_detalle}").buildAndExpand(save_detalles_educacion.getId_detalle()).toUri();
        return ResponseEntity.created(ubicacion).body(save_detalles_educacion);
    }
    
    @PostMapping("/add/id/{id_educacion}")
    public ResponseEntity<Detalles_educacion> Add_educacion_id(@PathVariable("id_educacion") int id_educacion, @Valid @RequestBody Detalles_educacion detalles_educacion){
        Optional<Educacion> educacion_optional = educacion_repository.findById(id_educacion);
        
        if(!educacion_optional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        detalles_educacion.setEducacion(educacion_optional.get());
    
        Detalles_educacion save_detalles_educacion = detalles_educacion_repository.save(detalles_educacion);
        URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id_detalle}").buildAndExpand(save_detalles_educacion.getId_detalle()).toUri();
        return ResponseEntity.created(ubicacion).body(save_detalles_educacion);
    }
    
    @PutMapping("/edit/{id_educacion}/id/{id_detalle}")
    public ResponseEntity<Detalles_educacion> Edit_detalles_educacion(@PathVariable("id_educacion") int id_educacion, @PathVariable("id_detalle") int id_detalle, @Valid @RequestBody Detalles_educacion detalles_educacion){
        Optional<Educacion> educacion_optional = educacion_repository.findById(id_educacion);
        
        if(!educacion_optional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        Optional<Detalles_educacion> detalles_educacion_optional = detalles_educacion_repository.findById(id_detalle);
        if(!detalles_educacion_optional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        detalles_educacion.setEducacion(educacion_optional.get());
        detalles_educacion.setId_detalle(detalles_educacion_optional.get().getId_detalle());
        detalles_educacion_repository.save(detalles_educacion);
        
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/delete/id/{id_detalle}")
    public ResponseEntity<Detalles_educacion> Delete_educacion(@PathVariable("id_detalle") int id_detalle){
        Optional<Detalles_educacion> detalles_educacion_optional = detalles_educacion_repository.findById(id_detalle);
        if(!detalles_educacion_optional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        detalles_educacion_repository.delete(detalles_educacion_optional.get());
        
        return ResponseEntity.noContent().build(); 
    }
}