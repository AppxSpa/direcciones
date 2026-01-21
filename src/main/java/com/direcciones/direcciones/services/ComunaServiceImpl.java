package com.direcciones.direcciones.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.direcciones.direcciones.dto.ComunaResponse;
import com.direcciones.direcciones.entities.Comuna;
import com.direcciones.direcciones.repositories.ComunaRepository;
import com.direcciones.direcciones.services.interfaces.ComunaService;

@Service
public class ComunaServiceImpl implements ComunaService {

    private final ComunaRepository comunaRepository;
    private final ComunaMapper comunaMapper;

    public ComunaServiceImpl(ComunaRepository comunaRepository) {
        this.comunaRepository = comunaRepository;
        this.comunaMapper = new ComunaMapper();
    }

    @Override
    public Comuna findByNombreComuna(String nombreComuna) {
        return comunaRepository.findByNombreComuna(nombreComuna)
                .orElseThrow(() -> new IllegalArgumentException("Comuna " + nombreComuna + "no existe"));
    }

    @Override
    public List<ComunaResponse> getAllComunas() {
        List<Comuna> comunas = comunaRepository.findAll();
        return comunaMapper.comunaResponseMapper(comunas);
    }

}
