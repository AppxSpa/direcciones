package com.direcciones.direcciones.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.direcciones.direcciones.entities.Region;

public interface RegionRepository extends JpaRepository<Region,Long> {

}
