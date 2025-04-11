package com.burguerVent.modelo;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * Entidad que representa un pago en el sistema.
 * Almacena información sobre el método de pago, monto, y detalles específicos según el método.
 * 
 * @author Equipo de Desarrollo
 * @version 1.0
 */
@Data
@Entity
@Table(name = "pagos")
public class Pago {
    /**
     * Identificador único del pago
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * Monto total del pago
     */
    @Column(nullable = false)
    private Double monto;
    
    /**
     * Método de pago utilizado (TARJETA, EFECTIVO, TRANSFERENCIA)
     */
    @Column(nullable = false)
    private String metodoPago;
    
    /**
     * Número de tarjeta (solo para pagos con tarjeta)
     */
    @Column
    private String numeroTarjeta;
    
    /**
     * Folio de transferencia (solo para pagos por transferencia)
     */
    @Column
    private String folioTransferencia;
    
    /**
     * Monto recibido en efectivo (solo para pagos en efectivo)
     */
    @Column
    private Double efectivoRecibido;
    
    /**
     * Cambio devuelto (solo para pagos en efectivo)
     */
    @Column
    private Double cambio;
    
    /**
     * Fecha y hora en que se realizó el pago
     */
    @Column(nullable = false)
    private LocalDateTime fechaPago;
    
    /**
     * Estado actual del pago (PENDIENTE, COMPLETADO, CANCELADO)
     */
    @Column(nullable = false)
    private String estado;
    
    /**
     * Método que se ejecuta automáticamente antes de persistir la entidad
     * Establece la fecha y hora actual como fecha de pago
     */
    @PrePersist
    protected void onCreate() {
        fechaPago = LocalDateTime.now();
    }
} 