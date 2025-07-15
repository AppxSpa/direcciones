package com.direcciones.direcciones.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.direcciones.direcciones.entities.Direccion;

public interface DireccionRepository extends JpaRepository<Direccion,Long> {

}
