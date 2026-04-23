package com.example.demo.controllers;

import com.example.demo.models.Empleado;
import com.example.demo.service.EmpleadoService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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

        List<Empleado> response = controller.listar();

        assertNotNull(response);
        verify(service).listar();
    }

    @Test
    void obtener_DebeRetornarEmpleado() {
        Empleado e = new Empleado();
        e.setId(1L);

        when(service.obtener(1L)).thenReturn(e);

        Empleado response = controller.obtener(1L);

        assertEquals(1L, response.getId());
    }

    @Test
    void guardar_DebeGuardarEmpleado() {
        Empleado e = new Empleado();
        e.setId(1L);

        when(service.guardar(e)).thenReturn(e);

        Empleado response = controller.guardar(e);

        assertNotNull(response);
        verify(service).guardar(e);
    }

    @Test
    void actualizar_DebeActualizarEmpleado() {
        Empleado e = new Empleado();
        e.setId(1L);

        when(service.guardar(e)).thenReturn(e);

        Empleado response = controller.actualizar(1L, e);

        assertEquals(1L, response.getId());
    }

    @Test
    void eliminar_DebeLlamarService() {
        controller.eliminar(1L);

        verify(service).eliminar(1L);
    }
}