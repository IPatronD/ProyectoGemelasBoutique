package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;

@Entity // Indica que esta clase es una entidad de base de datos
@Table(name = "ventas") // Nombre de la tabla en la BD
@Data // Genera getters, setters, toString, equals, etc. automáticamente
public class Venta {

    @Id // Clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // ID autogenerado (auto-incremental)
    private Long id;

    @NotNull // No permite valores null
    @Column(name = "fecha") // Columna "fecha" en la BD
    private LocalDateTime fecha;
    // Fecha y hora de la venta

    @NotNull
    private Double total;
    // Total de la venta

    @ManyToOne
    // Relación muchos a uno: muchas ventas pueden pertenecer a un cliente
    @JoinColumn(name = "cliente_id")
    // Columna que conecta con la tabla clientes
    private Cliente cliente;

    @ManyToOne
    // Relación muchos a uno: muchas ventas pueden ser registradas por un usuario
    @JoinColumn(name = "usuario_id")
    // Columna que conecta con la tabla usuarios
    private Usuario usuario;

}