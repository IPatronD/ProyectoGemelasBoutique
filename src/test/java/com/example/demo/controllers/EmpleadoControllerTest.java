package com.example.demo.controllers;

import com.example.demo.models.Empleado;
import com.example.demo.service.EmpleadoService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmpleadoControllerTest {

    @Mock
    private EmpleadoService service;

    @InjectMocks
    private EmpleadoController controller;

    @Test
    void listar_DebeRetornarLista() {

        when(service.listar()).thenReturn(Collections.emptyList());

        ResponseEntity<List<Empleado>> response =
                controller.listar();

        assertNotNull(response.getBody());

        verify(service, times(1)).listar();
    }

    @Test
    void obtener_DebeRetornarEmpleado() {

        Empleado e = new Empleado();
        e.setId(1L);

        when(service.obtener(1L)).thenReturn(e);

        ResponseEntity<Empleado> response =
                controller.obtener(1L);

        assertNotNull(response.getBody());

        assertEquals(1L,
                response.getBody().getId());

        verify(service, times(1)).obtener(1L);
    }

    @Test
    void guardar_DebeGuardarEmpleado() {

        Empleado e = new Empleado();
        e.setId(1L);

        when(service.guardar(e)).thenReturn(e);

        ResponseEntity<Empleado> response =
                controller.guardar(e);

        assertNotNull(response.getBody());

        assertEquals(1L,
                response.getBody().getId());

        verify(service, times(1)).guardar(e);
    }

    @Test
    void actualizar_DebeActualizarEmpleado() {

        Empleado e = new Empleado();
        e.setId(1L);

        when(service.actualizar(1L, e)).thenReturn(e);

        ResponseEntity<Empleado> response =
                controller.actualizar(1L, e);

        assertNotNull(response.getBody());

        assertEquals(1L,
                response.getBody().getId());

        verify(service, times(1))
                .actualizar(1L, e);
    }

    @Test
    void eliminar_DebeLlamarService() {

        doNothing().when(service).eliminar(1L);

        ResponseEntity<Void> response =
                controller.eliminar(1L);

        assertEquals(204,
                response.getStatusCodeValue());

        verify(service, times(1))
                .eliminar(1L);
    }
}