package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity // Entidad de la BD
@Table(name = "categorias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

    @Id // Clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(nullable = false, unique = true, length = 100)
    // No null, único y máximo 100 caracteres
    private String nombre;

    @Column(length = 255)
    // Descripción opcional
    private String descripcion;

    @OneToMany(mappedBy = "categoria")
    // Una categoría tiene muchos productos
    @JsonIgnore // Evita bucle infinito en JSON
    private List<Producto> productos;
}