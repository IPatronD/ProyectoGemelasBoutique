package com.example.demo.service;

import java.util.List;
import com.example.demo.models.DetalleVenta;


public interface DetalleVentaService {

    List<DetalleVenta> listar();

    DetalleVenta guardar(DetalleVenta detalleVenta);

    DetalleVenta obtenerPorId(Long id);

    void eliminar(Long id);
}