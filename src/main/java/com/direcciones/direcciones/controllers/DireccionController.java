package com.direcciones.direcciones.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.direcciones.direcciones.dto.DireccionRequest;
import com.direcciones.direcciones.dto.DireccionResponse;
import com.direcciones.direcciones.dto.ComunaResponse;
import com.direcciones.direcciones.dto.DireccionIdResponse;
import com.direcciones.direcciones.services.interfaces.ComunaService;
import com.direcciones.direcciones.services.interfaces.DireccionService;

@RestController
@RequestMapping("/api/direcciones")
public class DireccionController {

    private final DireccionService direccionService;
    private final ComunaService comunaService;

    public DireccionController(DireccionService direccionService, ComunaService comunaService) {
        this.direccionService = direccionService;
        this.comunaService = comunaService;
    }

    @PostMapping
    public ResponseEntity<Object> createDireccion(@RequestBody DireccionRequest direccionRequest) {

        try {
            DireccionIdResponse direccion = direccionService.createDireccion(direccionRequest.getNombreCalle(),
                    direccionRequest.getNumeroCalle(), direccionRequest.getNombreComuna(),
                    direccionRequest.getLongitud(), direccionRequest.getLatitud(), direccionRequest.getAdicional());
            return ResponseEntity.ok(direccion);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @GetMapping
    public ResponseEntity<Object> getDireccionById(@RequestParam Long id) {

        try {
            DireccionResponse direccion = direccionService.getDirecccionById(id);
            return ResponseEntity.ok(direccion);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @GetMapping("/list-comunas")
    public ResponseEntity<Object> getComunas() {

        try {
            List<ComunaResponse> comunas = comunaService.getAllComunas();
            return ResponseEntity.ok(comunas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

}