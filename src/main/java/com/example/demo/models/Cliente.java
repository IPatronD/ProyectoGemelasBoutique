package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity // Indica que esta clase es una entidad de base de datos
@Table(name = "clientes") // Nombre de la tabla en la BD
public class Cliente {

    @Id // Clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // ID autogenerado (auto-incremental)
    private Long id;

    @NotBlank // No permite valores vacíos o null
    @Size(min = 3, max = 50) // Longitud entre 3 y 50 caracteres
    private String tipo; // Tipo de cliente (ej: natural, empresa)

    @NotBlank
    @Size(min = 3, max = 100) // Longitud entre 3 y 100 caracteres
    private String nombres; // Nombre del cliente

    @NotBlank
    @Column(unique = true, length = 15)
    // Debe ser único y con máximo 15 caracteres
    private String documento; // DNI o RUC

    @NotBlank
    @Pattern(regexp = "\\d{9}")
    // Solo permite exactamente 9 dígitos
    private String telefono; // Número de teléfono

    public Cliente() {
    }

    public Cliente(Long id, String tipo, String nombres, String documento, String telefono) {
        this.id = id;
        this.tipo = tipo;
        this.nombres= nombres;
        this.documento = documento;
        this.telefono = telefono;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombres() {
    return nombres;
    }

    public void setNombres(String nombres) {
    this.nombres = nombres;
    }

    public String getDocumento() {
    return documento;
    }

    public void setDocumento(String documento) {
    this.documento = documento;
    }

    public String getTelefono() {
    return telefono;
    }

    public void setTelefono(String telefono) {
    this.telefono = telefono;
    }
}


