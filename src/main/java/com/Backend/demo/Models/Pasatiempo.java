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
@Table(name = "pasatiempo")
public class Pasatiempo {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id_pasatiempo;
    
    @NotNull
    @Column(length = 200)
    private String descripcion;
    
    @NotNull
    @Column(length = 20)
    private String nombre_logo;
    
    @NotNull
    @Column(columnDefinition = "enum('Deportes','Instrumento','Otros')")
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_persona")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Persona persona;
}