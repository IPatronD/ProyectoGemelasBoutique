package com.example.demo.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.demo.models.DetalleVenta;
import com.example.demo.repository.DetalleVentaRepository;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class DetalleVentaServiceImplTest {

    @Mock
    private DetalleVentaRepository repository;

    @InjectMocks
    private DetalleVentaServiceImpl service;

    private DetalleVenta detalle;

    @BeforeEach
    void setUp() {
        detalle = new DetalleVenta();
        detalle.setId(1L);
        detalle.setCantidad(2);
        detalle.setPrecio(50.0);
    }

    @Test
    void listar() {
        when(repository.findAll()).thenReturn(Arrays.asList(detalle));

        var lista = service.listar();

        assertEquals(1, lista.size());
        verify(repository).findAll();
    }

    @Test
    void guardar() {
        when(repository.save(detalle)).thenReturn(detalle);

        DetalleVenta resultado = service.guardar(detalle);

        assertNotNull(resultado);
        assertEquals(2, resultado.getCantidad());
        verify(repository).save(detalle);
    }

    @Test
    void obtenerPorId() {
        when(repository.findById(1L)).thenReturn(Optional.of(detalle));

        DetalleVenta resultado = service.obtenerPorId(1L);

        assertEquals(1L, resultado.getId());
        verify(repository).findById(1L);
    }

    @Test
    void eliminar() {
        service.eliminar(1L);

        verify(repository).deleteById(1L);
    }
}
