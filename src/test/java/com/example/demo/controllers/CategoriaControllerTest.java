package com.example.demo.controllers;

import com.example.demo.models.Categoria;
import com.example.demo.service.CategoriaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoriaControllerTest {

    @Mock
    private CategoriaService service;

    @InjectMocks
    private CategoriaController controller;

    private Categoria categoria;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        categoria = new Categoria();
        categoria.setId(1L);
        categoria.setNombre("Electrónica"); // ajusta según tu modelo
    }

    @Test
    void testListar() {
        when(service.listar()).thenReturn(Arrays.asList(categoria));

        List<Categoria> resultado = controller.listar();

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        verify(service, times(1)).listar();
    }

    @Test
    void testGuardar() {
        when(service.guardar(any(Categoria.class))).thenReturn(categoria);

        Categoria resultado = controller.guardar(categoria);

        assertNotNull(resultado);
        assertEquals("Electrónica", resultado.getNombre());
        verify(service, times(1)).guardar(categoria);
    }

    @Test
    void testObtener() {
        when(service.obtener(1L)).thenReturn(categoria);

        Categoria resultado = controller.obtener(1L);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        verify(service, times(1)).obtener(1L);
    }

    @Test
    void testActualizar() {
        when(service.actualizar(eq(1L), any(Categoria.class))).thenReturn(categoria);

        Categoria resultado = controller.actualizar(1L, categoria);

        assertNotNull(resultado);
        assertEquals("Electrónica", resultado.getNombre());
        verify(service, times(1)).actualizar(1L, categoria);
    }

    @Test
    void testEliminar() {
        doNothing().when(service).eliminar(1L);

        controller.eliminar(1L);

        verify(service, times(1)).eliminar(1L);
    }
}