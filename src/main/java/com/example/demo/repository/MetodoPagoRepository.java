package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.MetodoPago;


public interface MetodoPagoRepository extends JpaRepository<MetodoPago, Long> {
}
