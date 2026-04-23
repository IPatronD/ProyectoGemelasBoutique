package com.example.demo.controllers;

import com.example.demo.models.Usuario;
import com.example.demo.service.UsuarioService;

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
class UsuarioControllerTest {

    @Mock // Crea un mock (simulación) del servicio
    private UsuarioService service;

    @InjectMocks // Inyecta el mock dentro del controlador
    private UsuarioController controller;

    @Test // Prueba del método listar()
    void listar_DebeRetornarLista() {
        // Simula que el servicio devuelve una lista vacía
        when(service.listar()).thenReturn(Collections.emptyList());

        // Ejecuta el método
        List<Usuario> response = controller.listar();

        // Verifica que no sea null
        assertNotNull(response);

        // Verifica que el método fue llamado
        verify(service).listar();
    }

    @Test // Prueba del método obtener()
    void obtener_DebeRetornarUsuario() {
        Usuario u = new Usuario(); // Objeto de prueba
        u.setId(1L);

        // Simula búsqueda por ID
        when(service.obtener(1L)).thenReturn(u);

        // Ejecuta el método
        Usuario response = controller.obtener(1L);

        // Verifica el resultado
        assertEquals(1L, response.getId());
    }

    @Test // Prueba del método guardar()
    void guardar_DebeGuardarUsuario() {
        Usuario u = new Usuario();
        u.setId(1L);

        // Simula el guardado
        when(service.guardar(u)).thenReturn(u);

        Usuario response = controller.guardar(u);

        // Verifica que no sea null
        assertNotNull(response);

        // Verifica que se llamó al servicio
        verify(service).guardar(u);
    }

    @Test // Prueba del método actualizar()
    void actualizar_DebeActualizarUsuario() {
        Usuario u = new Usuario();
        u.setId(1L);

        // Simula actualización (usa guardar internamente)
        when(service.guardar(u)).thenReturn(u);

        // Ejecuta el método
        Usuario response = controller.actualizar(1L, u);

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