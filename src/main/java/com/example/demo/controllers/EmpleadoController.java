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

    // ==========================
    // CRUD
    // ==========================

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
    public Empleado actualizar(@PathVariable Long id,
            @RequestBody Empleado empleado) {
        return service.actualizar(id, empleado);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    // ==========================
    // CONSULTAS PERSONALIZADAS
    // ==========================

    @GetMapping("/dni/{dni}")
    public Empleado buscarPorDni(@PathVariable String dni) {
        return service.buscarPorDni(dni);
    }

    @GetMapping("/correo/{correo}")
    public Empleado buscarPorCorreo(@PathVariable String correo) {
        return service.buscarPorCorreo(correo);
    }

    @GetMapping("/apellidos/{apellidos}")
    public List<Empleado> buscarPorApellidos(@PathVariable String apellidos) {
        return service.buscarPorApellidos(apellidos);
    }

    @GetMapping("/nombre/{nombre}")
    public List<Empleado> buscarPorNombre(@PathVariable String nombre) {
        return service.buscarPorNombre(nombre);
    }

    @GetMapping("/existe-dni/{dni}")
    public boolean existeDni(@PathVariable String dni) {
        return service.existeDni(dni);
    }

    @GetMapping("/existe-correo/{correo}")
    public boolean existeCorreo(@PathVariable String correo) {
        return service.existeCorreo(correo);
    }
}