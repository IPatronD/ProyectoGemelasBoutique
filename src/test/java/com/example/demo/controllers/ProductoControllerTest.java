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

    @Mock // Crea un mock (simulación) del servicio
    private ProductoService service;

    @InjectMocks // Inyecta el mock dentro del controlador
    private ProductoController controller;

    private Producto producto; // Objeto de prueba

    @BeforeEach // Se ejecuta antes de cada test
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa los mocks

        producto = new Producto(); // Crea producto de prueba
        producto.setId(1L);
        producto.setNombre("Laptop");
        producto.setDescripcion("Laptop Gamer"); // Datos de ejemplo
    }

    @Test // Prueba del método listar()
    void testListar() {
        // Simula que el servicio devuelve una lista con un producto
        when(service.listar()).thenReturn(Arrays.asList(producto));

        // Ejecuta el método del controlador
        List<Producto> resultado = controller.listar();

        // Validaciones
        assertNotNull(resultado); // No debe ser null
        assertEquals(1, resultado.size()); // Debe tener 1 elemento

        // Verifica que se llamó al servicio
        verify(service, times(1)).listar();
    }

    @Test // Prueba del método guardar()
    void testGuardar() {
        // Simula el guardado
        when(service.guardar(any(Producto.class))).thenReturn(producto);

        // Ejecuta el método
        Producto resultado = controller.guardar(producto);

        // Validaciones
        assertNotNull(resultado);
        assertEquals("Laptop", resultado.getNombre());

        // Verifica que se llamó al servicio
        verify(service, times(1)).guardar(producto);
    }

    @Test // Prueba del método obtener()
    void testObtener() {
        // Simula búsqueda por ID
        when(service.obtener(1L)).thenReturn(producto);

        // Ejecuta el método
        Producto resultado = controller.obtener(1L);

        // Validaciones
        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());

        // Verifica que se llamó al servicio
        verify(service, times(1)).obtener(1L);
    }

    @Test // Prueba del método actualizar()
    void testActualizar() {
        // Simula actualización
        when(service.actualizar(eq(1L), any(Producto.class))).thenReturn(producto);

        // Ejecuta el método
        Producto resultado = controller.actualizar(1L, producto);

        // Validaciones
        assertNotNull(resultado);
        assertEquals("Laptop", resultado.getNombre());

        // Verifica que se llamó al servicio
        verify(service, times(1)).actualizar(1L, producto);
    }

    @Test // Prueba del método eliminar()
    void testEliminar() {
        // Simula eliminación (void)
        doNothing().when(service).eliminar(1L);

        // Ejecuta el método
        controller.eliminar(1L);

        // Verifica que se llamó al servicio
        verify(service, times(1)).eliminar(1L);
    }
}