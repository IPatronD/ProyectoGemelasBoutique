package com.example.demo.controllers;

import com.example.demo.models.Usuario;

import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }

    @PostMapping
    public Usuario guardar(@RequestBody Usuario usuario) {
        return service.guardar(usuario);
    }

    @GetMapping("/{id}")
    public Usuario obtener(@PathVariable Long id) {
        return service.obtener(id);
    }

    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable Long id,
            @RequestBody Usuario usuario) {
        return service.actualizar(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    @GetMapping("/username/{username}")
    public Usuario buscarPorUsername(@PathVariable String username) {
        return service.buscarPorUsername(username);
    }

    @GetMapping("/rol/{rol}")
    public List<Usuario> buscarPorRol(@PathVariable String rol) {
        return service.buscarPorRol(rol);
    }

    @GetMapping("/activos")
    public List<Usuario> listarActivos() {
        return service.listarActivos();
    }

    @GetMapping("/existe/{username}")
    public boolean existeUsername(@PathVariable String username) {
        return service.existeUsername(username);
    }
}