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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
// Habilita Mockito para JUnit 5
class UsuarioServiceImplTest {

    @Mock
    // Simula el repositorio
    private UsuarioRepository repository;

    @InjectMocks
    // Inyecta el mock en el servicio
    private UsuarioServiceImpl service;

    // Método helper para crear usuarios
    private Usuario crearUsuario(Long id) {

        Usuario usuario = new Usuario();

        usuario.setId(id);
        usuario.setUsername("dcabanillas");
        usuario.setPassword("123456");
        usuario.setEstado(true);

        return usuario;
    }

    @Test
    // Prueba listar usuarios
    void listarDebeRetornarListaDeUsuarios() {

        Usuario u1 = crearUsuario(1L);
        Usuario u2 = crearUsuario(2L);

        // Simular lista
        when(repository.findAll())
                .thenReturn(Arrays.asList(u1, u2));

        // Ejecutar método
        List<Usuario> resultado = service.listar();

        // Validaciones
        assertEquals(2, resultado.size());

        // Verificar llamada
        verify(repository, times(1))
                .findAll();
    }

    @Test
    // Prueba guardar usuario
    void guardarDebePersistirUsuario() {

        Usuario usuario = crearUsuario(null);

        Usuario usuarioGuardado = crearUsuario(1L);

        // Username no existe
        when(repository.existsByUsername(
                usuario.getUsername()))
                .thenReturn(false);

        // Simular guardado
        when(repository.save(usuario))
                .thenReturn(usuarioGuardado);

        // Ejecutar método
        Usuario resultado = service.guardar(usuario);

        // Validaciones
        assertNotNull(resultado);

        assertEquals(1L,
                resultado.getId());

        assertEquals("dcabanillas",
                resultado.getUsername());

        // Verificar llamadas
        verify(repository, times(1))
                .existsByUsername(
                        usuario.getUsername());

        verify(repository, times(1))
                .save(usuario);
    }

    @Test
    // Prueba guardar username repetido
    void guardarDebeLanzarErrorSiUsernameExiste() {

        Usuario usuario = crearUsuario(null);

        // Simular username repetido
        when(repository.existsByUsername(
                usuario.getUsername()))
                .thenReturn(true);

        // Validar excepción
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> service.guardar(usuario));

        assertEquals(
                "El username ya existe",
                exception.getMessage());

        // Verificar llamada
        verify(repository, times(1))
                .existsByUsername(
                        usuario.getUsername());

        verify(repository, never())
                .save(any());
    }

    @Test
    // Prueba obtener usuario cuando existe
    void obtenerDebeRetornarUsuarioCuandoExiste() {

        Usuario usuario = crearUsuario(1L);

        // Simular búsqueda
        when(repository.findById(1L))
                .thenReturn(Optional.of(usuario));

        // Ejecutar método
        Usuario resultado = service.obtener(1L);

        // Validaciones
        assertNotNull(resultado);

        assertEquals("dcabanillas",
                resultado.getUsername());

        // Verificar llamada
        verify(repository, times(1))
                .findById(1L);
    }

    @Test
    // Prueba obtener usuario cuando no existe
    void obtenerDebeLanzarErrorCuandoNoExiste() {

        // Simular usuario inexistente
        when(repository.findById(1L))
                .thenReturn(Optional.empty());

        // Validar excepción
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> service.obtener(1L));

        assertEquals(
                "Usuario no encontrado",
                exception.getMessage());

        // Verificar llamada
        verify(repository, times(1))
                .findById(1L);
    }

    @Test
    // Prueba actualizar usuario
    void actualizarDebeModificarUsuario() {

        Usuario existente = crearUsuario(1L);

        Usuario nuevosDatos = crearUsuario(null);

        nuevosDatos.setUsername("carlos");

        // Simular búsqueda
        when(repository.findById(1L))
                .thenReturn(Optional.of(existente));

        // Simular save
        when(repository.save(any(Usuario.class)))
                .thenAnswer(inv -> inv.getArgument(0));

        // Ejecutar método
        Usuario resultado = service.actualizar(
                1L,
                nuevosDatos);

        // Validaciones
        assertNotNull(resultado);

        assertEquals("carlos",
                resultado.getUsername());

        // Verificar llamadas
        verify(repository, times(1))
                .findById(1L);

        verify(repository, times(1))
                .save(existente);
    }

    @Test
    // Prueba actualizar cuando no existe
    void actualizarDebeLanzarErrorCuandoNoExiste() {

        // Simular usuario inexistente
        when(repository.findById(1L))
                .thenReturn(Optional.empty());

        // Validar excepción
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> service.actualizar(
                        1L,
                        crearUsuario(null)));

        assertEquals(
                "Usuario no encontrado",
                exception.getMessage());

        // Verificar llamada
        verify(repository, times(1))
                .findById(1L);

        verify(repository, never())
                .save(any());
    }

    @Test
    // Prueba buscar por username
    void buscarPorUsernameDebeRetornarUsuario() {

        Usuario usuario = crearUsuario(1L);

        // Simular búsqueda
        when(repository.findByUsername(
                "dcabanillas"))
                .thenReturn(Optional.of(usuario));

        // Ejecutar método
        Usuario resultado = service.buscarPorUsername(
                "dcabanillas");

        // Validaciones
        assertNotNull(resultado);

        assertEquals("dcabanillas",
                resultado.getUsername());

        // Verificar llamada
        verify(repository, times(1))
                .findByUsername(
                        "dcabanillas");
    }

    @Test
    // Prueba buscar username inexistente
    void buscarPorUsernameDebeLanzarError() {

        // Simular no encontrado
        when(repository.findByUsername(
                "dcabanillas"))
                .thenReturn(Optional.empty());

        // Validar excepción
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> service.buscarPorUsername(
                        "dcabanillas"));

        assertEquals(
                "Usuario no encontrado",
                exception.getMessage());

        // Verificar llamada
        verify(repository, times(1))
                .findByUsername(
                        "dcabanillas");
    }

    @Test
    // Prueba buscar usuarios por rol
    void buscarPorRolDebeRetornarLista() {

        Usuario usuario = crearUsuario(1L);

        // Simular búsqueda
        when(repository.buscarPorRol("ADMIN"))
                .thenReturn(List.of(usuario));

        // Ejecutar método
        List<Usuario> resultado = service.buscarPorRol("ADMIN");

        // Validaciones
        assertEquals(1,
                resultado.size());

        // Verificar llamada
        verify(repository, times(1))
                .buscarPorRol("ADMIN");
    }

    @Test
    // Prueba listar usuarios activos
    void listarActivosDebeRetornarLista() {

        Usuario usuario = crearUsuario(1L);

        // Simular búsqueda
        when(repository.findByEstado(true))
                .thenReturn(List.of(usuario));

        // Ejecutar método
        List<Usuario> resultado = service.listarActivos();

        // Validaciones
        assertEquals(1,
                resultado.size());

        // Verificar llamada
        verify(repository, times(1))
                .findByEstado(true);
    }

    @Test
    // Prueba verificar username
    void existeUsernameDebeRetornarTrue() {

        // Simular existencia
        when(repository.existsByUsername(
                "dcabanillas"))
                .thenReturn(true);

        // Ejecutar método
        boolean resultado = service.existeUsername(
                "dcabanillas");

        // Validaciones
        assertTrue(resultado);

        // Verificar llamada
        verify(repository, times(1))
                .existsByUsername(
                        "dcabanillas");
    }

    @Test
    // Prueba eliminar usuario
    void eliminarDebeLlamarAlRepositorio() {

        Usuario usuario = crearUsuario(1L);

        // Simular búsqueda
        when(repository.findById(1L))
                .thenReturn(Optional.of(usuario));

        doNothing().when(repository)
                .delete(usuario);

        // Ejecutar método
        service.eliminar(1L);

        // Verificar llamadas
        verify(repository, times(1))
                .findById(1L);

        verify(repository, times(1))
                .delete(usuario);
    }
}