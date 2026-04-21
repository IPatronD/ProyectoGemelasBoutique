package com.example.demo.service;

import com.example.demo.models.Producto;
import com.example.demo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//BY JAMES

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repository;

    public List<Producto> listar() {
        return repository.findAll();
    }

    public Producto guardar(Producto producto) {
        return repository.save(producto);
    }

    public Producto obtener(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Producto actualizar(Long id, Producto productoDetails) {
        return repository.findById(id).map(producto -> {
            producto.setNombre(productoDetails.getNombre());
            producto.setDescripcion(productoDetails.getDescripcion());
            producto.setPrecio(productoDetails.getPrecio());
            producto.setStock(productoDetails.getStock());
            producto.setCategoria(productoDetails.getCategoria());
            return repository.save(producto);
        }).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
