package com.example.demo.controllers;

import com.example.demo.models.Producto;
import com.example.demo.service.ProductoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductoControllerTest {

    @Mock
    private ProductoService service;

    @InjectMocks
    private ProductoController controller;

    private Producto producto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        producto = new Producto();
        producto.setId(1L);
        producto.setNombre("Laptop");
        producto.setDescripcion("Laptop Gamer"); // ajusta según tu modelo
    }

    @Test
    void testListar() {
        when(service.listar()).thenReturn(Arrays.asList(producto));

        List<Producto> resultado = controller.listar();

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        verify(service, times(1)).listar();
    }

    @Test
    void testGuardar() {
        when(service.guardar(any(Producto.class))).thenReturn(producto);

        Producto resultado = controller.guardar(producto);

        assertNotNull(resultado);
        assertEquals("Laptop", resultado.getNombre());
        verify(service, times(1)).guardar(producto);
    }

    @Test
    void testObtener() {
        when(service.obtener(1L)).thenReturn(producto);

        Producto resultado = controller.obtener(1L);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        verify(service, times(1)).obtener(1L);
    }

    @Test
    void testActualizar() {
        when(service.actualizar(eq(1L), any(Producto.class))).thenReturn(producto);

        Producto resultado = controller.actualizar(1L, producto);

        assertNotNull(resultado);
        assertEquals("Laptop", resultado.getNombre());
        verify(service, times(1)).actualizar(1L, producto);
    }

    @Test
    void testEliminar() {
        doNothing().when(service).eliminar(1L);

        controller.eliminar(1L);

        verify(service, times(1)).eliminar(1L);
    }
}