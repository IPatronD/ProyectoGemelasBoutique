package com.example.demo.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.models.MetodoPago;
import com.example.demo.service.MetodoPagoService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class MetodoPagoControllerTest {

    @Mock
    private MetodoPagoService service;

    @InjectMocks
    private MetodoPagoController controller;

    private MetodoPago metodo;

    @BeforeEach
    void setUp() {
        metodo = new MetodoPago();
        metodo.setId(1L);
        metodo.setNombre("Efectivo");
    }

    @Test
    void listar() {
        when(service.listar()).thenReturn(Arrays.asList(metodo));

        var lista = controller.listar();

        assertEquals(1, lista.size());
        verify(service).listar();
    }

    @Test
    void guardar() {
        when(service.guardar(metodo)).thenReturn(metodo);

        MetodoPago resultado = controller.guardar(metodo);

        assertNotNull(resultado);
        verify(service).guardar(metodo);
    }

    @Test
    void actualizar() {
        when(service.actualizar(1L, metodo)).thenReturn(metodo);

        MetodoPago resultado = controller.actualizar(1L, metodo);

        assertNotNull(resultado);
        verify(service).actualizar(1L, metodo);
    }

    @Test
    void eliminar() {
        controller.eliminar(1L);

        verify(service).eliminar(1L);
    }
}