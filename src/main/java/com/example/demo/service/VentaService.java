package com.example.demo.service;

import com.example.demo.models.Venta;
import com.example.demo.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService {

    @Autowired
    private VentaRepository repository;

    public List<Venta> listar() {
        return repository.findAll();
    }

    public Venta guardar(Venta venta) {
        return repository.save(venta);
    }

    public Venta obtener(Long id) {
        return repository.findById(id).orElse(null);
    }
}