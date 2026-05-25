package com.example.demo.repository;

import com.example.demo.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
//BY JAMES

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findByNombreContainingIgnoreCase(String nombre);

    List<Producto> findByCategoriaId(Long categoriaId);

    List<Producto> findByStockLessThan(int stock);

    List<Producto> findByPrecioBetween(double min, double max);
}
