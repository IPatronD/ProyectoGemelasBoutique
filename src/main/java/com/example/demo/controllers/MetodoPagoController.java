package com.example.demo.controllers;

import java.util.List;
import com.example.demo.models.MetodoPago;
import com.example.demo.service.MetodoPagoService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/metodos-pago")
public class MetodoPagoController {

    private final MetodoPagoService service;

    public MetodoPagoController(MetodoPagoService service) {
        this.service = service;
    }

    @GetMapping
    public List<MetodoPago> listar() {
        return service.listar();
    }

    @PostMapping
    public MetodoPago guardar(@RequestBody MetodoPago metodoPago) {
        return service.guardar(metodoPago);
    }

    @PutMapping("/{id}")
    public MetodoPago actualizar(@PathVariable Long id, @RequestBody MetodoPago metodoPago) {
        return service.actualizar(id, metodoPago);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}