package com.tienda.orden_service.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ItemOrden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productoId;
    private Integer cantidad;
}
