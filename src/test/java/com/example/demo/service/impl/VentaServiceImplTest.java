package com.example.demo.service.impl;

import com.example.demo.models.Venta;
import com.example.demo.repository.VentaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VentaServiceImplTest {

    @Mock
    private VentaRepository repository;

    @InjectMocks
    private VentaServiceImpl ventaService;

    @Test
    void listar() {

        Venta v1 = new Venta();
        v1.setTotal(100.0);
        when(repository.findAll()).thenReturn(List.of(v1));

        List<Venta> resultado = ventaService.listar();

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        verify(repository).findAll();
    }

    @Test
    void guardar() {

        Venta venta = new Venta();
        venta.setTotal(500.0);
        when(repository.save(any(Venta.class))).thenReturn(venta);

        Venta resultado = ventaService.guardar(venta);

        assertNotNull(resultado);
        assertEquals(500.0, resultado.getTotal());
        verify(repository).save(venta);
    }

    @Test
    void obtener() {

        Long id = 1L;
        Venta venta = new Venta();
        venta.setId(id);

        when(repository.findById(id)).thenReturn(Optional.of(venta));

        Venta resultado = ventaService.obtener(id);

        assertNotNull(resultado);
        assertEquals(id, resultado.getId());
        verify(repository).findById(id);
    }
}