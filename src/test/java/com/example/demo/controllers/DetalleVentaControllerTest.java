package com.example.demo.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.models.DetalleVenta;
import com.example.demo.service.DetalleVentaService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
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
        when(service.listar()).thenReturn(Arrays.asList(detalle));

        var lista = controller.listar();

        assertEquals(1, lista.size());
        verify(service).listar();
    }

    @Test
    void guardar() {
        when(service.guardar(detalle)).thenReturn(detalle);

        DetalleVenta resultado = controller.guardar(detalle);

        assertNotNull(resultado);
        verify(service).guardar(detalle);
    }

    @Test
    void obtenerPorId() {
        when(service.obtenerPorId(1L)).thenReturn(detalle);

        DetalleVenta resultado = controller.obtenerPorId(1L);

        assertEquals(1L, resultado.getId());
        verify(service).obtenerPorId(1L);
    }

    @Test
    void eliminar() {
        controller.eliminar(1L);

        verify(service).eliminar(1L);
    }
}