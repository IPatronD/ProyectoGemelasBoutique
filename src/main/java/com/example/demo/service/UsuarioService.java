package com.example.demo.service;

import com.example.demo.models.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> listar(){
        return repository.findAll();
    }

    public Usuario guardar(Usuario usuario){
        return repository.save(usuario);
    }

    public Usuario obtener (Long id){
        return repository.findById(id).orElse(null);
    }

    public void eliminar(Long id){
        repository.deleteById(id) ;
    }
}
