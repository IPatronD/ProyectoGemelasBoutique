package com.example.demo.controllers;

import com.example.demo.models.Venta;
import com.example.demo.service.VentaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VentaControllerTest {

    @Mock
    private VentaService service;

    @InjectMocks
    private VentaController ventaController;

    @Test
    void listar() {
        Venta v1 = new Venta();
        v1.setTotal(200.0);
        when(service.listar()).thenReturn(List.of(v1));

        List<Venta> resultado = ventaController.listar();

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        verify(service).listar();
    }

    @Test
    void guardar() {
        Venta venta = new Venta();
        venta.setTotal(500.0);
        when(service.guardar(any(Venta.class))).thenReturn(venta);

        Venta resultado = ventaController.guardar(venta);

        assertNotNull(resultado);
        assertEquals(500.0, resultado.getTotal());
        verify(service).guardar(venta);
    }

    @Test
    void obtener() {

        Long idBuscado = 1L;
        Venta ventaEsperada = new Venta();
        ventaEsperada.setId(idBuscado);
        ventaEsperada.setTotal(350.0);

        when(service.obtener(idBuscado)).thenReturn(ventaEsperada);

        Venta resultado = ventaController.obtener(idBuscado);

        assertNotNull(resultado);
        assertEquals(idBuscado, resultado.getId());
        assertEquals(350.0, resultado.getTotal());

        verify(service).obtener(idBuscado);
    }
}