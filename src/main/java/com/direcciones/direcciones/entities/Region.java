package com.direcciones.direcciones.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "region")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreRegion;

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Provincia> provincias;

    public Region() {}

    public Region(String nombre) {
        this.nombreRegion = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreRegion() {
        return nombreRegion;
    }

    public void setNombreRegion(String nombre) {
        this.nombreRegion = nombre;
    }

  

    public Set<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(Set<Provincia> provincias) {
        this.provincias = provincias;
    }

    
}