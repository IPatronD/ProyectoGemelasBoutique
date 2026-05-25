package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity // Indica que la clase será una tabla en la base de datos
@Table(name = "usuarios") // Nombre de la tabla
public class Usuario {

    @Id // Clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID autoincrementable
    private Long id;

    @NotBlank(message = "El nombre de usuario es obligatorio")
    @Column(nullable = false, unique = true, length = 50) // Campo obligatorio y único
    private String username; // Nombre de usuario para iniciar sesión

    @NotBlank(message = "La contraseña es obligatoria")
    @Column(nullable = false) // Campo obligatorio
    private String password; // Contraseña del usuario

    @NotBlank(message = "El rol es obligatorio")
    @Column(nullable = false, length = 20) // Campo obligatorio
    private String rol; // Rol del usuario (ADMIN, VENDEDOR, etc.)

    @Column(nullable = false) // Campo obligatorio
    private boolean estado = true; // Estado de la cuenta (activa/inactiva)

    @OneToOne
    @JoinColumn(name = "empleado_id", unique = true)
    @JsonManagedReference
    private Empleado empleado;

    // Constructor vacío requerido por JPA
    public Usuario() {
    }

    // Constructor con parámetros
    public Usuario(Long id, String username, String password,
            String rol, boolean estado, Empleado empleado) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.rol = rol;
        this.estado = estado;
        this.empleado = empleado;
    }

    // Devuelve el ID del usuario
    public Long getId() {
        return id;
    }

    // Asigna el ID del usuario
    public void setId(Long id) {
        this.id = id;
    }

    // Devuelve el nombre de usuario
    public String getUsername() {
        return username;
    }

    // Asigna el nombre de usuario
    public void setUsername(String username) {
        this.username = username;
    }

    // Devuelve la contraseña
    public String getPassword() {
        return password;
    }

    // Asigna la contraseña
    public void setPassword(String password) {
        this.password = password;
    }

    // Devuelve el rol
    public String getRol() {
        return rol;
    }

    // Asigna el rol
    public void setRol(String rol) {
        this.rol = rol;
    }

    // Devuelve el estado del usuario
    public boolean isEstado() {
        return estado;
    }

    // Asigna el estado del usuario
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    // Devuelve el empleado asociado
    public Empleado getEmpleado() {
        return empleado;
    }

    // Asigna el empleado asociado
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}