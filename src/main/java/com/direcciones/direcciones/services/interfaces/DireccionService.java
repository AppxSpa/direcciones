package com.direcciones.direcciones.services.interfaces;

import com.direcciones.direcciones.dto.DireccionIdResponse;
import com.direcciones.direcciones.dto.DireccionResponse;

public interface DireccionService {

    DireccionIdResponse createDireccion(String nombreCalle, Integer numeroCalle, String nomcbreComuna, Double longirut,
            Double latiud, String adicional);


    DireccionResponse getDirecccionById(Long id);

}
