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
// Habilita Mockito en JUnit 5
class UsuarioServiceImplTest {

    @Mock // Simula el repositorio
    private UsuarioRepository repository;

    @InjectMocks // Inyecta el mock en el servicio
    private UsuarioServiceImpl service;

    // Método helper para crear usuarios de prueba
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

    @Test // Prueba listar()
    void listarDebeRetornarListaDeUsuarios() {
        Usuario u1 = crearUsuario(1L);
        Usuario u2 = crearUsuario(2L);

        when(repository.findAll()).thenReturn(Arrays.asList(u1, u2));

        List<Usuario> resultado = service.listar();

        assertEquals(2, resultado.size());

        verify(repository, times(1)).findAll();
    }

    @Test // Prueba guardar()
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

    @Test // Prueba obtener cuando existe
    void obtenerDebeRetornarUsuarioCuandoExiste() {
        Usuario usuario = crearUsuario(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(usuario));

        Usuario resultado = service.obtener(1L);

        assertNotNull(resultado);
        assertEquals("Diego", resultado.getNombres());

        verify(repository, times(1)).findById(1L);
    }

    @Test // Prueba obtener cuando NO existe
    void obtenerDebeRetornarNullCuandoNoExiste() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        Usuario resultado = service.obtener(1L);

        assertNull(resultado);

        verify(repository, times(1)).findById(1L);
    }

    @Test // 🔥 TE FALTABA ESTE: actualizar()
    void actualizarDebeModificarUsuarioCuandoExiste() {
        Usuario existente = crearUsuario(1L);
        Usuario nuevosDatos = crearUsuario(null);
        nuevosDatos.setNombres("Carlos");

        when(repository.findById(1L)).thenReturn(Optional.of(existente));

        // Devuelve el objeto actualizado
        when(repository.save(any(Usuario.class))).thenAnswer(inv -> inv.getArgument(0));

        Usuario resultado = service.actualizar(1L, nuevosDatos);

        assertNotNull(resultado);
        assertEquals("Carlos", resultado.getNombres());

        verify(repository).findById(1L);
        verify(repository).save(existente);
    }

    @Test // Caso cuando NO existe
    void actualizarDebeRetornarNullCuandoNoExiste() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        Usuario resultado = service.actualizar(1L, crearUsuario(null));

        assertNull(resultado);

        verify(repository).findById(1L);
        verify(repository, never()).save(any());
    }

    @Test // Prueba eliminar()
    void eliminarDebeLlamarAlRepositorio() {
        doNothing().when(repository).deleteById(1L);

        service.eliminar(1L);

        verify(repository, times(1)).deleteById(1L);
    }
}