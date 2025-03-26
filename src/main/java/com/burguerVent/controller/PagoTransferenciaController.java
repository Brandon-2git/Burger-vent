package com.burguerVent.controller;

import com.burguerVent.view.MetodoPagoView.Pago;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PagoTransferenciaController {
    @FXML
    private Button btnPagar;
    
    @FXML
    private Button btnRegresar;
    
    @FXML
    private TextField txtFolio;
    
    @FXML
    public void initialize() {
        // Inicialización si es necesaria
    }
    
    @FXML
    public void onRegresarClick() {
        try {
            // Crear y mostrar la ventana de selección de pago
            Stage stage = new Stage();
            Pago pago = new Pago();
            pago.start(stage);
            
            // Cerrar la ventana actual
            Stage currentStage = (Stage) btnRegresar.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al regresar a ventana de pago: " + e.getMessage());
        }
    }
} 