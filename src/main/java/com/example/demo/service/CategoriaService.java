package com.example.demo.service;

import com.example.demo.models.Categoria;
import com.example.demo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//BY JAMES

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> listar() {
        return repository.findAll();
    }

    public Categoria guardar(Categoria categoria) {
        return repository.save(categoria);
    }

    public Categoria obtener(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Categoria actualizar(Long id, Categoria categoriaDetails) {
        return repository.findById(id).map(categoria -> {
            categoria.setNombre(categoriaDetails.getNombre());
            categoria.setDescripcion(categoriaDetails.getDescripcion());
            return repository.save(categoria);
        }).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
