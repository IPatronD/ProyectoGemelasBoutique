package com.example.demo.controllers;

import com.example.demo.models.Producto;
import com.example.demo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//BY JAMES

@RestController // Indica que es un controlador REST (responde en JSON)
@RequestMapping("/api/productos") // Ruta base: /api/productos
public class ProductoController {

    @Autowired // Inyección automática del servicio
    private ProductoService service;

    @GetMapping // Endpoint GET -> listar todos los productos
    public List<Producto> listar() {
        return service.listar(); // Obtiene la lista desde el servicio
    }

    @PostMapping // Endpoint POST -> guardar un nuevo producto
    public Producto guardar(@RequestBody Producto producto) {
        // Convierte el JSON recibido en un objeto Producto
        return service.guardar(producto); // Guarda el producto
    }

    @GetMapping("/{id}") // Endpoint GET -> obtener un producto por ID
    public Producto obtener(@PathVariable Long id) {
        // Captura el ID desde la URL
        return service.obtener(id); // Busca el producto
    }

    @PutMapping("/{id}") // Endpoint PUT -> actualizar un producto
    public Producto actualizar(@PathVariable Long id, @RequestBody Producto producto) {
        // Se envía el ID y los nuevos datos del producto
        return service.actualizar(id, producto); // Actualiza el producto
    }

    @DeleteMapping("/{id}") // Endpoint DELETE -> eliminar un producto
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id); // Elimina el producto
    }
}