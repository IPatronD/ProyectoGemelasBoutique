package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity // Indica que esta clase es una entidad de base de datos
@Table(name = "usuarios") // Nombre de la tabla en la BD
public class Usuario {

    @Id // Clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // ID autogenerado (auto-incremental)
    private Long id;

    @NotBlank(message = "Los nombres son obligatorios")
    // No permite valores vacíos o null
    @Size(min = 3, max = 50)
    // Longitud entre 3 y 50 caracteres
    private String nombres; // Nombres del usuario

    @NotBlank(message = "Los apellidos son obligatorios")
    @Size(min = 3, max = 50)
    private String apellidos; // Apellidos del usuario

    @NotBlank(message = "El DNI es obligatorio")
    @Column(unique = true, length = 8)
    // Debe ser único y de 8 caracteres
    @Pattern(regexp = "\\d{8}", message = "El DNI debe tener 8 dígitos")
    // Solo permite exactamente 8 números
    private String dni;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "Correo inválido")
    // Valida formato de correo
    @Column(unique = true)
    // El correo debe ser único
    private String correo;

    @OneToOne
    // Relación uno a uno con Empleado
    @JoinColumn(name = "empleado_id")
    // Columna que conecta con la tabla empleados
    private Empleado empleado;
    public Usuario() {
    }

    public Usuario(Long id, String nombres, String apellidos, String dni, String correo, Empleado empleado) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.correo = correo;
        this.empleado = empleado;
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

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}