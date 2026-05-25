package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.MetodoPago;

import java.util.Optional;


public interface MetodoPagoRepository extends JpaRepository<MetodoPago, Long> {

    Optional<MetodoPago> findByNombre(String nombre);
}
