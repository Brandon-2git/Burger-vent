package com.burguerVent.controller;

import com.burguerVent.view.MetodoPagoView.Pago;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class PagoTarjetaController {
    @FXML
    private Button btnPagar;
    @FXML
    private Button btnRegresar;
    @FXML
    private TextField txtNumeroTarjeta;
    @FXML
    private TextField txtContrasena;
    @FXML
    private Label lblNumeroTarjeta;
    @FXML
    private Label lblContrasena;
    @FXML
    private ImageView imgTarjeta;
    @FXML
    private ImageView imgLogo3;
    @FXML
    private ImageView imgLogoHA;

    @FXML
    public void initialize() {
        // Aquí podemos inicializar cualquier configuración necesaria
    }

    @FXML
    public void onRegresarClick() {
        try {
            // Crear y mostrar la ventana de Pago
            Pago pago = new Pago();
            Stage stagePago = new Stage();
            pago.start(stagePago);

            // Cerrar la ventana actual de PagoTarjeta
            Stage currentStage = (Stage) btnRegresar.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} 