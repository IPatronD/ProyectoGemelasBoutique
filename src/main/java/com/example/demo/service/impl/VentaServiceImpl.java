package com.example.demo.service.impl;

import com.example.demo.models.Venta;
import com.example.demo.repository.VentaRepository;
import com.example.demo.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaServiceImpl implements VentaService {

    @Autowired
    private VentaRepository repository;

    @Override
    public List<Venta> listar() {
        return repository.findAll();
    }

    @Override
    public Venta guardar(Venta venta) {
        return repository.save(venta);
    }

    @Override
    public Venta obtener(Long id) {
        return repository.findById(id).orElse(null);
    }
}