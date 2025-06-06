package com.tienda.orden_service.controller;

import com.tienda.orden_service.client.ProductoClient;
import com.tienda.orden_service.model.ItemOrden;
import com.tienda.orden_service.model.Orden;
import com.tienda.orden_service.service.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/ordenes")
public class OrdenController {

    @Autowired
    private OrdenService service;

    @Autowired
    private ProductoClient productoClient;

    @GetMapping
    public List<Orden> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orden> obtener(@PathVariable Long id) {
        return service.buscar(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Orden crear(@RequestBody Orden orden) {
        double total = 0;
        for (ItemOrden item : orden.getItems()) {
            ProductoClient.Producto producto = productoClient.obtenerProducto(item.getProductoId());
            total += producto.precio * item.getCantidad();
        }
        orden.setFecha(LocalDate.now());
        orden.setTotal(total);
        return service.guardar(orden);
    }
}
