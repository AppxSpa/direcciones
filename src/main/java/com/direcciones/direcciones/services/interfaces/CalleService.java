package com.direcciones.direcciones.services.interfaces;

import com.direcciones.direcciones.entities.Calle;
import com.direcciones.direcciones.entities.Comuna;

public interface CalleService {


    Calle getOrCreateCalle(String nombreCalle, Comuna comuna);

}
