package com.example.demo.repository;

import com.example.demo.models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    Optional<Empleado> findByDni(String dni);

    Optional<Empleado> findByCorreo(String correo);

    List<Empleado> findByApellidosContainingIgnoreCase(String apellidos);

    List<Empleado> findByNombresContainingIgnoreCase(String nombres);

    boolean existsByDni(String dni);

    boolean existsByCorreo(String correo);
}
