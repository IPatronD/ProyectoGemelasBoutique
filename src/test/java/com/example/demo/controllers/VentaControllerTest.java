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
// Habilita Mockito en JUnit 5
class VentaControllerTest {

    @Mock // Simula el servicio
    private VentaService service;

    @InjectMocks // Inyecta el mock en el controlador
    private VentaController ventaController;

    @Test // Prueba del método listar()
    void listar() {
        Venta v1 = new Venta();
        v1.setTotal(200.0);

        // Simula que el servicio devuelve una lista con una venta
        when(service.listar()).thenReturn(List.of(v1));

        // Ejecuta el método
        List<Venta> resultado = ventaController.listar();

        // Validaciones
        assertNotNull(resultado); // No debe ser null
        assertEquals(1, resultado.size()); // Debe tener 1 elemento

        // Verifica que el servicio fue llamado
        verify(service).listar();
    }

    @Test // Prueba del método guardar()
    void guardar() {
        Venta venta = new Venta();
        venta.setTotal(500.0);

        // Simula el guardado
        when(service.guardar(any(Venta.class))).thenReturn(venta);

        // Ejecuta el método
        Venta resultado = ventaController.guardar(venta);

        // Validaciones
        assertNotNull(resultado);
        assertEquals(500.0, resultado.getTotal());

        // Verifica que se llamó con el mismo objeto
        verify(service).guardar(venta);
    }

    @Test // Prueba del método obtener()
    void obtener() {

        Long idBuscado = 1L;

        Venta ventaEsperada = new Venta();
        ventaEsperada.setId(idBuscado);
        ventaEsperada.setTotal(350.0);

        // Simula búsqueda por ID
        when(service.obtener(idBuscado)).thenReturn(ventaEsperada);

        // Ejecuta el método
        Venta resultado = ventaController.obtener(idBuscado);

        // Validaciones
        assertNotNull(resultado);
        assertEquals(idBuscado, resultado.getId());
        assertEquals(350.0, resultado.getTotal());

        // Verifica que se llamó correctamente
        verify(service).obtener(idBuscado);
    }
}