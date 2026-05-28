package com.example.demo.service.impl;

import com.example.demo.models.Venta;
import com.example.demo.repository.VentaRepository;
import com.example.demo.service.VentaService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VentaServiceImpl implements VentaService {

    private final VentaRepository repository;

    public VentaServiceImpl(VentaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Venta> listar() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Venta guardar(Venta venta) {
        return repository.save(venta);
    }

    @Override
    public Venta obtener(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Venta no encontrada"));
    }

    @Override
    @Transactional
    public Venta actualizar(Long id, Venta venta) {

        Venta existente = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Venta no encontrada"));

        existente.setFecha(venta.getFecha());
        existente.setTotal(venta.getTotal());
        existente.setCliente(venta.getCliente());
        existente.setUsuario(venta.getUsuario());
        existente.setMetodoPago(venta.getMetodoPago());

        return repository.save(existente);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {

        Venta venta = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Venta no encontrada"));

        repository.delete(venta);
    }

    // CONSULTAS PERSONALIZADAS

    @Override
    public List<Venta> ventasPorCliente(Long clienteId) {
        return repository.ventasPorCliente(clienteId);
    }

    @Override
    public List<Venta> ventasPorFechas(LocalDateTime inicio, LocalDateTime fin) {
        return repository.ventasPorFechas(inicio, fin);
    }

    @Override
    public List<Venta> ventasPorMetodoPago(String metodo) {
        return repository.ventasPorMetodoPago(metodo);
    }

    @Override
    public Double totalVentas() {
        return repository.totalVentas();
    }

    @Override
    public Double totalVentasCliente(Long clienteId) {
        return repository.totalVentasCliente(clienteId);
    }

    @Override
    public Long contarVentas() {
        return repository.contarVentas();
    }
}