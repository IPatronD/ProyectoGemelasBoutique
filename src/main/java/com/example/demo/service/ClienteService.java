package com.example.demo.service;

import com.example.demo.models.Cliente;
import java.util.List;

public interface ClienteService {

    List<Cliente> listar();

    Cliente guardar(Cliente cliente);

    Cliente buscarPorId(Long id);

    void eliminar(Long id);
}