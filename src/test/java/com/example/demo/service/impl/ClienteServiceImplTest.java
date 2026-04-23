package com.example.demo.service.impl;

import com.example.demo.models.Cliente;
import com.example.demo.repository.ClienteRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClienteServiceImplTest {

    @Mock
    private ClienteRepository repository;

    @InjectMocks
    private ClienteServiceImpl service;

    @Test
    void listar_DebeRetornarLista() {
        when(repository.findAll()).thenReturn(Arrays.asList(new Cliente()));

        List<Cliente> response = service.listar();

        assertNotNull(response);
        verify(repository).findAll();
    }

    @Test
    void guardar_DebeGuardarCliente() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);

        when(repository.save(cliente)).thenReturn(cliente);

        Cliente response = service.guardar(cliente);

        assertNotNull(response);
        assertEquals(1L, response.getId());
        verify(repository).save(cliente);
    }

    @Test
    void buscarPorId_DebeRetornarCliente() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(cliente));

        Cliente response = service.buscarPorId(1L);

        assertNotNull(response);
        assertEquals(1L, response.getId());
    }

    @Test
    void buscarPorId_NoExiste_DebeRetornarNull() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        Cliente response = service.buscarPorId(1L);

        assertNull(response);
    }

    @Test
    void eliminar_DebeLlamarRepository() {
        service.eliminar(1L);

        verify(repository).deleteById(1L);
    }
}