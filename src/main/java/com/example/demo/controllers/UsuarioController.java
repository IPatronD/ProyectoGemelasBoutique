package com.example.demo.controllers;

import com.example.demo.models.Usuario;

import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indica que es un controlador REST (responde en JSON)
@RequestMapping("/api/usuarios") // Ruta base: /api/usuarios
public class UsuarioController {

    @Autowired // Inyección automática del servicio
    private UsuarioService service;

    @GetMapping // Endpoint GET -> listar todos los usuarios
    public List<Usuario> listar(){
        return service.listar(); // Obtiene la lista desde el servicio
    }

    @PostMapping // Endpoint POST -> guardar un nuevo usuario
    public Usuario guardar(@RequestBody Usuario usuario){
        // Convierte el JSON en un objeto Usuario
        return service.guardar(usuario); // Guarda el usuario
    }

    @GetMapping("/{id}") // Endpoint GET -> obtener usuario por ID
    public Usuario obtener(@PathVariable Long id){
        // Captura el ID desde la URL
        return service.obtener(id); // Busca el usuario
    }

    @PutMapping("/{id}") // Endpoint PUT -> actualizar un usuario
    public Usuario actualizar(@PathVariable Long id, @RequestBody Usuario usuario){
        usuario.setId(id); // Asigna el ID al objeto
        return service.guardar(usuario); // Reutiliza guardar para actualizar
    }

    @DeleteMapping("/{id}") // Endpoint DELETE -> eliminar usuario
    public void eliminar(@PathVariable Long id){
        service.eliminar(id); // Elimina el usuario
    }
}