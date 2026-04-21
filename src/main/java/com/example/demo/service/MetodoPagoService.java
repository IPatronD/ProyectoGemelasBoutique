package com.example.demo.service;

import java.util.List;
import com.example.demo.models.MetodoPago;


public interface MetodoPagoService {

    List<MetodoPago> listar();

    MetodoPago guardar(MetodoPago metodoPago);

    MetodoPago actualizar(Long id, MetodoPago metodoPago);

    void eliminar(Long id);
}