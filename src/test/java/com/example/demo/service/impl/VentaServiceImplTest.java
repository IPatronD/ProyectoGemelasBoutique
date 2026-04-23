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
// Habilita Mockito en JUnit 5
class VentaServiceImplTest {

    @Mock // Simula el repositorio
    private VentaRepository repository;

    @InjectMocks // Inyecta el mock en el servicio
    private VentaServiceImpl ventaService;

    @Test // Prueba del método listar()
    void listar() {

        Venta v1 = new Venta(); // Objeto de prueba
        v1.setTotal(100.0);

        // Simula que el repositorio devuelve una lista con una venta
        when(repository.findAll()).thenReturn(List.of(v1));

        // Ejecuta el método del servicio
        List<Venta> resultado = ventaService.listar();

        // Validaciones
        assertNotNull(resultado); // No debe ser null
        assertEquals(1, resultado.size()); // Debe tener 1 elemento

        // Verifica que se llamó al repositorio
        verify(repository).findAll();
    }

    @Test // Prueba del método guardar()
    void guardar() {

        Venta venta = new Venta(); // Objeto de prueba
        venta.setTotal(500.0);

        // Simula el guardado
        when(repository.save(any(Venta.class))).thenReturn(venta);

        // Ejecuta el método
        Venta resultado = ventaService.guardar(venta);

        // Validaciones
        assertNotNull(resultado);
        assertEquals(500.0, resultado.getTotal());

        // Verifica que se llamó al repositorio
        verify(repository).save(venta);
    }

    @Test // Prueba del método obtener()
    void obtener() {

        Long id = 1L;

        Venta venta = new Venta(); // Objeto de prueba
        venta.setId(id);

        // Simula búsqueda por ID
        when(repository.findById(id)).thenReturn(Optional.of(venta));

        // Ejecuta el método
        Venta resultado = ventaService.obtener(id);

        // Validaciones
        assertNotNull(resultado);
        assertEquals(id, resultado.getId());

        // Verifica que se llamó al repositorio
        verify(repository).findById(id);
    }
}