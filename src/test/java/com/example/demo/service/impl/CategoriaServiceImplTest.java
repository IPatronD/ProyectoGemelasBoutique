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

    @Mock
    private CategoriaRepository repository;

    @InjectMocks
    private CategoriaServiceImpl service;

    private Categoria categoria;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        categoria = new Categoria();
        categoria.setId(1L);
        categoria.setNombre("Electrónica");
        categoria.setDescripcion("Dispositivos electrónicos");
    }

    @Test
    void testListar() {
        when(repository.findAll()).thenReturn(Arrays.asList(categoria));

        List<Categoria> resultado = service.listar();

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void testGuardar() {
        when(repository.save(any(Categoria.class))).thenReturn(categoria);

        Categoria resultado = service.guardar(categoria);

        assertNotNull(resultado);
        assertEquals("Electrónica", resultado.getNombre());
        verify(repository, times(1)).save(categoria);
    }

    @Test
    void testObtener_existente() {
        when(repository.findById(1L)).thenReturn(Optional.of(categoria));

        Categoria resultado = service.obtener(1L);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void testObtener_noExistente() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        Categoria resultado = service.obtener(1L);

        assertNull(resultado);
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void testActualizar_existente() {
        Categoria nuevosDatos = new Categoria();
        nuevosDatos.setNombre("Hogar");
        nuevosDatos.setDescripcion("Artículos del hogar");

        when(repository.findById(1L)).thenReturn(Optional.of(categoria));
        when(repository.save(any(Categoria.class))).thenReturn(categoria);

        Categoria resultado = service.actualizar(1L, nuevosDatos);

        assertNotNull(resultado);
        assertEquals("Hogar", resultado.getNombre());
        assertEquals("Artículos del hogar", resultado.getDescripcion());

        verify(repository).findById(1L);
        verify(repository).save(categoria);
    }

    @Test
    void testActualizar_noExistente() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        Categoria resultado = service.actualizar(1L, categoria);

        assertNull(resultado);
        verify(repository).findById(1L);
        verify(repository, never()).save(any());
    }

    @Test
    void testEliminar() {
        doNothing().when(repository).deleteById(1L);

        service.eliminar(1L);

        verify(repository, times(1)).deleteById(1L);
    }
}