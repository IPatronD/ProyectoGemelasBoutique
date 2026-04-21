package com.example.demo.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.models.DetalleVenta;
import com.example.demo.service.DetalleVentaService;

@RestController
@RequestMapping("/api/detalle-ventas")
@CrossOrigin("*")
public class DetalleVentaController {

    private final DetalleVentaService service;

    public DetalleVentaController(DetalleVentaService service) {
        this.service = service;
    }

    @GetMapping
    public List<DetalleVenta> listar() {
        return service.listar();
    }

    @PostMapping
    public DetalleVenta guardar(@RequestBody DetalleVenta detalleVenta) {
        return service.guardar(detalleVenta);
    }

    @GetMapping("/{id}")
    public DetalleVenta obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}