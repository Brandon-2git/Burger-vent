package com.burguerVent.negocio;

import com.burguerVent.datos.PagoRepository;
import com.burguerVent.modelo.Pago;
import com.burguerVent.modelo.dto.PagoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * Servicio que maneja la lógica de negocio relacionada con los pagos.
 * Implementa las reglas de negocio y coordina las operaciones entre la capa de presentación y datos.
 * 
 * @author Equipo de Desarrollo
 * @version 1.0
 */
@Service
public class PagoService {
    
    @Autowired
    private PagoRepository pagoRepository;
    
    /**
     * Procesa un pago según el método seleccionado.
     * Realiza validaciones, procesa el pago según el método y persiste la información.
     * 
     * @param pagoDTO DTO con la información del pago a procesar
     * @return PagoDTO con el resultado del procesamiento
     * @throws IllegalArgumentException si los datos del pago no son válidos
     */
    @Transactional
    public PagoDTO procesarPago(PagoDTO pagoDTO) {
        // Validar el pago
        validarPago(pagoDTO);
        
        // Crear entidad Pago
        Pago pago = new Pago();
        pago.setMonto(pagoDTO.getMonto());
        pago.setMetodoPago(pagoDTO.getMetodoPago());
        pago.setEstado("PENDIENTE");
        
        // Procesar según el método de pago
        switch (pagoDTO.getMetodoPago().toUpperCase()) {
            case "TARJETA":
                procesarPagoTarjeta(pago, pagoDTO);
                break;
            case "EFECTIVO":
                procesarPagoEfectivo(pago, pagoDTO);
                break;
            case "TRANSFERENCIA":
                procesarPagoTransferencia(pago, pagoDTO);
                break;
            default:
                throw new IllegalArgumentException("Método de pago no válido");
        }
        
        // Guardar el pago
        pago = pagoRepository.save(pago);
        
        // Convertir a DTO y retornar
        return convertirADTO(pago);
    }
    
    /**
     * Valida los datos básicos del pago.
     * 
     * @param pagoDTO DTO con la información del pago a validar
     * @throws IllegalArgumentException si el monto es inválido o no se especificó método de pago
     */
    private void validarPago(PagoDTO pagoDTO) {
        if (pagoDTO.getMonto() == null || pagoDTO.getMonto() <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero");
        }
        
        if (pagoDTO.getMetodoPago() == null || pagoDTO.getMetodoPago().trim().isEmpty()) {
            throw new IllegalArgumentException("Debe seleccionar un método de pago");
        }
    }
    
    /**
     * Procesa un pago realizado con tarjeta.
     * 
     * @param pago Entidad Pago a actualizar
     * @param pagoDTO DTO con la información del pago
     * @throws IllegalArgumentException si el número de tarjeta es inválido
     */
    private void procesarPagoTarjeta(Pago pago, PagoDTO pagoDTO) {
        if (pagoDTO.getNumeroTarjeta() == null || !pagoDTO.getNumeroTarjeta().matches("\\d{8}")) {
            throw new IllegalArgumentException("Número de tarjeta inválido");
        }
        pago.setNumeroTarjeta(pagoDTO.getNumeroTarjeta());
        pago.setEstado("COMPLETADO");
    }
    
    /**
     * Procesa un pago realizado en efectivo.
     * 
     * @param pago Entidad Pago a actualizar
     * @param pagoDTO DTO con la información del pago
     * @throws IllegalArgumentException si el efectivo recibido es insuficiente
     */
    private void procesarPagoEfectivo(Pago pago, PagoDTO pagoDTO) {
        if (pagoDTO.getEfectivoRecibido() == null || pagoDTO.getEfectivoRecibido() < pagoDTO.getMonto()) {
            throw new IllegalArgumentException("El efectivo recibido debe ser mayor o igual al monto");
        }
        pago.setEfectivoRecibido(pagoDTO.getEfectivoRecibido());
        pago.setCambio(pagoDTO.getEfectivoRecibido() - pagoDTO.getMonto());
        pago.setEstado("COMPLETADO");
    }
    
    /**
     * Procesa un pago realizado por transferencia.
     * 
     * @param pago Entidad Pago a actualizar
     * @param pagoDTO DTO con la información del pago
     * @throws IllegalArgumentException si no se proporciona el folio de transferencia
     */
    private void procesarPagoTransferencia(Pago pago, PagoDTO pagoDTO) {
        if (pagoDTO.getFolioTransferencia() == null || pagoDTO.getFolioTransferencia().trim().isEmpty()) {
            throw new IllegalArgumentException("El folio de transferencia es requerido");
        }
        pago.setFolioTransferencia(pagoDTO.getFolioTransferencia());
        pago.setEstado("PENDIENTE"); // La transferencia requiere confirmación
    }
    
    /**
     * Convierte una entidad Pago a su correspondiente DTO.
     * 
     * @param pago Entidad Pago a convertir
     * @return PagoDTO con los datos de la entidad
     */
    private PagoDTO convertirADTO(Pago pago) {
        PagoDTO dto = new PagoDTO();
        dto.setId(pago.getId());
        dto.setMonto(pago.getMonto());
        dto.setMetodoPago(pago.getMetodoPago());
        dto.setNumeroTarjeta(pago.getNumeroTarjeta());
        dto.setFolioTransferencia(pago.getFolioTransferencia());
        dto.setEfectivoRecibido(pago.getEfectivoRecibido());
        dto.setCambio(pago.getCambio());
        dto.setFechaPago(pago.getFechaPago());
        dto.setEstado(pago.getEstado());
        return dto;
    }
} 