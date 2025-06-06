package com.tienda.orden_service.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cliente;
    private LocalDate fecha;
    private Double total;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ItemOrden> items;
}
