package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//BY JAMES

@Entity // Indica que esta clase es una entidad de base de datos
@Table(name = "categorias") // Define el nombre de la tabla en la BD
@Data // Genera automáticamente getters, setters, toString, equals, etc.
@NoArgsConstructor // Constructor vacío
@AllArgsConstructor // Constructor con todos los atributos
public class Categoria {

    @Id // Define la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // El ID se genera automáticamente (auto-incremental)
    private Long id;

    @NotNull // Valida que el campo no sea nulo
    @Column(name = "nombre") // Mapea la columna "nombre" en la tabla
    private String nombre;

    @Column(name = "descripcion") // Mapea la columna "descripcion"
    private String descripcion;
}