package com.example.demo.controllers;

import java.util.List;
import com.example.demo.models.MetodoPago;
import com.example.demo.service.MetodoPagoService;
import org.springframework.web.bind.annotation.*;


@RestController // Indica que es un controlador REST (responde en JSON)
@RequestMapping("/api/metodos-pago") // Ruta base de los endpoints
public class MetodoPagoController {

    private final MetodoPagoService service;

    // Constructor para inyección de dependencias (buena práctica)
    public MetodoPagoController(MetodoPagoService service) {
        this.service = service;
    }

    @GetMapping // Endpoint GET -> listar todos los métodos de pago
    public List<MetodoPago> listar() {
        return service.listar(); // Obtiene la lista desde el servicio
    }

    @PostMapping // Endpoint POST -> guardar un nuevo método de pago
    public MetodoPago guardar(@RequestBody MetodoPago metodoPago) {
        // @RequestBody convierte el JSON en objeto MetodoPago
        return service.guardar(metodoPago); // Guarda el método de pago
    }

    @PutMapping("/{id}") // Endpoint PUT -> actualizar un método de pago
    public MetodoPago actualizar(@PathVariable Long id, @RequestBody MetodoPago metodoPago) {
        // @PathVariable obtiene el ID desde la URL
        return service.actualizar(id, metodoPago); // Actualiza el método de pago
    }

    @DeleteMapping("/{id}") // Endpoint DELETE -> eliminar por ID
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id); // Elimina el método de pago
    }
}