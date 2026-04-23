package com.example.demo.controllers;

import com.example.demo.models.Empleado;
import com.example.demo.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService service;

    @GetMapping
    public List<Empleado> listar() {
        return service.listar();
    }

    @PostMapping
    public Empleado guardar(@RequestBody Empleado empleado) {
        return service.guardar(empleado);
    }

    @GetMapping("/{id}")
    public Empleado obtener(@PathVariable Long id) {
        return service.obtener(id);
    }

    @PutMapping("/{id}")
    public Empleado actualizar(@PathVariable Long id, @RequestBody Empleado empleado) {
        empleado.setId(id);
        return service.guardar(empleado);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}