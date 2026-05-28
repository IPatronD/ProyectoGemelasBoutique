package com.example.demo.controllers;

import com.example.demo.models.Usuario;
import com.example.demo.service.UsuarioService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controlador REST
@RestController

// Ruta base
@RequestMapping("/api/usuarios")
public class UsuarioController {

    // Servicio
    private final UsuarioService service;

    // Constructor
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    // Listar usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {

        return ResponseEntity.ok(service.listar());
    }

    // Guardar usuario
    @PostMapping
    public ResponseEntity<Usuario> guardar(
            @Valid @RequestBody Usuario usuario) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.guardar(usuario));
    }

    // Buscar usuario por id
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtener(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                service.obtener(id));
    }

    // Actualizar usuario
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody Usuario usuario) {

        return ResponseEntity.ok(
                service.actualizar(id, usuario));
    }

    // Eliminar usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Long id) {

        service.eliminar(id);

        return ResponseEntity.noContent().build();
    }

    // Buscar por username
    @GetMapping("/username/{username}")
    public ResponseEntity<Usuario> buscarPorUsername(
            @PathVariable String username) {

        return ResponseEntity.ok(
                service.buscarPorUsername(username));
    }

    // Buscar usuarios por rol
    @GetMapping("/rol/{rol}")
    public ResponseEntity<List<Usuario>> buscarPorRol(
            @PathVariable String rol) {

        return ResponseEntity.ok(
                service.buscarPorRol(rol));
    }

    // Listar usuarios activos
    @GetMapping("/activos")
    public ResponseEntity<List<Usuario>> listarActivos() {

        return ResponseEntity.ok(
                service.listarActivos());
    }

    // Verificar username
    @GetMapping("/existe/{username}")
    public ResponseEntity<Boolean> existeUsername(
            @PathVariable String username) {

        return ResponseEntity.ok(
                service.existeUsername(username));
    }
}