package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.DetalleVenta;


public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {

}
