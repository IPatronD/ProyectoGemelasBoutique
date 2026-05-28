package com.example.demo.controllers;

import com.example.demo.models.MetodoPago;
import com.example.demo.service.MetodoPagoService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
// Habilita Mockito
class MetodoPagoControllerTest {

    @Mock
    // Simula el service
    private MetodoPagoService service;

    @InjectMocks
    // Inyecta el mock en el controller
    private MetodoPagoController controller;

    private MetodoPago metodo;

    @BeforeEach
    void setUp() {

        metodo = new MetodoPago();

        metodo.setId(1L);
        metodo.setNombre("Efectivo");
    }

    @Test
        // Prueba listar
    void listar() {

        when(service.listar())
                .thenReturn(Arrays.asList(metodo));

        ResponseEntity<List<MetodoPago>> response =
                controller.listar();

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());

        verify(service).listar();
    }

    @Test
        // Prueba guardar
    void guardar() {

        when(service.guardar(metodo))
                .thenReturn(metodo);

        ResponseEntity<MetodoPago> response =
                controller.guardar(metodo);

        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Efectivo",
                response.getBody().getNombre());

        verify(service).guardar(metodo);
    }

    @Test
        // Prueba obtener por id
    void obtener() {

        when(service.obtenerPorId(1L))
                .thenReturn(metodo);

        ResponseEntity<MetodoPago> response =
                controller.obtener(1L);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1L,
                response.getBody().getId());

        verify(service).obtenerPorId(1L);
    }

    @Test
        // Prueba actualizar
    void actualizar() {

        when(service.actualizar(1L, metodo))
                .thenReturn(metodo);

        ResponseEntity<MetodoPago> response =
                controller.actualizar(1L, metodo);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Efectivo",
                response.getBody().getNombre());

        verify(service).actualizar(1L, metodo);
    }

    @Test
        // Prueba eliminar
    void eliminar() {

        doNothing().when(service).eliminar(1L);

        ResponseEntity<Void> response =
                controller.eliminar(1L);

        assertEquals(HttpStatus.NO_CONTENT,
                response.getStatusCode());

        verify(service).eliminar(1L);
    }
}