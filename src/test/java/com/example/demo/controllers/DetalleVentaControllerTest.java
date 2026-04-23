package com.example.demo.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.models.DetalleVenta;
import com.example.demo.service.DetalleVentaService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
// Habilita Mockito en JUnit 5
class DetalleVentaControllerTest {

    @Mock // Crea un mock (simulación) del servicio
    private DetalleVentaService service;

    @InjectMocks // Inyecta el mock dentro del controlador
    private DetalleVentaController controller;

    private DetalleVenta detalle; // Objeto de prueba

    @BeforeEach // Se ejecuta antes de cada test
    void setUp() {
        detalle = new DetalleVenta(); // Inicializa el objeto
        detalle.setId(1L); // Asigna un ID de prueba
    }

    @Test // Prueba del método listar()
    void listar() {
        // Simula que el servicio devuelve una lista con un elemento
        when(service.listar()).thenReturn(Arrays.asList(detalle));

        // Ejecuta el método del controlador
        var lista = controller.listar();

        // Verifica que la lista tenga 1 elemento
        assertEquals(1, lista.size());

        // Verifica que el servicio fue llamado
        verify(service).listar();
    }

    @Test // Prueba del método guardar()
    void guardar() {
        // Simula el guardado
        when(service.guardar(detalle)).thenReturn(detalle);

        // Ejecuta el método
        DetalleVenta resultado = controller.guardar(detalle);

        // Verifica que no sea null
        assertNotNull(resultado);

        // Verifica que el servicio fue llamado
        verify(service).guardar(detalle);
    }

    @Test // Prueba del método obtenerPorId()
    void obtenerPorId() {
        // Simula búsqueda por ID
        when(service.obtenerPorId(1L)).thenReturn(detalle);

        // Ejecuta el método
        DetalleVenta resultado = controller.obtenerPorId(1L);

        // Verifica que el ID sea correcto
        assertEquals(1L, resultado.getId());

        // Verifica que el servicio fue llamado
        verify(service).obtenerPorId(1L);
    }

    @Test // Prueba del método eliminar()
    void eliminar() {
        // Ejecuta eliminación
        controller.eliminar(1L);

        // Verifica que el servicio fue llamado
        verify(service).eliminar(1L);
    }
}