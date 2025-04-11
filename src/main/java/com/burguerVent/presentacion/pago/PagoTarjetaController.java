package com.burguerVent.presentacion.pago;

import com.burguerVent.negocio.servicio.PagoService;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Controlador para el pago con tarjeta.
 * Coordina la interacción entre la vista de pago con tarjeta y el servicio de pago.
 */
@Component
public class PagoTarjetaController {
    private final PagoTarjetaVista vista;
    private final PagoService pagoService;
    private double total;
    private Stage stage;

    @Autowired
    public PagoTarjetaController(PagoTarjetaVista vista, PagoService pagoService) {
        this.vista = vista;
        this.pagoService = pagoService;
        configurarVista();
    }

    private void configurarVista() {
        vista.setOnPagar(() -> procesarPago());
        vista.setOnRegresar(() -> manejarRegreso());
    }

    private void procesarPago() {
        try {
            String numeroTarjeta = vista.getNumeroTarjeta();
            System.out.println("Procesando pago con tarjeta: " + numeroTarjeta);
            System.out.println("Monto a pagar: $" + total);
            
            pagoService.procesarPagoTransferencia(total, numeroTarjeta);
            vista.mostrarMensaje("Éxito", "Pago procesado correctamente");
            vista.cerrar();
            System.out.println("Ventana de pago cerrada");
        } catch (Exception e) {
            vista.mostrarError("Error al procesar el pago: " + e.getMessage());
        }
    }

    private void manejarRegreso() {
        vista.cerrar();
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public void setStage(Stage stage) {
        this.stage = stage;
        if (vista instanceof PagoTarjetaVistaImpl) {
            ((PagoTarjetaVistaImpl) vista).setStage(stage);
        }
    }

    public void mostrarVista() {
        System.out.println("Mostrando vista de pago con tarjeta...");
        vista.mostrar();
    }
} 