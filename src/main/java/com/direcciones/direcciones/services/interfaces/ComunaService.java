package com.direcciones.direcciones.services.interfaces;

import java.util.List;

import com.direcciones.direcciones.dto.ComunaResponse;
import com.direcciones.direcciones.entities.Comuna;

public interface ComunaService {

    Comuna findByNombreComuna(String nombreComuna);

    List<ComunaResponse> getAllComunas();

}
