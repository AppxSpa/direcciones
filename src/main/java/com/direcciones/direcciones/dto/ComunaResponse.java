package com.direcciones.direcciones.dto;

public class ComunaResponse {

    private Long id;
    private String nombreComuna;
    private String codComuna;
    private Long provinciaId;
    private String provinciaNombre;

    public ComunaResponse(Long id, String nombreComuna, String codComuna, Long provinciaId, String provinciaNombre) {
        this.id = id;
        this.nombreComuna = nombreComuna;
        this.codComuna = codComuna;
        this.provinciaId = provinciaId;
        this.provinciaNombre = provinciaNombre;
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

    public void setNombreComuna(String nombreComuna) {
        this.nombreComuna = nombreComuna;
    }

    public String getCodComuna() {
        return codComuna;
    }

    public void setCodComuna(String codComuna) {
        this.codComuna = codComuna;
    }

    public Long getProvinciaId() {
        return provinciaId;
    }

    public void setProvinciaId(Long provinciaId) {
        this.provinciaId = provinciaId;
    }

    public String getProvinciaNombre() {
        return provinciaNombre;
    }

    public void setProvinciaNombre(String provinciaNombre) {
        this.provinciaNombre = provinciaNombre;
    }

}
