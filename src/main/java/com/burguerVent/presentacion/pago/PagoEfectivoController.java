package com.burguerVent.presentacion.pago;

import com.burguerVent.modelo.dto.PagoDTO;
import com.burguerVent.negocio.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Controlador para la gestión de pagos en efectivo.
 * Coordina la interacción entre la vista y el servicio de pagos,
 * manejando la lógica de negocio relacionada con los pagos en efectivo.
 * 
 * @author Equipo de Desarrollo
 * @version 1.0
 */
@Component
public class PagoEfectivoController {
    /** Vista de pago en efectivo */
    private final PagoEfectivoVista vista;
    /** Servicio de pagos */
    private final PagoService pagoService;
    /** Monto total a pagar */
    private double total;
    
    /**
     * Constructor del controlador de pagos en efectivo.
     * 
     * @param vista Vista de pago en efectivo
     * @param pagoService Servicio de pagos
     */
    @Autowired
    public PagoEfectivoController(PagoEfectivoVista vista, PagoService pagoService) {
        this.vista = vista;
        this.pagoService = pagoService;
        configurarVista();
    }
    
    /**
     * Configura los manejadores de eventos de la vista.
     */
    private void configurarVista() {
        vista.setOnPagar(this::procesarPago);
        vista.setOnRegresar(this::manejarRegreso);
    }
    
    /**
     * Procesa un pago en efectivo.
     * Valida el monto recibido y realiza el pago a través del servicio.
     * 
     * @param efectivoRecibido Monto en efectivo recibido del cliente
     */
    private void procesarPago(double efectivoRecibido) {
        try {
            if (efectivoRecibido < total) {
                vista.mostrarError("El efectivo recibido es menor al monto a pagar");
                return;
            }
            
            PagoDTO pagoDTO = new PagoDTO();
            pagoDTO.setMonto(total);
            pagoDTO.setMetodoPago("EFECTIVO");
            pagoDTO.setEfectivoRecibido(efectivoRecibido);
            
            PagoDTO resultado = pagoService.procesarPago(pagoDTO);
            
            vista.mostrarMensaje("Pago Exitoso", 
                String.format("Cambio a devolver: $%.2f", resultado.getCambio()));
            vista.cerrar();
        } catch (Exception e) {
            vista.mostrarError("Error al procesar el pago: " + e.getMessage());
        }
    }
    
    /**
     * Maneja el evento de regreso al menú anterior.
     */
    private void manejarRegreso() {
        vista.cerrar();
    }
    
    /**
     * Establece el monto total a pagar.
     * 
     * @param total Monto total del pago
     */
    public void setTotal(double total) {
        this.total = total;
        vista.setTotal(total);
    }
    
    /**
     * Muestra la vista de pago en efectivo.
     * Limpia los campos y muestra la ventana.
     */
    public void mostrarVista() {
        vista.limpiarCampos();
        vista.mostrar();
    }
} 