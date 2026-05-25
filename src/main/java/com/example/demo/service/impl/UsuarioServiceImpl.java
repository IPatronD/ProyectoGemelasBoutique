package com.example.demo.service.impl;

import com.example.demo.models.Usuario;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public List<Usuario> listar() {
        return repository.findAll();
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    public Usuario obtener(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Usuario actualizar(Long id, Usuario usuario) {

        Usuario existente = repository.findById(id).orElse(null);

        if (existente != null) {
            existente.setUsername(usuario.getUsername());
            existente.setPassword(usuario.getPassword());
            existente.setRol(usuario.getRol());
            existente.setEstado(usuario.isEstado());
            existente.setEmpleado(usuario.getEmpleado());

            return repository.save(existente);
        }

        return null;
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Usuario buscarPorUsername(String username) {
        return repository.findByUsername(username).orElse(null);
    }

    @Override
    public List<Usuario> buscarPorRol(String rol) {
        return repository.findByRol(rol);
    }

    @Override
    public List<Usuario> listarActivos() {
        return repository.findByEstado(true);
    }

    @Override
    public boolean existeUsername(String username) {
        return repository.existsByUsername(username);
    }
}