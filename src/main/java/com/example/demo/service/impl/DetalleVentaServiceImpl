package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.models.DetalleVenta;
import com.example.demo.repository.DetalleVentaRepository;
import com.example.demo.service.DetalleVentaService;


@Service
public class DetalleVentaServiceImpl implements DetalleVentaService {

    private final DetalleVentaRepository repository;

    public DetalleVentaServiceImpl(DetalleVentaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DetalleVenta> listar() {
        return repository.findAll();
    }

    @Override
    public DetalleVenta guardar(DetalleVenta detalleVenta) {
        return repository.save(detalleVenta);
    }

    @Override
    public DetalleVenta obtenerPorId(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
