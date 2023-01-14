package com.Backend.demo.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "educacion")
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_educacion;
    
    @NotNull
    @Column(length = 100)
    private String institucion;
    
    @NotNull
    @Column(length = 45)
    private String carrera;
    
    @NotNull
    @Column(name = "fecha_inicio", nullable = false, updatable = false)
    @Temporal(TemporalType.DATE)
    @CreatedDate
    private Date fecha_inicio;
    
    @Column(name = "fecha_fin", updatable = false)
    @Temporal(TemporalType.DATE)
    @CreatedDate
    private Date fecha_fin;
    
    @NotNull
    @Column(length = 150)
    private String url_imagen;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_persona")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Persona persona;
    
    @OneToMany(mappedBy = "educacion", cascade = CascadeType.ALL)
    private Set<Detalles_educacion> detalles_educacion = new HashSet<>();
}