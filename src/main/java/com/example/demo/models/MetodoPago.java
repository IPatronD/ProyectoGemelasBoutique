package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter // Genera automáticamente los setters
@Getter // Genera automáticamente los getters
@Entity // Indica que es una entidad de base de datos
@Table(name = "metodo_pago") // Nombre de la tabla en la BD
public class MetodoPago {

    @Id // Clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // ID autogenerado (auto-incremental)
    private Long id;

    @Column(nullable = false)
    // La columna no puede ser nula en la base de datos
    private String nombre; // Nombre del método de pago (ej: efectivo, tarjeta)

    // Constructor vacío (necesario para JPA)
    public MetodoPago() {}

    // Constructor con todos los atributos
    public MetodoPago(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}