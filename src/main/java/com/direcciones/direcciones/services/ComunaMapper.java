package com.direcciones.direcciones.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.direcciones.direcciones.dto.ComunaResponse;
import com.direcciones.direcciones.entities.Comuna;

@Component
public class ComunaMapper {

    public List<ComunaResponse> comunaResponseMapper(List<Comuna> comunas) {
        return comunas.stream()
                .map(comuna -> new ComunaResponse(
                        comuna.getId(),
                        comuna.getNombreComuna(),
                        comuna.getCodComuna(),
                        comuna.getProvinciaId(),
                        comuna.getNombreProvincia()))
                .toList();
    }

}
