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
    public void eliminar(Long id){
        repository.deleteById(id);
    }
}