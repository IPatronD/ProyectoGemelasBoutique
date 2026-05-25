package com.example.demo.repository;

import com.example.demo.models.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface VentaRepository extends JpaRepository<Venta,Long> {

    List<Venta> findByClienteId(Long clienteId);

    List<Venta> findByUsuarioId(Long usuarioId);

    List<Venta> findByFechaBetween(
            LocalDateTime inicio,
            LocalDateTime fin);
}
