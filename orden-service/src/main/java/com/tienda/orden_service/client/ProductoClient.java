package com.tienda.orden_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "producto-service")
public interface ProductoClient {

    @GetMapping("/productos/{id}")
    Producto obtenerProducto(@PathVariable("id") Long id);

    class Producto {
        public Long id;
        public String nombre;
        public String descripcion;
        public Double precio;
        public Integer stock;
        public String categoria;
    }
}
