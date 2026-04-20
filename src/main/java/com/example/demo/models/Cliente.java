package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size (min =3, max =50)
    private String tipo;

    @NotBlank
    @Size(min =3, max =100)
    private  String nombres;

    @NotBlank
    @Column(unique = true, length = 15)
    private String documento;

    @NotBlank
    @Pattern(regexp = "\\d{9}")
    private String telefono;

    public Cliente() {
    }

    public Cliente(long id, String tipo, String nombres, String documento, String telefono) {
        this.id = id;
        this.tipo = tipo;
        this.nombres= nombres;
        this.documento = documento;
        this.telefono = telefono;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
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


