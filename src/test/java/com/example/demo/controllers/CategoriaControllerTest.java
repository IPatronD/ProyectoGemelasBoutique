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

    @Mock // Crea un mock (simulación) del servicio
    private CategoriaService service;

    @InjectMocks // Inyecta el mock dentro del controlador
    private CategoriaController controller;

    private Categoria categoria; // Objeto de prueba

    @BeforeEach // Se ejecuta antes de cada prueba
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa los mocks

        categoria = new Categoria(); // Crea una categoría de prueba
        categoria.setId(1L);
        categoria.setNombre("Electrónica"); // Valor de ejemplo
    }

    @Test // Prueba del método listar()
    void testListar() {
        // Simula que el servicio devuelve una lista con una categoría
        when(service.listar()).thenReturn(Arrays.asList(categoria));

        // Ejecuta el método del controlador
        List<Categoria> resultado = controller.listar();

        // Verifica resultados
        assertNotNull(resultado); // No debe ser null
        assertEquals(1, resultado.size()); // Debe tener 1 elemento

        // Verifica que el servicio se llamó una vez
        verify(service, times(1)).listar();
    }

    @Test // Prueba del método guardar()
    void testGuardar() {
        // Simula el guardado
        when(service.guardar(any(Categoria.class))).thenReturn(categoria);

        Categoria resultado = controller.guardar(categoria);

        assertNotNull(resultado);
        assertEquals("Electrónica", resultado.getNombre());

        // Verifica que se llamó al servicio
        verify(service, times(1)).guardar(categoria);
    }

    @Test // Prueba del método obtener()
    void testObtener() {
        // Simula búsqueda por ID
        when(service.obtener(1L)).thenReturn(categoria);

        Categoria resultado = controller.obtener(1L);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());

        verify(service, times(1)).obtener(1L);
    }

    @Test // Prueba del método actualizar()
    void testActualizar() {
        // Simula actualización
        when(service.actualizar(eq(1L), any(Categoria.class))).thenReturn(categoria);

        Categoria resultado = controller.actualizar(1L, categoria);

        assertNotNull(resultado);
        assertEquals("Electrónica", resultado.getNombre());

        verify(service, times(1)).actualizar(1L, categoria);
    }

    @Test // Prueba del método eliminar()
    void testEliminar() {
        // Simula eliminación (no devuelve nada)
        doNothing().when(service).eliminar(1L);

        controller.eliminar(1L);

        // Verifica que se llamó al servicio
        verify(service, times(1)).eliminar(1L);
    }
}