package com.example.demo.controllers;

import com.example.demo.models.Venta;
import com.example.demo.service.VentaService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
// Habilita Mockito en JUnit 5
class VentaControllerTest {

    @Mock
    // Simula el servicio
    private VentaService service;

    @InjectMocks
    // Inyecta el mock en el controlador
    private VentaController controller;

    private Venta venta;

    @BeforeEach
    void setUp() {

        venta = new Venta();
        venta.setId(1L);
        venta.setTotal(500.0);
    }

    @Test
        // Prueba listar ventas
    void listar_DebeRetornarLista() {

        when(service.listar())
                .thenReturn(List.of(venta));

        ResponseEntity<List<Venta>> response =
                controller.listar();

        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
        assertEquals(HttpStatus.OK,
                response.getStatusCode());

        verify(service).listar();
    }

    @Test
        // Prueba guardar venta
    void guardar_DebeGuardarVenta() {

        when(service.guardar(venta))
                .thenReturn(venta);

        ResponseEntity<Venta> response =
                controller.guardar(venta);

        assertNotNull(response.getBody());
        assertEquals(500.0,
                response.getBody().getTotal());

        assertEquals(HttpStatus.CREATED,
                response.getStatusCode());

        verify(service).guardar(venta);
    }

    @Test
        // Prueba obtener venta
    void obtener_DebeRetornarVenta() {

        when(service.obtener(1L))
                .thenReturn(venta);

        ResponseEntity<Venta> response =
                controller.obtener(1L);

        assertNotNull(response.getBody());
        assertEquals(1L,
                response.getBody().getId());

        assertEquals(HttpStatus.OK,
                response.getStatusCode());

        verify(service).obtener(1L);
    }

    @Test
        // Prueba eliminar venta
    void eliminar_DebeLlamarService() {

        ResponseEntity<Void> response =
                controller.eliminar(1L);

        assertEquals(HttpStatus.NO_CONTENT,
                response.getStatusCode());

        verify(service).eliminar(1L);
    }
}