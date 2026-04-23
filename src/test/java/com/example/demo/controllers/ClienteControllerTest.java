package com.example.demo.controllers;

import com.example.demo.models.Cliente;
import com.example.demo.service.ClienteService;

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
class ClienteControllerTest {

    @Mock // Crea un mock (simulación) del servicio
    private ClienteService service;

    @InjectMocks // Inyecta el mock dentro del controlador
    private ClienteController controller;

    @Test // Prueba del método listar()
    void listar_DebeRetornarLista() {
        // Simula que el servicio devuelve una lista vacía
        when(service.listar()).thenReturn(Collections.emptyList());

        // Ejecuta el método del controlador
        List<Cliente> response = controller.listar();

        // Verifica que la respuesta no sea null
        assertNotNull(response);

        // Verifica que el método listar del servicio fue llamado
        verify(service).listar();
    }

    @Test // Prueba del método buscar()
    void buscar_DebeRetornarCliente() {
        Cliente c = new Cliente(); // Crea un cliente de prueba
        c.setId(1L);

        // Simula búsqueda por ID
        when(service.buscarPorId(1L)).thenReturn(c);

        // Ejecuta el método
        Cliente response = controller.buscar(1L);

        // Verifica que el ID sea correcto
        assertEquals(1L, response.getId());
    }

    @Test // Prueba del método guardar()
    void guardar_DebeGuardarCliente() {
        Cliente c = new Cliente();
        c.setId(1L);

        // Simula el guardado
        when(service.guardar(c)).thenReturn(c);

        Cliente response = controller.guardar(c);

        // Verifica que no sea null
        assertNotNull(response);

        // Verifica que se llamó al servicio
        verify(service).guardar(c);
    }

    @Test // Prueba del método eliminar()
    void eliminar_DebeLlamarService() {
        // Ejecuta eliminación
        controller.eliminar(1L);

        // Verifica que se llamó al servicio
        verify(service).eliminar(1L);
    }
}