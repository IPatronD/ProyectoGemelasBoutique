package com.example.demo.controllers;

import com.example.demo.models.Cliente;
import com.example.demo.service.ClienteService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClienteControllerTest {

    @Mock
    private ClienteService service;

    @InjectMocks
    private ClienteController controller;

    @Test
    void listar_DebeRetornarLista() {

        when(service.listar())
                .thenReturn(Collections.emptyList());

        ResponseEntity<List<Cliente>> response =
                controller.listar();

        assertNotNull(response);

        verify(service).listar();
    }

    @Test
    void buscar_DebeRetornarCliente() {

        Cliente c = new Cliente();
        c.setId(1L);

        when(service.buscarPorId(1L))
                .thenReturn(c);

        ResponseEntity<Cliente> response =
                controller.buscar(1L);

        assertEquals(1L,
                response.getBody().getId());
    }

    @Test
    void guardar_DebeGuardarCliente() {

        Cliente c = new Cliente();
        c.setId(1L);

        when(service.guardar(c))
                .thenReturn(c);

        ResponseEntity<Cliente> response =
                controller.guardar(c);

        assertNotNull(response);

        verify(service).guardar(c);
    }

    @Test
    void eliminar_DebeLlamarService() {

        ResponseEntity<Void> response =
                controller.eliminar(1L);

        assertEquals(204,
                response.getStatusCodeValue());

        verify(service).eliminar(1L);
    }
}