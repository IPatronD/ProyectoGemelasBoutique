package com.example.demo.service;

import com.example.demo.models.Usuario;
import java.util.List;

public interface UsuarioService {

    List<Usuario> listar();

    Usuario guardar(Usuario usuario);

    Usuario obtener(Long id);

    void eliminar(Long id);
}