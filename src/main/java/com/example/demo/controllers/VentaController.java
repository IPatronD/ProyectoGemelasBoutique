package com.example.demo.controllers;

import com.example.demo.models.Venta;
import com.example.demo.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indica que es un controlador REST (responde en JSON)
@RequestMapping("/api/ventas") // Ruta base: /api/ventas
public class VentaController {

    @Autowired // Inyección automática del servicio
    private VentaService service;

    @GetMapping // Endpoint GET -> listar todas las ventas
    public List<Venta> listar() {
        return service.listar(); // Obtiene la lista desde el servicio
    }

    @PostMapping // Endpoint POST -> guardar una nueva venta
    public Venta guardar(@RequestBody Venta venta) {
        // Convierte el JSON en un objeto Venta
        return service.guardar(venta); // Guarda la venta
    }

    @GetMapping("/{id}") // Endpoint GET -> obtener una venta por ID
    public Venta obtener(@PathVariable Long id) {
        // Captura el ID desde la URL
        return service.obtener(id); // Busca la venta
    }
}