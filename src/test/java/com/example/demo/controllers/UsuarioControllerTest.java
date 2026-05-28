package com.example.demo.controllers;

import com.example.demo.models.Usuario;
import com.example.demo.service.UsuarioService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
// Habilita Mockito en JUnit 5
class UsuarioControllerTest {

    @Mock
    // Simula el servicio
    private UsuarioService service;

    @InjectMocks
    // Inyecta el mock en el controlador
    private UsuarioController controller;

    private Usuario usuario;

    @BeforeEach
    void setUp() {

        usuario = new Usuario();
        usuario.setId(1L);
        usuario.setUsername("diego");
    }

    @Test
        // Prueba listar usuarios
    void listar_DebeRetornarLista() {

        when(service.listar())
                .thenReturn(Collections.singletonList(usuario));

        ResponseEntity<List<Usuario>> response = controller.listar();

        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
        assertEquals(HttpStatus.OK, response.getStatusCode());

        verify(service).listar();
    }

    @Test
        // Prueba guardar usuario
    void guardar_DebeGuardarUsuario() {

        when(service.guardar(usuario))
                .thenReturn(usuario);

        ResponseEntity<Usuario> response =
                controller.guardar(usuario);

        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getId());
        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        verify(service).guardar(usuario);
    }

    @Test
        // Prueba obtener usuario
    void obtener_DebeRetornarUsuario() {

        when(service.obtener(1L))
                .thenReturn(usuario);

        ResponseEntity<Usuario> response =
                controller.obtener(1L);

        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getId());
        assertEquals(HttpStatus.OK, response.getStatusCode());

        verify(service).obtener(1L);
    }

    @Test
        // Prueba actualizar usuario
    void actualizar_DebeActualizarUsuario() {

        when(service.actualizar(1L, usuario))
                .thenReturn(usuario);

        ResponseEntity<Usuario> response =
                controller.actualizar(1L, usuario);

        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getId());
        assertEquals(HttpStatus.OK, response.getStatusCode());

        verify(service).actualizar(1L, usuario);
    }

    @Test
        // Prueba eliminar usuario
    void eliminar_DebeLlamarService() {

        ResponseEntity<Void> response =
                controller.eliminar(1L);

        assertEquals(HttpStatus.NO_CONTENT,
                response.getStatusCode());

        verify(service).eliminar(1L);
    }

    @Test
        // Prueba buscar por username
    void buscarPorUsername_DebeRetornarUsuario() {

        when(service.buscarPorUsername("diego"))
                .thenReturn(usuario);

        ResponseEntity<Usuario> response =
                controller.buscarPorUsername("diego");

        assertNotNull(response.getBody());
        assertEquals("diego",
                response.getBody().getUsername());

        verify(service).buscarPorUsername("diego");
    }

    @Test
        // Prueba buscar usuarios por rol
    void buscarPorRol_DebeRetornarLista() {

        when(service.buscarPorRol("ADMIN"))
                .thenReturn(Collections.singletonList(usuario));

        ResponseEntity<List<Usuario>> response =
                controller.buscarPorRol("ADMIN");

        assertNotNull(response.getBody());
        assertEquals(1,
                response.getBody().size());

        verify(service).buscarPorRol("ADMIN");
    }

    @Test
        // Prueba listar usuarios activos
    void listarActivos_DebeRetornarLista() {

        when(service.listarActivos())
                .thenReturn(Collections.singletonList(usuario));

        ResponseEntity<List<Usuario>> response =
                controller.listarActivos();

        assertNotNull(response.getBody());
        assertEquals(1,
                response.getBody().size());

        verify(service).listarActivos();
    }

    @Test
        // Prueba verificar username
    void existeUsername_DebeRetornarTrue() {

        when(service.existeUsername("diego"))
                .thenReturn(true);

        ResponseEntity<Boolean> response =
                controller.existeUsername("diego");

        assertTrue(response.getBody());

        verify(service).existeUsername("diego");
    }
}