package com.example.demo.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.models.DetalleVenta;
import com.example.demo.service.DetalleVentaService;

@RestController // Define que es un controlador REST (responde en JSON)
@RequestMapping("/api/detalle-ventas") // Ruta base de los endpoints
public class DetalleVentaController {

    private final DetalleVentaService service;

    // Constructor para inyección de dependencias (forma recomendada)
    public DetalleVentaController(DetalleVentaService service) {
        this.service = service;
    }

    @GetMapping // Endpoint GET -> listar todos los detalles de venta
    public List<DetalleVenta> listar() {
        return service.listar(); // Obtiene la lista desde el servicio
    }

    @PostMapping // Endpoint POST -> guardar un nuevo detalle de venta
    public DetalleVenta guardar(@RequestBody DetalleVenta detalleVenta) {
        // @RequestBody convierte el JSON en objeto DetalleVenta
        return service.guardar(detalleVenta); // Guarda el detalle
    }

    @GetMapping("/{id}") // Endpoint GET -> obtener un detalle por ID
    public DetalleVenta obtenerPorId(@PathVariable Long id) {
        // @PathVariable obtiene el ID desde la URL
        return service.obtenerPorId(id); // Busca el detalle
    }

    @DeleteMapping("/{id}") // Endpoint DELETE -> eliminar por ID
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id); // Elimina el detalle
    }
}