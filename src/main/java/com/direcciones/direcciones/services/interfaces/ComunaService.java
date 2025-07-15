package com.direcciones.direcciones.services.interfaces;

import com.direcciones.direcciones.entities.Comuna;

public interface ComunaService {

    Comuna findByNombreComuna(String nombreComuna);

}
