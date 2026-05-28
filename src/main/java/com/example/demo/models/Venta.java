package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

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

    private Double subtotal; // Subtotal de la venta (Base Imponible para compatibilidad)
    private Double descuento = 0.0; // Descuento global aplicado
    private Double iva; // IVA / IGV de la venta

    private Double subtotalBruto = 0.0; // Suma de subtotales de productos (precio * cantidad)
    private Double totalDescItems = 0.0; // Suma de descuentos de todos los ítems
    private Double subtotalNeto = 0.0; // subtotalBruto - totalDescItems
    private Double descuentoGlobalPorcentaje = 0.0; // Porcentaje de descuento global (ej. 5.0%)
    private Double baseImponible = 0.0; // subtotalNeto - descuentoGlobalMonto
    private Double tasaIva = 16.0; // Porcentaje de IVA aplicado (ej. 16.0%)

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

    @ManyToOne
    @JoinColumn(name = "metodo_pago_id")
    private MetodoPago metodoPago;

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleVenta> detalles;
}
