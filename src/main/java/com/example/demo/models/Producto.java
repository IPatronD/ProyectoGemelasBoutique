package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//BY JAMES

@Entity // Indica que esta clase es una entidad de base de datos
@Table(name = "productos") // Nombre de la tabla en la BD
@Data // Genera getters, setters, toString, equals, etc.
@NoArgsConstructor // Constructor vacío
@AllArgsConstructor // Constructor con todos los atributos
public class Producto {

    @Id // Clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // ID autogenerado (auto-incremental)
    private Long id;

    @NotNull // No permite valores null
    @Column(name = "nombre") // Columna "nombre" en la BD
    private String nombre; // Nombre del producto

    @Column(name = "descripcion") // Columna "descripcion"
    private String descripcion; // Descripción del producto

    @NotNull
    @Column(name = "precio") // Columna "precio"
    private double precio; // Precio del producto

    @NotNull
    @Column(name = "stock") // Columna "stock"
    private int stock; // Cantidad disponible en inventario

    @ManyToOne
    // Relación muchos a uno: muchos productos pertenecen a una categoría
    @JoinColumn(name = "categoria_id")
    // Columna que conecta con la tabla categorias
    private Categoria categoria; // Categoría del producto
}