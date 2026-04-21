package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.models.MetodoPago;
import com.example.demo.repository.MetodoPagoRepository;
import com.example.demo.service.MetodoPagoService;

@Service
public class MetodoPagoServiceImpl implements MetodoPagoService {

    private final MetodoPagoRepository repository;

    public MetodoPagoServiceImpl(MetodoPagoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<MetodoPago> listar() {
        return repository.findAll();
    }

    @Override
    public MetodoPago guardar(MetodoPago metodoPago) {
        return repository.save(metodoPago);
    }

    @Override
    public MetodoPago actualizar(Long id, MetodoPago metodoPago) {
        MetodoPago existente = repository.findById(id).orElseThrow();
        existente.setNombre(metodoPago.getNombre());
        return repository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
