package com.example.demo.controllers;

import com.example.demo.models.Empleado;
import com.example.demo.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indica que es un controlador REST (responde con JSON)
@RequestMapping("/api/empleados") // Ruta base para los endpoints
public class EmpleadoController {

    @Autowired // Inyección automática del servicio
    private EmpleadoService service;

    @GetMapping // Endpoint GET -> listar todos los empleados
    public List<Empleado> listar() {
        return service.listar(); // Llama al servicio para obtener la lista
    }

    @PostMapping // Endpoint POST -> guardar un nuevo empleado
    public Empleado guardar(@RequestBody Empleado empleado) {
        // @RequestBody convierte el JSON en objeto Empleado
        return service.guardar(empleado); // Guarda el empleado
    }

    @GetMapping("/{id}") // Endpoint GET -> obtener empleado por ID
    public Empleado obtener(@PathVariable Long id) {
        // @PathVariable obtiene el ID desde la URL
        return service.obtener(id); // Busca el empleado
    }

    @PutMapping("/{id}") // Endpoint PUT -> actualizar un empleado
    public Empleado actualizar(@PathVariable Long id, @RequestBody Empleado empleado) {
        empleado.setId(id); // Asigna el ID recibido al objeto
        return service.guardar(empleado); // Reutiliza guardar para actualizar
    }

    @DeleteMapping("/{id}") // Endpoint DELETE -> eliminar empleado por ID
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id); // Elimina el empleado
    }
}