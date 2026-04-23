package com.example.demo.service.impl;

import com.example.demo.models.Producto;
import com.example.demo.repository.ProductoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductoServiceImplTest {

    @Mock
    private ProductoRepository repository;

    @InjectMocks
    private ProductoServiceImpl service;

    private Producto producto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        producto = new Producto();
        producto.setId(1L);
        producto.setNombre("Laptop");
        producto.setDescripcion("Laptop Gamer");
        producto.setPrecio(2500.0);
        producto.setStock(10);
        producto.setCategoria(null); // ajusta si tienes objeto Categoria
    }

    @Test
    void testListar() {
        when(repository.findAll()).thenReturn(Arrays.asList(producto));

        List<Producto> resultado = service.listar();

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void testGuardar() {
        when(repository.save(any(Producto.class))).thenReturn(producto);

        Producto resultado = service.guardar(producto);

        assertNotNull(resultado);
        assertEquals("Laptop", resultado.getNombre());
        verify(repository, times(1)).save(producto);
    }

    @Test
    void testObtener_existente() {
        when(repository.findById(1L)).thenReturn(Optional.of(producto));

        Producto resultado = service.obtener(1L);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void testObtener_noExistente() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        Producto resultado = service.obtener(1L);

        assertNull(resultado);
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void testActualizar_existente() {
        Producto nuevosDatos = new Producto();
        nuevosDatos.setNombre("PC");
        nuevosDatos.setDescripcion("PC de escritorio");
        nuevosDatos.setPrecio(1800.0);
        nuevosDatos.setStock(5);
        nuevosDatos.setCategoria(null);

        when(repository.findById(1L)).thenReturn(Optional.of(producto));
        when(repository.save(any(Producto.class))).thenReturn(producto);

        Producto resultado = service.actualizar(1L, nuevosDatos);

        assertNotNull(resultado);
        assertEquals("PC", resultado.getNombre());
        assertEquals("PC de escritorio", resultado.getDescripcion());
        assertEquals(1800.0, resultado.getPrecio());
        assertEquals(5, resultado.getStock());

        verify(repository).findById(1L);
        verify(repository).save(producto);
    }

    @Test
    void testActualizar_noExistente() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        Producto resultado = service.actualizar(1L, producto);

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