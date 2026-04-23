package com.example.demo.service.impl;

import com.example.demo.models.Cliente;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl extends ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    public List<Cliente> listar() {
        return repository.findAll();
    }

    @Override
    public Cliente guardar(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}