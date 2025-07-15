package com.direcciones.direcciones.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "provincia")
public class Provincia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreProvincia;

    @ManyToOne
    @JoinColumn(name = "region_id", nullable = false) // 🔹 Se agrega la clave foránea
    @JsonBackReference
    private Region region;

    @OneToMany(mappedBy = "provincia", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Comuna> comunas;

    public Provincia() {}

    public Provincia(String nombre, Region region) {
        this.nombreProvincia = nombre;
        this.region = region;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreProvincia() {
        return nombreProvincia;
    }

    public void setNombreProvincia(String nombre) {
        this.nombreProvincia = nombre;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Set<Comuna> getComunas() {
        return comunas;
    }

    public void setComunas(Set<Comuna> comunas) {
        this.comunas = comunas;
    }


    public String getNombreRegion() {
        return region.getNombreRegion();
    }
    
}