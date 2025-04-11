package com.burguerVent.presentacion.pago;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import java.util.function.Consumer;
import org.springframework.stereotype.Component;

/**
 * Implementación de la vista de pago en efectivo utilizando JavaFX.
 * Maneja la interfaz de usuario y la interacción con el usuario para
 * procesar pagos en efectivo.
 * 
 * @author Equipo de Desarrollo
 * @version 1.0
 */
@Component
public class PagoEfectivoVistaImpl implements PagoEfectivoVista {
    /** Etiqueta que muestra el monto total a pagar */
    @FXML
    private Label lblMontoPagar;
    
    /** Campo de texto para ingresar el efectivo recibido */
    @FXML
    private TextField txtEfectivo;
    
    /** Botón para realizar el pago */
    @FXML
    private Button btnPagar;
    
    /** Botón para regresar al menú anterior */
    @FXML
    private Button btnRegresar;

    /** Callback para manejar el evento de pago */
    private Consumer<Double> onPagar;
    /** Callback para manejar el evento de regreso */
    private Runnable onRegresar;
    /** Ventana principal de la vista */
    private Stage stage;
    /** Monto total a pagar */
    private double total;

    /**
     * Inicializa los componentes de la interfaz de usuario.
     * Configura los manejadores de eventos y la validación de entrada.
     */
    @FXML
    public void initialize() {
        System.out.println("Inicializando PagoEfectivoVistaImpl...");
        
        // Verificar que los componentes FXML se hayan cargado correctamente
        if (lblMontoPagar == null) System.out.println("lblMontoPagar es null");
        if (txtEfectivo == null) System.out.println("txtEfectivo es null");
        if (btnPagar == null) System.out.println("btnPagar es null");
        if (btnRegresar == null) System.out.println("btnRegresar es null");
        
        // Configurar el botón de pagar inicialmente como deshabilitado
        if (btnPagar != null) {
            btnPagar.setDisable(true);
            btnPagar.setOnAction(e -> {
                try {
                    double efectivoRecibido = Double.parseDouble(txtEfectivo.getText());
                    if (onPagar != null) {
                        onPagar.accept(efectivoRecibido);
                    }
                } catch (NumberFormatException ex) {
                    mostrarError("Por favor ingrese un monto válido");
                }
            });
        }
        
        if (txtEfectivo != null) {
            txtEfectivo.textProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue.matches("\\d*(\\.\\d*)?")) {
                    txtEfectivo.setText(oldValue);
                } else {
                    validarPago();
                }
            });
        }
        
        btnRegresar.setOnAction(e -> {
            if (onRegresar != null) {
                onRegresar.run();
            }
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTotal(double total) {
        this.total = total;
        if (lblMontoPagar != null) {
            lblMontoPagar.setText(String.format("$%.2f", total));
            System.out.println("Monto a pagar establecido: " + total);
        } else {
            System.err.println("Error: lblMontoPagar es null al intentar establecer el total");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setOnPagar(Consumer<Double> action) {
        System.out.println("Configurando manejador de pago");
        this.onPagar = action;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setOnRegresar(Runnable action) {
        this.onRegresar = action;
        if (btnRegresar != null) {
            btnRegresar.setOnAction(e -> {
                if (onRegresar != null) {
                    onRegresar.run();
                }
            });
        } else {
            System.err.println("Error: btnRegresar es null en setOnRegresar");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void limpiarCampos() {
        if (txtEfectivo != null) {
            txtEfectivo.clear();
        }
    }

    /**
     * Valida que el monto ingresado sea suficiente para cubrir el pago.
     * Habilita o deshabilita el botón de pago según corresponda.
     */
    private void validarPago() {
        try {
            if (txtEfectivo != null && btnPagar != null) {
                double efectivoRecibido = Double.parseDouble(txtEfectivo.getText());
                System.out.println("Validando pago - Efectivo recibido: " + efectivoRecibido + ", Total pedido: " + total);
                btnPagar.setDisable(efectivoRecibido < total);
            }
        } catch (NumberFormatException e) {
            System.err.println("Error al validar pago: " + e.getMessage());
            if (btnPagar != null) {
                btnPagar.setDisable(true);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mostrarError(String mensaje) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mostrarMensaje(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    /**
     * Establece la ventana principal de la vista.
     * 
     * @param stage Ventana principal
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mostrar() {
        if (stage != null) {
            stage.show();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void cerrar() {
        if (stage != null) {
            stage.close();
        }
    }
} 