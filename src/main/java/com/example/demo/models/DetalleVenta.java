package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter // Genera automáticamente los setters
@Getter // Genera automáticamente los getters
@Entity // Indica que es una entidad de base de datos
@Table(name = "detalle_venta") // Nombre de la tabla en la BD
public class DetalleVenta {

    @Id // Clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // ID autogenerado (auto-incremental)
    private Long id;

    @ManyToOne
    // Relación muchos a uno: muchos detalles pertenecen a una venta
    @JoinColumn(name = "venta_id")
    // Columna que conecta con la tabla venta
    private Venta venta;

    @ManyToOne
    // Relación muchos a uno: muchos detalles pueden tener el mismo producto
    @JoinColumn(name = "producto_id")
    // Columna que conecta con la tabla producto
    private Producto producto;

    private int cantidad; // Cantidad de productos vendidos
    private double precio; // Precio del producto en la venta

    // Constructor vacío (necesario para JPA)
    public DetalleVenta() {}
}