package com.direcciones.direcciones.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.direcciones.direcciones.entities.Comuna;

public interface ComunaRepository extends JpaRepository<Comuna,Long> {

    Optional<Comuna> findByNombreComuna(String nombreComuna);

}
