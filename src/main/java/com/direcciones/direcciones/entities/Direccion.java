package com.direcciones.direcciones.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "direccion")
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numero;
    @Column(nullable = true)
    private String adicional;

    @Column(nullable = true)
    private Double latitud;
    @Column(nullable = true)
    private Double longitud;

    @ManyToOne
    @JoinColumn(name = "calle_id")
    private Calle calle;

    @ManyToOne
    @JoinColumn(name = "comuna_id")
    private Comuna comuna;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Calle getCalle() {
        return calle;
    }

    public void setCalle(Calle calle) {
        this.calle = calle;
    }

    public Comuna getComuna() {
        return comuna;
    }

    public void setComuna(Comuna comuna) {
        this.comuna = comuna;
    }

    public String getAdicional() {
        return adicional;
    }

    public void setAdicional(String adicional) {
        this.adicional = adicional;
    }

  public String getNombreCalle() {
        return calle.getNombreCalle();
    }


    public String getNombreComuna() {
        return comuna.getNombreComuna();
    }

    public String getNombreProvincia() {
        return comuna.getNombreProvincia();
    }

    public String getNombreRegion() {
        return comuna.getNombreRegion();
    }
}