package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity // Entidad de la BD
@Table(name = "ventas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venta {

    @Id // Clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La fecha es obligatoria")
    @Column(nullable = false)
    // Fecha de la venta
    private LocalDateTime fecha;

    @Positive(message = "El total debe ser mayor a 0")
    @Column(nullable = false)
    // Total de la venta
    private Double total;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    // Muchas ventas pertenecen a un cliente
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    // Muchas ventas son registradas por un usuario
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "metodo_pago_id", nullable = false)
    // Método de pago usado
    private MetodoPago metodoPago;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    // Una venta tiene muchos detalles
    @JsonIgnore // Evita bucle infinito
    private List<DetalleVenta> detallesVenta;
}