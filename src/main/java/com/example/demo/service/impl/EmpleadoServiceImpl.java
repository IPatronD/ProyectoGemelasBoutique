package com.example.demo.service.impl;

import com.example.demo.models.Empleado;
import com.example.demo.repository.EmpleadoRepository;
import com.example.demo.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository repository;

    @Override
    public List<Empleado> listar() {
        return repository.findAll();
    }

    @Override
    public Empleado guardar(Empleado empleado) {
        return repository.save(empleado);
    }

    @Override
    public Empleado obtener(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Empleado actualizar(Long id, Empleado empleado) {

        Empleado existente = repository.findById(id).orElse(null);

        if (existente != null) {

            existente.setNombres(empleado.getNombres());
            existente.setApellidos(empleado.getApellidos());
            existente.setDni(empleado.getDni());
            existente.setCorreo(empleado.getCorreo());

            return repository.save(existente);
        }

        return null;
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    // ==========================
    // CONSULTAS PERSONALIZADAS
    // ==========================

    @Override
    public Empleado buscarPorDni(String dni) {
        return repository.findByDni(dni).orElse(null);
    }

    @Override
    public Empleado buscarPorCorreo(String correo) {
        return repository.findByCorreo(correo).orElse(null);
    }

    @Override
    public List<Empleado> buscarPorApellidos(String apellidos) {
        return repository.findByApellidosContainingIgnoreCase(apellidos);
    }

    @Override
    public List<Empleado> buscarPorNombre(String nombre) {
        return repository.findByNombresContainingIgnoreCase(nombre);
    }

    @Override
    public boolean existeDni(String dni) {
        return repository.existsByDni(dni);
    }

    @Override
    public boolean existeCorreo(String correo) {
        return repository.existsByCorreo(correo);
    }
}