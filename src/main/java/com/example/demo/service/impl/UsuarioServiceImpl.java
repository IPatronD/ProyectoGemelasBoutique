package com.example.demo.service.impl;

import com.example.demo.models.Usuario;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.UsuarioService;

import org.springframework.stereotype.Service;

import java.util.List;

// Servicio de Usuario
@Service
public class UsuarioServiceImpl
        implements UsuarioService {

    // Repositorio
    private final UsuarioRepository repository;

    // Constructor
    public UsuarioServiceImpl(
            UsuarioRepository repository) {

        this.repository = repository;
    }

    // Listar usuarios
    @Override
    public List<Usuario> listar() {

        return repository.findAll();
    }

    // Guardar usuario
    @Override
    public Usuario guardar(
            Usuario usuario) {

        // Validar username repetido
        if (repository.existsByUsername(
                usuario.getUsername())) {

            throw new RuntimeException(
                    "El username ya existe");
        }

        // Guardar usuario
        return repository.save(usuario);
    }

    // Obtener usuario por id
    @Override
    public Usuario obtener(Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Usuario no encontrado"));
    }

    // Actualizar usuario
    @Override
    public Usuario actualizar(
            Long id,
            Usuario usuario) {

        // Buscar usuario existente
        Usuario existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Usuario no encontrado"));

        // Actualizar datos
        existente.setUsername(
                usuario.getUsername());

        existente.setPassword(
                usuario.getPassword());

        existente.setEstado(
                usuario.isEstado());

        existente.setEmpleado(
                usuario.getEmpleado());

        // Actualizar roles
        existente.setRoles(
                usuario.getRoles());

        // Guardar cambios
        return repository.save(existente);
    }

    // Eliminar usuario
    @Override
    public void eliminar(Long id) {

        // Buscar usuario
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Usuario no encontrado"));

        // Eliminar usuario
        repository.delete(usuario);
    }

    // ==========================
    // CONSULTAS PERSONALIZADAS
    // ==========================

    // Buscar por username
    @Override
    public Usuario buscarPorUsername(
            String username) {

        return repository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException(
                        "Usuario no encontrado"));
    }

    // Buscar usuarios por rol
    @Override
    public List<Usuario> buscarPorRol(
            String rol) {

        return repository.buscarPorRol(rol);
    }

    // Listar usuarios activos
    @Override
    public List<Usuario> listarActivos() {

        return repository.findByEstado(true);
    }

    // Verificar si existe username
    @Override
    public boolean existeUsername(
            String username) {

        return repository.existsByUsername(username);
    }
}