package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity // Indica que esta clase es una entidad de base de datos
@Table(name = "empleados") // Nombre de la tabla en la BD
public class Empleado {

    @Id // Clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // ID autogenerado (auto-incremental)
    private Long id;

    @NotBlank // No permite valores vacíos o null
    @Size(min = 3, max = 50) // Longitud entre 3 y 50 caracteres
    private String nombres; // Nombres del empleado

    @NotBlank
    @Size(min = 3, max = 50)
    private String apellidos; // Apellidos del empleado

    @NotBlank
    @Column(unique = true, length = 8)
    // Debe ser único y de máximo 8 caracteres
    @Pattern(regexp = "\\d{8}")
    // Solo permite exactamente 8 dígitos (DNI)
    private String dni;

    @NotBlank
    @Email // Valida que tenga formato de correo electrónico
    @Column(unique = true)
    // El correo debe ser único
    private String correo;

    @OneToOne(mappedBy = "empleado")
    // Relación uno a uno con Usuario
    private Usuario usuario;

    public Empleado() {
    }

    public Empleado(Long id, String nombres, String apellidos, String dni, String correo) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.correo = correo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}