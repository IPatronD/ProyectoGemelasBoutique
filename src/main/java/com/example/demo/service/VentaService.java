package com.example.demo.service;

import com.example.demo.models.Venta;
import java.util.List;

public interface VentaService {

    List<Venta> listar();

    Venta guardar(Venta venta);

    Venta obtener(Long id);
}