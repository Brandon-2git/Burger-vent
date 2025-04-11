package com.burguerVent.presentacion.pago;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;
import java.util.function.Consumer;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Implementación de la vista de pago por transferencia utilizando JavaFX.
 * Maneja la interfaz de usuario y la interacción con el usuario para
 * procesar pagos por transferencia.
 * 
 * @author Equipo de Desarrollo
 * @version 1.0
 */
@Component
public class PagoTransferenciaVistaImpl implements PagoTransferenciaVista {
    /** Campo de texto para ingresar el folio de transferencia */
    @FXML
    private TextField txtFolio;
    
    /** Botón para realizar el pago */
    @FXML
    private Button btnPagar;
    
    /** Botón para regresar al menú anterior */
    @FXML
    private Button btnRegresar;
    
    /** Callback para manejar el evento de pago */
    private Consumer<String> onPagar;
    /** Callback para manejar el evento de regreso */
    private Runnable onRegresar;
    /** Callback para manejar el evento de selección de método de pago */
    private Runnable onMetodoPagoSeleccionado;
    /** Ventana principal de la vista */
    private Stage stage;
    
    /**
     * Inicializa los componentes de la interfaz de usuario.
     * Configura los manejadores de eventos y la validación de entrada.
     */
    @FXML
    public void initialize() {
        btnPagar.setOnAction(e -> {
            if (onPagar != null) {
                onPagar.accept(txtFolio.getText());
            }
        });
        
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
    public void setOnPagar(Consumer<String> action) {
        this.onPagar = action;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void setOnRegresar(Runnable action) {
        this.onRegresar = action;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void setOnMetodoPagoSeleccionado(Runnable handler) {
        this.onMetodoPagoSeleccionado = handler;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void mostrar() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PagoTransferencia.fxml"));
            loader.setController(this);
            Parent root = loader.load();
            
            stage = new Stage();
            stage.setTitle("Pago por Transferencia");
            stage.setScene(new Scene(root));
            stage.show();
            
            if (onMetodoPagoSeleccionado != null) {
                onMetodoPagoSeleccionado.run();
            }
        } catch (Exception e) {
            System.err.println("Error al mostrar la vista de pago por transferencia: " + e.getMessage());
            e.printStackTrace();
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
    
    /**
     * Establece la ventana principal de la vista.
     * 
     * @param stage Ventana principal
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    /**
     * Muestra un mensaje de error al usuario.
     * 
     * @param mensaje Mensaje de error a mostrar
     */
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
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
} 