package com.direcciones.direcciones.entities;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "calle")
public class Calle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreCalle;
    
    @ManyToOne
    @JoinColumn(name = "comuna_id")
    private Comuna comuna;
    
    @OneToMany(mappedBy = "calle")
    private Set<Direccion> direcciones;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCalle() {
        return nombreCalle;
    }

    public void setNombreCalle(String nombre) {
        this.nombreCalle = nombre;
    }

  

    public Comuna getComuna() {
        return comuna;
    }

    public void setComuna(Comuna comuna) {
        this.comuna = comuna;
    }

    public Set<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(Set<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    
}