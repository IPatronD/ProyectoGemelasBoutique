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
class UsuarioServiceImplTest {

    @Mock
    private UsuarioRepository repository;

    @InjectMocks
    private UsuarioServiceImpl service;

    private Usuario crearUsuario(Long id) {
        return new Usuario(
                id,
                "Diego",
                "Cabanillas",
                "12345678",
                "diego@mail.com",
                null
        );
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
        assertEquals("Diego", resultado.getNombres());
        verify(repository, times(1)).save(usuario);
    }

    @Test
    void obtenerDebeRetornarUsuarioCuandoExiste() {
        Usuario usuario = crearUsuario(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(usuario));

        Usuario resultado = service.obtener(1L);

        assertNotNull(resultado);
        assertEquals("Diego", resultado.getNombres());
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
    void eliminarDebeLlamarAlRepositorio() {
        doNothing().when(repository).deleteById(1L);

        service.eliminar(1L);

        verify(repository, times(1)).deleteById(1L);
    }
}