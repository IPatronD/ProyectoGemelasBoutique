package com.example.demo.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.models.MetodoPago;
import com.example.demo.repository.MetodoPagoRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MetodoPagoServiceImplTest {

    @Mock
    private MetodoPagoRepository repository;

    @InjectMocks
    private MetodoPagoServiceImpl service;

    private MetodoPago metodo;

    @BeforeEach
    void setUp() {
        metodo = new MetodoPago();
        metodo.setId(1L);
        metodo.setNombre("Efectivo");
    }

    @Test
    void listar() {
        when(repository.findAll()).thenReturn(Arrays.asList(metodo));

        var lista = service.listar();

        assertEquals(1, lista.size());
        verify(repository).findAll();
    }

    @Test
    void guardar() {
        when(repository.save(metodo)).thenReturn(metodo);

        MetodoPago resultado = service.guardar(metodo);

        assertNotNull(resultado);
        assertEquals("Efectivo", resultado.getNombre());
        verify(repository).save(metodo);
    }

    @Test
    void actualizar() {
        MetodoPago nuevo = new MetodoPago();
        nuevo.setNombre("Yape");

        when(repository.findById(1L)).thenReturn(Optional.of(metodo));
        when(repository.save(any(MetodoPago.class))).thenReturn(metodo);

        MetodoPago resultado = service.actualizar(1L, nuevo);

        assertEquals("Yape", resultado.getNombre());
        verify(repository).findById(1L);
        verify(repository).save(metodo);
    }

    @Test
    void eliminar() {
        service.eliminar(1L);

        verify(repository).deleteById(1L);
    }
}