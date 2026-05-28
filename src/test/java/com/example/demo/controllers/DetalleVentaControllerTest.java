package com.example.demo.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.BeforeEach;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.models.DetalleVenta;
import com.example.demo.service.DetalleVentaService;

import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
// Habilita Mockito
class DetalleVentaControllerTest {

    @Mock
    private DetalleVentaService service;

    @InjectMocks
    private DetalleVentaController controller;

    private DetalleVenta detalle;

    @BeforeEach
    void setUp() {

        detalle = new DetalleVenta();
        detalle.setId(1L);
    }

    @Test
    void listar() {

        when(service.listar())
                .thenReturn(Arrays.asList(detalle));

        ResponseEntity<List<DetalleVenta>> response =
                controller.listar();

        assertNotNull(response.getBody());

        assertEquals(1,
                response.getBody().size());

        verify(service, times(1))
                .listar();
    }

    @Test
    void guardar() {

        when(service.guardar(detalle))
                .thenReturn(detalle);

        ResponseEntity<DetalleVenta> response =
                controller.guardar(detalle);

        assertNotNull(response.getBody());

        assertEquals(1L,
                response.getBody().getId());

        verify(service, times(1))
                .guardar(detalle);
    }

    @Test
    void obtenerPorId() {

        when(service.obtenerPorId(1L))
                .thenReturn(detalle);

        ResponseEntity<DetalleVenta> response =
                controller.obtenerPorId(1L);

        assertNotNull(response.getBody());

        assertEquals(1L,
                response.getBody().getId());

        verify(service, times(1))
                .obtenerPorId(1L);
    }

    @Test
    void actualizar() {

        when(service.actualizar(1L, detalle))
                .thenReturn(detalle);

        ResponseEntity<DetalleVenta> response =
                controller.actualizar(1L, detalle);

        assertNotNull(response.getBody());

        assertEquals(1L,
                response.getBody().getId());

        verify(service, times(1))
                .actualizar(1L, detalle);
    }

    @Test
    void eliminar() {

        doNothing().when(service)
                .eliminar(1L);

        ResponseEntity<Void> response =
                controller.eliminar(1L);

        assertEquals(204,
                response.getStatusCodeValue());

        verify(service, times(1))
                .eliminar(1L);
    }
}