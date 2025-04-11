package com.burguerVent.presentacion.pago;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

@Component
public class PagoVistaImpl implements PagoVista {
    
    @FXML
    private RadioButton rbTarjeta;
    
    @FXML
    private RadioButton rbEfectivo;
    
    @FXML
    private RadioButton rbTransferencia;
    
    @FXML
    private Button btnPagar;
    
    @FXML
    private Button btnRegresar;
    
    private Runnable onPagar;
    private Runnable onRegresar;
    private Stage stage;
    private boolean metodoPagoSeleccionado;
    
    @FXML
    public void initialize() {
        System.out.println("Inicializando PagoVistaImpl...");
        
        // Configurar los radio buttons
        rbTarjeta.setOnAction(e -> metodoPagoSeleccionado = true);
        rbEfectivo.setOnAction(e -> metodoPagoSeleccionado = true);
        rbTransferencia.setOnAction(e -> metodoPagoSeleccionado = true);
        
        btnPagar.setOnAction(e -> {
            System.out.println("Botón pagar presionado");
            if (!metodoPagoSeleccionado) {
                mostrarError("Por favor seleccione un método de pago");
                return;
            }
            
            if (onPagar != null) {
                onPagar.run();
            }
        });
        
        btnRegresar.setOnAction(e -> {
            System.out.println("Botón regresar presionado");
            if (onRegresar != null) {
                onRegresar.run();
            }
        });
    }
    
    @Override
    public void setOnPagar(Runnable action) {
        this.onPagar = action;
    }
    
    @Override
    public void setOnRegresar(Runnable action) {
        this.onRegresar = action;
    }
    
    @Override
    public String getMetodoPagoSeleccionado() {
        if (rbTarjeta.isSelected()) return "TARJETA";
        if (rbEfectivo.isSelected()) return "EFECTIVO";
        if (rbTransferencia.isSelected()) return "TRANSFERENCIA";
        return null;
    }
    
    @Override
    public void mostrarError(String mensaje) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    
    @Override
    public void mostrarMensaje(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    
    @Override
    public void mostrar() {
        System.out.println("Mostrando vista de pago...");
        if (stage != null) {
            stage.show();
            stage.toFront();
        }
    }
    
    @Override
    public void cerrar() {
        System.out.println("Cerrando vista de pago...");
        if (stage != null) {
            stage.close();
            stage = null;
        }
    }
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
} 