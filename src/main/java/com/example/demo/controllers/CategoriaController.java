package com.example.demo.controllers;

import com.example.demo.models.Categoria;

import com.example.demo.service.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

// Indica que esta clase es un controlador REST (devuelve JSON)
@RestController

// Define la ruta base para todos los endpoints: /api/categorias
@RequestMapping("/api/categorias")
public class CategoriaController {

    // Inyecta el servicio de Categoria automáticamente
    @Autowired
    private CategoriaService service;

    // Endpoint GET -> Lista todas las categorías
    // URL: /api/categorias
    @GetMapping
    public List<Categoria> listar() {
        return service.listar(); // Llama al servicio para obtener la lista
    }

    // Endpoint POST -> Guarda una nueva categoría
    // URL: /api/categorias
    @PostMapping
    public Categoria guardar(@RequestBody Categoria categoria) {
        // @RequestBody convierte el JSON en objeto Categoria
        return service.guardar(categoria); // Guarda la categoría
    }

    // Endpoint GET -> Obtiene una categoría por ID
    // URL: /api/categorias/{id}
    @GetMapping("/{id}")
    public Categoria obtener(@PathVariable Long id) {
        // @PathVariable captura el ID desde la URL
        return service.obtener(id); // Busca la categoría por ID
    }

    // Endpoint PUT -> Actualiza una categoría existente
    // URL: /api/categorias/{id}
    @PutMapping("/{id}")
    public Categoria actualizar(@PathVariable Long id, @RequestBody Categoria categoria) {
        return service.actualizar(id, categoria); // Actualiza la categoría
    }

    // Endpoint DELETE -> Elimina una categoría por ID
    // URL: /api/categorias/{id}
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id); // Elimina la categoría
    }
}