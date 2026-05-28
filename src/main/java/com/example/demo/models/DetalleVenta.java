package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Setter // Genera setters
@Getter // Genera getters
@Entity // Entidad de la BD
@Table(name = "detalle_venta")
public class DetalleVenta {

    @Id // Clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "venta_id", nullable = false)
    // Muchos detalles pertenecen a una venta
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    // Muchos detalles pueden tener el mismo producto
    private Producto producto;

    @Positive(message = "La cantidad debe ser mayor a 0")
    // Cantidad vendida
    private int cantidad;

    @Positive(message = "El precio debe ser mayor a 0")
    // Precio del producto
    private double precio;

    @Positive(message = "El subtotal debe ser mayor a 0")
    // Total del detalle
    private double subtotal;

    // Constructor vacío
    public DetalleVenta() {
    }
}