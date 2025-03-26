package com.burguerVent.controller;

import com.burguerVent.view.MetodoPagoView.Pago;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class PagoEfectivoController {
    @FXML
    private Button btnPagar;
    @FXML
    private Button btnRegresar;
    @FXML
    private TextField txtMontoPagar;
    @FXML
    private TextField txtEfectivoRecibido;
    @FXML
    private TextField txtCambio;
    @FXML
    private ImageView imgEfectivo;
    @FXML
    private ImageView imgLogo3;
    @FXML
    private ImageView imgLogoHA;

    @FXML
    public void initialize() {
        // Configurar el evento para calcular el cambio cuando se ingrese el efectivo
        txtEfectivoRecibido.setOnKeyReleased(e -> calcularCambio());
    }

    private void calcularCambio() {
        try {
            double montoPagar = Double.parseDouble(txtMontoPagar.getText());
            double efectivoRecibido = Double.parseDouble(txtEfectivoRecibido.getText());
            double cambio = efectivoRecibido - montoPagar;
            txtCambio.setText(String.format("%.2f", cambio));
        } catch (NumberFormatException e) {
            txtCambio.setText("0.00");
        }
    }

    @FXML
    public void onRegresarClick() {
        try {
            // Crear y mostrar la ventana de Pago
            Pago pago = new Pago();
            Stage stagePago = new Stage();
            pago.start(stagePago);

            // Cerrar la ventana actual
            Stage currentStage = (Stage) btnRegresar.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} 