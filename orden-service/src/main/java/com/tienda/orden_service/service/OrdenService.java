package com.tienda.orden_service.service;

import com.tienda.orden_service.model.Orden;
import com.tienda.orden_service.repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenService {

    @Autowired
    private OrdenRepository repo;

    public List<Orden> listar() {
        return repo.findAll();
    }

    public Optional<Orden> buscar(Long id) {
        return repo.findById(id);
    }

    public Orden guardar(Orden orden) {
        return repo.save(orden);
    }
}
