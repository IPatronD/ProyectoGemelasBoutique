package com.example.demo.controllers;

import com.example.demo.models.Empleado;
import com.example.demo.service.EmpleadoService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
// Habilita Mockito en JUnit 5
class EmpleadoControllerTest {

    @Mock // Crea un mock (simulación) del servicio
    private EmpleadoService service;

    @InjectMocks // Inyecta el mock dentro del controlador
    private EmpleadoController controller;

    @Test // Prueba del método listar()
    void listar_DebeRetornarLista() {
        // Simula que el servicio devuelve una lista vacía
        when(service.listar()).thenReturn(Collections.emptyList());

        // Ejecuta el método
        List<Empleado> response = controller.listar();

        // Verifica que no sea null
        assertNotNull(response);

        // Verifica que se llamó al servicio
        verify(service).listar();
    }

    @Test // Prueba del método obtener()
    void obtener_DebeRetornarEmpleado() {
        Empleado e = new Empleado(); // Crea objeto de prueba
        e.setId(1L);

        // Simula búsqueda por ID
        when(service.obtener(1L)).thenReturn(e);

        // Ejecuta el método
        Empleado response = controller.obtener(1L);

        // Verifica que el ID sea correcto
        assertEquals(1L, response.getId());
    }

    @Test // Prueba del método guardar()
    void guardar_DebeGuardarEmpleado() {
        Empleado e = new Empleado();
        e.setId(1L);

        // Simula guardado
        when(service.guardar(e)).thenReturn(e);

        Empleado response = controller.guardar(e);

        // Verifica que no sea null
        assertNotNull(response);

        // Verifica que se llamó al servicio
        verify(service).guardar(e);
    }

    @Test // Prueba del método actualizar()
    void actualizar_DebeActualizarEmpleado() {
        Empleado e = new Empleado();
        e.setId(1L);

        // Simula actualización (usa guardar internamente)
        when(service.guardar(e)).thenReturn(e);

        // Ejecuta el método
        Empleado response = controller.actualizar(1L, e);

        // Verifica que el ID sea correcto
        assertEquals(1L, response.getId());
    }

    @Test // Prueba del método eliminar()
    void eliminar_DebeLlamarService() {
        // Ejecuta eliminación
        controller.eliminar(1L);

        // Verifica que se llamó al servicio
        verify(service).eliminar(1L);
    }
}