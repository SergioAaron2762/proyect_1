package com.tienda.orden_service.repository;

import com.tienda.orden_service.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenRepository extends JpaRepository<Orden, Long> {
}
