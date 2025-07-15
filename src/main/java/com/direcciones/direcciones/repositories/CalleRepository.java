package com.direcciones.direcciones.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.direcciones.direcciones.entities.Calle;
import com.direcciones.direcciones.entities.Comuna;

public interface CalleRepository extends JpaRepository<Calle,Long> {

    Optional<Calle> findByNombreCalleAndComuna(String nombreCalle, Comuna comuna);

}
