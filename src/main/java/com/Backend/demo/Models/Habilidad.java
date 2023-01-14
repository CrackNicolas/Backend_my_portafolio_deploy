package com.Backend.demo.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "habilidad")
public class Habilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_habilidad;
    
    @NotNull
    @Column(length = 30)
    private String nombre;
    
    @NotNull
    private int porcentaje;
    
    @NotNull
    @Column(length = 45)
    private String nombre_icono;
    
    @NotNull
    @Column(columnDefinition = "enum('blanda','tecnica','gestion_de_proyecto','controlador_de_versiones')")
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    
    @NotNull
    @Column(columnDefinition = "enum('uso_actual','uso_antiguo')")
    @Enumerated(EnumType.STRING)
    private Estado estado;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_persona")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Persona persona;
}