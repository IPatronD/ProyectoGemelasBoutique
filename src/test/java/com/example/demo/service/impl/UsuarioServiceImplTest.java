package com.example.demo.service.impl;

import com.example.demo.models.Usuario;
import com.example.demo.repository.UsuarioRepository;
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
// Habilita Mockito para JUnit 5
class UsuarioServiceImplTest {

    @Mock // Simula el repositorio
    private UsuarioRepository repository;

    @InjectMocks // Inyecta el mock en el servicio
    private UsuarioServiceImpl service;

    // Crea usuarios de prueba
    private Usuario crearUsuario(Long id) {
        return new Usuario(
                id,
                "dcabanillas",
                "123456",
                "ADMIN",
                true,
                null);
    }

    @Test
    void listarDebeRetornarListaDeUsuarios() {

        Usuario u1 = crearUsuario(1L);
        Usuario u2 = crearUsuario(2L);

        when(repository.findAll()).thenReturn(Arrays.asList(u1, u2));

        List<Usuario> resultado = service.listar();

        assertEquals(2, resultado.size());

        verify(repository, times(1)).findAll();
    }

    @Test
    void guardarDebePersistirUsuario() {

        Usuario usuario = crearUsuario(null);
        Usuario usuarioGuardado = crearUsuario(1L);

        when(repository.save(usuario)).thenReturn(usuarioGuardado);

        Usuario resultado = service.guardar(usuario);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals("dcabanillas", resultado.getUsername());

        verify(repository, times(1)).save(usuario);
    }

    @Test
    void obtenerDebeRetornarUsuarioCuandoExiste() {

        Usuario usuario = crearUsuario(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(usuario));

        Usuario resultado = service.obtener(1L);

        assertNotNull(resultado);
        assertEquals("dcabanillas", resultado.getUsername());

        verify(repository, times(1)).findById(1L);
    }

    @Test
    void obtenerDebeRetornarNullCuandoNoExiste() {

        when(repository.findById(1L)).thenReturn(Optional.empty());

        Usuario resultado = service.obtener(1L);

        assertNull(resultado);

        verify(repository, times(1)).findById(1L);
    }

    @Test
    void actualizarDebeModificarUsuarioCuandoExiste() {

        Usuario existente = crearUsuario(1L);
        Usuario nuevosDatos = crearUsuario(null);

        nuevosDatos.setUsername("carlos");

        when(repository.findById(1L)).thenReturn(Optional.of(existente));

        when(repository.save(any(Usuario.class)))
                .thenAnswer(inv -> inv.getArgument(0));

        Usuario resultado = service.actualizar(1L, nuevosDatos);

        assertNotNull(resultado);
        assertEquals("carlos", resultado.getUsername());

        verify(repository).findById(1L);
        verify(repository).save(existente);
    }

    @Test
    void actualizarDebeRetornarNullCuandoNoExiste() {

        when(repository.findById(1L)).thenReturn(Optional.empty());

        Usuario resultado = service.actualizar(1L, crearUsuario(null));

        assertNull(resultado);

        verify(repository).findById(1L);
        verify(repository, never()).save(any());
    }

    @Test
    void eliminarDebeLlamarAlRepositorio() {

        doNothing().when(repository).deleteById(1L);

        service.eliminar(1L);

        verify(repository, times(1)).deleteById(1L);
    }
}