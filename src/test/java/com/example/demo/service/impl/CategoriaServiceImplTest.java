package com.example.demo.service.impl;

import com.example.demo.models.Categoria;
import com.example.demo.repository.CategoriaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoriaServiceImplTest {

    @Mock // Simula el repositorio
    private CategoriaRepository repository;

    @InjectMocks // Inyecta el mock en el servicio
    private CategoriaServiceImpl service;

    private Categoria categoria; // Objeto de prueba

    @BeforeEach // Se ejecuta antes de cada test
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa mocks

        categoria = new Categoria();
        categoria.setId(1L);
        categoria.setNombre("Electrónica");
        categoria.setDescripcion("Dispositivos electrónicos");
    }

    @Test // Prueba listar()
    void testListar() {
        // Simula que el repositorio devuelve una lista
        when(repository.findAll()).thenReturn(Arrays.asList(categoria));

        List<Categoria> resultado = service.listar();

        // Validaciones
        assertNotNull(resultado);
        assertEquals(1, resultado.size());

        // Verifica interacción
        verify(repository, times(1)).findAll();
    }

    @Test // Prueba guardar()
    void testGuardar() {
        // Simula guardado
        when(repository.save(any(Categoria.class))).thenReturn(categoria);

        Categoria resultado = service.guardar(categoria);

        assertNotNull(resultado);
        assertEquals("Electrónica", resultado.getNombre());

        verify(repository, times(1)).save(categoria);
    }

    @Test // Prueba obtener cuando existe
    void testObtener_existente() {
        when(repository.findById(1L)).thenReturn(Optional.of(categoria));

        Categoria resultado = service.obtener(1L);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());

        verify(repository, times(1)).findById(1L);
    }

    @Test // Prueba obtener cuando NO existe
    void testObtener_noExistente() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        Categoria resultado = service.obtener(1L);

        assertNull(resultado); // Correcto según tu lógica

        verify(repository, times(1)).findById(1L);
    }

    @Test // Prueba actualizar cuando existe
    void testActualizar_existente() {
        Categoria nuevosDatos = new Categoria();
        nuevosDatos.setNombre("Hogar");
        nuevosDatos.setDescripcion("Artículos del hogar");

        // Simula que encuentra la categoría
        when(repository.findById(1L)).thenReturn(Optional.of(categoria));
        when(repository.save(any(Categoria.class))).thenReturn(categoria);

        Categoria resultado = service.actualizar(1L, nuevosDatos);

        // Validaciones
        assertNotNull(resultado);
        assertEquals("Hogar", resultado.getNombre());
        assertEquals("Artículos del hogar", resultado.getDescripcion());

        verify(repository).findById(1L);
        verify(repository).save(categoria);
    }

    @Test // Prueba actualizar cuando NO existe
    void testActualizar_noExistente() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        Categoria resultado = service.actualizar(1L, categoria);

        assertNull(resultado); // Correcto según tu lógica

        verify(repository).findById(1L);
        verify(repository, never()).save(any()); // No debe guardar
    }

    @Test // Prueba eliminar()
    void testEliminar() {
        doNothing().when(repository).deleteById(1L);

        service.eliminar(1L);

        verify(repository, times(1)).deleteById(1L);
    }
}