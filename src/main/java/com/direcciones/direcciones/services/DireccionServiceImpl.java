package com.direcciones.direcciones.services;

import org.springframework.stereotype.Service;

import com.direcciones.direcciones.dto.DireccionIdResponse;
import com.direcciones.direcciones.dto.DireccionResponse;
import com.direcciones.direcciones.entities.Calle;
import com.direcciones.direcciones.entities.Comuna;
import com.direcciones.direcciones.entities.Direccion;
import com.direcciones.direcciones.repositories.DireccionRepository;
import com.direcciones.direcciones.services.interfaces.CalleService;
import com.direcciones.direcciones.services.interfaces.ComunaService;
import com.direcciones.direcciones.services.interfaces.DireccionService;

@Service
public class DireccionServiceImpl implements DireccionService {

    private final CalleService calleService;

    private final ComunaService comunaService;

    private final DireccionRepository direccionRepository;

    public DireccionServiceImpl(CalleService calleService, ComunaService comunaService,
            DireccionRepository direccionRepository) {
        this.calleService = calleService;
        this.comunaService = comunaService;
        this.direccionRepository = direccionRepository;
    }

    @Override
    public DireccionIdResponse createDireccion(String nombreCalle, Integer numeroCalle, String nombreComuna,
            Double longitud,
            Double latiud, String adicional) {

        Comuna comuna = comunaService.findByNombreComuna(nombreComuna);

        Calle calle = calleService.getOrCreateCalle(nombreCalle.toUpperCase(), comuna);

        Direccion direccion = new Direccion();

        direccion.setCalle(calle);
        direccion.setComuna(comuna);
        direccion.setNumero(numeroCalle);
        direccion.setLongitud(longitud);
        direccion.setLatitud(latiud);
        direccion.setAdicional(adicional != null ? adicional : null);

        direccion = direccionRepository.save(direccion);

        return new DireccionIdResponse(direccion.getId());

    }

    @Override
    public DireccionResponse getDirecccionById(Long id) {

        Direccion direccion = direccionRepository
                .findById(id).orElseThrow(() -> new IllegalArgumentException("Id de direccion no encontrada"));

        DireccionResponse response = new DireccionResponse(direccion.getNombreCalle(),
                direccion.getNumero(), direccion.getAdicional(), direccion.getNombreComuna(),
                direccion.getNombreProvincia(),
                direccion.getNombreRegion());
        response.setLongitud(direccion.getLongitud());
        response.setLatitud(direccion.getLatitud());
        return response;

    }

}
