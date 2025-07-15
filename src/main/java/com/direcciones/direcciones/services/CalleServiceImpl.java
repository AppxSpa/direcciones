package com.direcciones.direcciones.services;

import org.springframework.stereotype.Service;

import com.direcciones.direcciones.entities.Calle;
import com.direcciones.direcciones.entities.Comuna;
import com.direcciones.direcciones.repositories.CalleRepository;
import com.direcciones.direcciones.services.interfaces.CalleService;

@Service
public class CalleServiceImpl implements CalleService {

    private final CalleRepository calleRepository;


    public CalleServiceImpl(CalleRepository calleRepository) {
        this.calleRepository = calleRepository;
    }

    @Override
    public Calle getOrCreateCalle(String nombreCalle, Comuna nombreComunua) {


        return calleRepository.findByNombreCalleAndComuna(nombreCalle, nombreComunua)
                .orElseGet(() -> createCalle(nombreCalle, nombreComunua));

    }

    private Calle createCalle(String nombreCalle, Comuna comuna) {

        Calle newCalle = new Calle();

        newCalle.setNombreCalle(nombreCalle);
        newCalle.setComuna(comuna);
        return calleRepository.save(newCalle);

    }

}
