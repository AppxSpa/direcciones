package com.direcciones.direcciones.services;

import org.springframework.stereotype.Service;

import com.direcciones.direcciones.entities.Comuna;
import com.direcciones.direcciones.repositories.ComunaRepository;
import com.direcciones.direcciones.services.interfaces.ComunaService;

@Service
public class ComunaServiceImpl implements ComunaService {

    private final ComunaRepository comunaRepository;

    public ComunaServiceImpl(ComunaRepository comunaRepository) {
        this.comunaRepository = comunaRepository;
    }

    @Override
    public Comuna findByNombreComuna(String nombreComuna) {
        return comunaRepository.findByNombreComuna(nombreComuna)
                .orElseThrow(() -> new IllegalArgumentException("Comuna " + nombreComuna + "no existe"));
    }

}
