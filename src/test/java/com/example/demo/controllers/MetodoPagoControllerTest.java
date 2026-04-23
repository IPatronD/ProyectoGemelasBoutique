package com.example.demo.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.models.MetodoPago;
import com.example.demo.service.MetodoPagoService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
// Habilita Mockito en JUnit 5
class MetodoPagoControllerTest {

    @Mock // Crea un mock (simulación) del servicio
    private MetodoPagoService service;

    @InjectMocks // Inyecta el mock dentro del controlador
    private MetodoPagoController controller;

    private MetodoPago metodo; // Objeto de prueba

    @BeforeEach // Se ejecuta antes de cada test
    void setUp() {
        metodo = new MetodoPago(); // Inicializa el objeto
        metodo.setId(1L);
        metodo.setNombre("Efectivo"); // Valor de ejemplo
    }

    @Test // Prueba del método listar()
    void listar() {
        // Simula que el servicio devuelve una lista con un elemento
        when(service.listar()).thenReturn(Arrays.asList(metodo));

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
        when(service.guardar(metodo)).thenReturn(metodo);

        // Ejecuta el método
        MetodoPago resultado = controller.guardar(metodo);

        // Verifica que no sea null
        assertNotNull(resultado);

        // Verifica que el servicio fue llamado
        verify(service).guardar(metodo);
    }

    @Test // Prueba del método actualizar()
    void actualizar() {
        // Simula la actualización
        when(service.actualizar(1L, metodo)).thenReturn(metodo);

        // Ejecuta el método
        MetodoPago resultado = controller.actualizar(1L, metodo);

        // Verifica que no sea null
        assertNotNull(resultado);

        // Verifica que el servicio fue llamado
        verify(service).actualizar(1L, metodo);
    }

    @Test // Prueba del método eliminar()
    void eliminar() {
        // Ejecuta eliminación
        controller.eliminar(1L);

        // Verifica que el servicio fue llamado
        verify(service).eliminar(1L);
    }
}