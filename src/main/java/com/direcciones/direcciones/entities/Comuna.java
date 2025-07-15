package com.direcciones.direcciones.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "comuna")
public class Comuna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreComuna;

    private String codComuna;

    @ManyToOne
    @JoinColumn(name = "provincia_id", nullable = false) 
    private Provincia provincia;

    public Comuna() {}

    public Comuna(String nombre, Provincia provincia) {
        this.nombreComuna = nombre;
        this.provincia = provincia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreComuna() {
        return nombreComuna;
    }

    public void setNombreComuna(String nombre) {
        this.nombreComuna = nombre;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public String getCodComuna() {
        return codComuna;
    }

    public void setCodComuna(String codComuna) {
        this.codComuna = codComuna;
    }

    public String getNombreProvincia() {
        return provincia.getNombreProvincia();
    }

    public String getNombreRegion() {
        return provincia.getNombreRegion();
    }

    
}