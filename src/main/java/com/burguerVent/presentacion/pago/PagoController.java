package com.burguerVent.presentacion.pago;

import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Controlador principal para el proceso de pago.
 * Coordina la interacción entre las diferentes vistas de pago y sus controladores.
 */
@Component
public class PagoController {
    private final PagoVista vista;
    private final PagoTarjetaController pagoTarjetaController;
    private final PagoTransferenciaController pagoTransferenciaController;
    private double total;
    private Stage stage;

    @Autowired
    public PagoController(
            PagoVista vista, 
            PagoTarjetaController pagoTarjetaController,
            PagoTransferenciaController pagoTransferenciaController) {
        this.vista = vista;
        this.pagoTarjetaController = pagoTarjetaController;
        this.pagoTransferenciaController = pagoTransferenciaController;
        configurarVista();
    }

    private void configurarVista() {
        vista.setOnPagar(() -> procesarPago());
        vista.setOnRegresar(() -> manejarRegreso());
    }

    private void procesarPago() {
        String metodoPago = vista.getMetodoPagoSeleccionado();
        if (metodoPago == null) {
            vista.mostrarError("Por favor seleccione un método de pago");
            return;
        }

        switch (metodoPago) {
            case "TARJETA":
                pagoTarjetaController.setTotal(total);
                pagoTarjetaController.setStage(stage);
                vista.cerrar();
                pagoTarjetaController.mostrarVista();
                break;
            case "TRANSFERENCIA":
                pagoTransferenciaController.setTotal(total);
                vista.cerrar();
                pagoTransferenciaController.mostrarVista(stage);
                break;
            case "EFECTIVO":
                vista.mostrarError("Pago en efectivo aún no implementado");
                break;
            default:
                vista.mostrarError("Método de pago no válido");
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
    }

    public void mostrarVista() {
        vista.mostrar();
    }
} 