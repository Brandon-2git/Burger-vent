package com.burguerVent.presentacion.pago;

import com.burguerVent.negocio.servicio.PagoService;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Controlador para el pago por transferencia.
 * Coordina la interacción entre la vista y el servicio de pago.
 * 
 * @author Equipo de Desarrollo
 * @version 1.0
 */
@Component
public class PagoTransferenciaController {
    /** Vista de pago por transferencia */
    private final PagoTransferenciaVista vista;
    /** Servicio de pago */
    private final PagoService pagoService;
    /** Total a pagar */
    private double total;
    /** Indica si se ha seleccionado el método de pago */
    private boolean metodoPagoSeleccionado;
    
    /**
     * Constructor que inyecta las dependencias necesarias.
     * 
     * @param vista Vista de pago por transferencia
     * @param pagoService Servicio de pago
     */
    @Autowired
    public PagoTransferenciaController(PagoTransferenciaVista vista, PagoService pagoService) {
        this.vista = vista;
        this.pagoService = pagoService;
        this.metodoPagoSeleccionado = false;
        configurarVista();
    }
    
    /**
     * Configura los manejadores de eventos de la vista.
     */
    private void configurarVista() {
        vista.setOnPagar(this::procesarPago);
        vista.setOnRegresar(this::manejarRegreso);
        vista.setOnMetodoPagoSeleccionado(this::manejarSeleccionMetodoPago);
    }
    
    /**
     * Maneja el evento de selección de método de pago
     */
    private void manejarSeleccionMetodoPago() {
        this.metodoPagoSeleccionado = true;
    }
    
    /**
     * Procesa el pago por transferencia.
     * 
     * @param folio Folio de la transferencia
     */
    private void procesarPago(String folio) {
        if (!metodoPagoSeleccionado) {
            vista.mostrarError("Por favor seleccione un método de pago");
            return;
        }
        
        try {
            pagoService.procesarPagoTransferencia(total, folio);
            vista.mostrarMensaje("Éxito", "Pago procesado correctamente");
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
     * Establece el total a pagar.
     * 
     * @param total Total a pagar
     */
    public void setTotal(double total) {
        this.total = total;
    }
    
    /**
     * Establece si se ha seleccionado el método de pago.
     * 
     * @param seleccionado true si se ha seleccionado un método de pago, false en caso contrario
     */
    public void setMetodoPagoSeleccionado(boolean seleccionado) {
        this.metodoPagoSeleccionado = seleccionado;
    }
    
    /**
     * Muestra la vista de pago por transferencia.
     * 
     * @param stage Ventana principal
     */
    public void mostrarVista(Stage stage) {
        if (vista instanceof PagoTransferenciaVistaImpl) {
            ((PagoTransferenciaVistaImpl) vista).setStage(stage);
        }
        vista.mostrar();
    }
} 