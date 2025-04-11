package com.burguerVent.negocio.servicio.impl;

import com.burguerVent.negocio.servicio.PagoService;
import org.springframework.stereotype.Service;

/**
 * Implementación del servicio de pago.
 * 
 * @author Equipo de Desarrollo
 * @version 1.0
 */
@Service
public class PagoServiceImpl implements PagoService {
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void procesarPagoTransferencia(double monto, String folio) throws Exception {
        // Validar el monto
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero");
        }
        
        // Validar el folio
        if (folio == null || folio.trim().isEmpty()) {
            throw new IllegalArgumentException("El folio no puede estar vacío");
        }
        
        // Aquí se implementaría la lógica real de procesamiento del pago
        // Por ejemplo, validación con el banco, registro en base de datos, etc.
        
        // Por ahora solo simulamos el procesamiento exitoso
        System.out.println("Pago procesado exitosamente:");
        System.out.println("Monto: $" + monto);
        System.out.println("Folio: " + folio);
    }
} 