package com.example.demo.service;

import com.example.demo.models.Empleado;
import java.util.List;

public interface EmpleadoService {

    List<Empleado> listar();

    Empleado guardar(Empleado empleado);

    Empleado obtener(Long id);

    void eliminar(Long id);
}