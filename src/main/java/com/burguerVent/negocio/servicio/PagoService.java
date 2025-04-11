package com.burguerVent.negocio.servicio;

/**
 * Servicio para manejar las operaciones de pago.
 * 
 * @author Equipo de Desarrollo
 * @version 1.0
 */
public interface PagoService {
    /**
     * Procesa un pago por transferencia bancaria.
     * 
     * @param monto Monto total a pagar
     * @param folio Folio de la transferencia
     * @throws Exception Si ocurre algún error durante el procesamiento del pago
     */
    void procesarPagoTransferencia(double monto, String folio) throws Exception;
} 