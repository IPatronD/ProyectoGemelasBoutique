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
class UsuarioControllerTest {

    @Mock
    private UsuarioService service;

    @InjectMocks
    private UsuarioController controller;

    @Test
    void listar_DebeRetornarLista() {
        when(service.listar()).thenReturn(Collections.emptyList());

        List<Usuario> response = controller.listar();

        assertNotNull(response);
        verify(service).listar();
    }

    @Test
    void obtener_DebeRetornarUsuario() {
        Usuario u = new Usuario();
        u.setId(1L);

        when(service.obtener(1L)).thenReturn(u);

        Usuario response = controller.obtener(1L);

        assertEquals(1L, response.getId());
    }

    @Test
    void guardar_DebeGuardarUsuario() {
        Usuario u = new Usuario();
        u.setId(1L);

        when(service.guardar(u)).thenReturn(u);

        Usuario response = controller.guardar(u);

        assertNotNull(response);
        verify(service).guardar(u);
    }

    @Test
    void actualizar_DebeActualizarUsuario() {
        Usuario u = new Usuario();
        u.setId(1L);

        when(service.guardar(u)).thenReturn(u);

        Usuario response = controller.actualizar(1L, u);

        assertEquals(1L, response.getId());
    }

    @Test
    void eliminar_DebeLlamarService() {
        controller.eliminar(1L);

        verify(service).eliminar(1L);
    }
}