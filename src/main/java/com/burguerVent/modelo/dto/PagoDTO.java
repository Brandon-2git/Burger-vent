package com.burguerVent.modelo.dto;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * Objeto de Transferencia de Datos (DTO) para la entidad Pago.
 * Se utiliza para transferir datos entre las capas de presentación y negocio.
 * Contiene los mismos campos que la entidad Pago pero sin anotaciones JPA.
 * 
 * @author Equipo de Desarrollo
 * @version 1.0
 */
@Data
public class PagoDTO {
    /**
     * Identificador único del pago
     */
    private Long id;
    
    /**
     * Monto total del pago
     */
    private Double monto;
    
    /**
     * Método de pago utilizado (TARJETA, EFECTIVO, TRANSFERENCIA)
     */
    private String metodoPago;
    
    /**
     * Número de tarjeta (solo para pagos con tarjeta)
     */
    private String numeroTarjeta;
    
    /**
     * Folio de transferencia (solo para pagos por transferencia)
     */
    private String folioTransferencia;
    
    /**
     * Monto recibido en efectivo (solo para pagos en efectivo)
     */
    private Double efectivoRecibido;
    
    /**
     * Cambio devuelto (solo para pagos en efectivo)
     */
    private Double cambio;
    
    /**
     * Fecha y hora en que se realizó el pago
     */
    private LocalDateTime fechaPago;
    
    /**
     * Estado actual del pago (PENDIENTE, COMPLETADO, CANCELADO)
     */
    private String estado;
} 