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
    public List<Usuario> listar(){
        return repository.findAll();
    }

    @Override
    public Usuario guardar(Usuario usuario){
        return repository.save(usuario);
    }

    @Override
    public Usuario obtener(Long id){
        return repository.findById(id).orElse(null);
    }

    @Override
    public Usuario actualizar(Long id, Usuario usuario) {
        Usuario existente = repository.findById(id).orElse(null);

        if (existente != null) {
            existente.setNombres(usuario.getNombres());
            existente.setApellidos(usuario.getApellidos());
            existente.setDni(usuario.getDni());
            existente.setCorreo(usuario.getCorreo());
            existente.setEmpleado(usuario.getEmpleado());

            return repository.save(existente);
        }

        return null; // o lanzar excepción
    }

    @Override
    public void eliminar(Long id){
        repository.deleteById(id);
    }
}