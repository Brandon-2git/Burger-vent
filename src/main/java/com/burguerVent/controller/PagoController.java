package com.burguerVent.controller;

import com.burguerVent.view.MenuView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class PagoController {
    @FXML
    private Button btnPagar;
    @FXML
    private Button btnRegresar;
    @FXML
    private Label lblTotal;
    @FXML
    private ImageView imgTarjeta;
    @FXML
    private ImageView imgEfectivo;
    @FXML
    private ImageView imgTransferencia;
    @FXML
    private RadioButton rbTarjeta;
    @FXML
    private RadioButton rbEfectivo;
    @FXML
    private RadioButton rbTransferencia;
    @FXML
    private ToggleGroup metodoPago;

    @FXML
    public void initialize() {
        // Inicialización si es necesaria
    }

    @FXML
    public void onPagarClick() {
        if (rbTarjeta.isSelected()) {
            abrirVentanaTarjeta();
        } else if (rbEfectivo.isSelected()) {
            abrirVentanaEfectivo();
        } else if (rbTransferencia.isSelected()) {
            abrirVentanaTransferencia();
        }
    }

    @FXML
    public void onRegresarClick() {
        try {
            // Crear y mostrar la ventana del menú
            Stage stage = new Stage();
            MenuView menuView = new MenuView();
            menuView.start(stage);
            
            // Cerrar la ventana actual de pago
            Stage currentStage = (Stage) btnRegresar.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al regresar al menú: " + e.getMessage());
        }
    }

    private void abrirVentanaTarjeta() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PagoTarjeta.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            
            // Cerrar la ventana actual
            Stage currentStage = (Stage) btnPagar.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al abrir ventana de tarjeta: " + e.getMessage());
        }
    }

    private void abrirVentanaEfectivo() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PagoEfectivo.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            
            // Cerrar la ventana actual
            Stage currentStage = (Stage) btnPagar.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al abrir ventana de efectivo: " + e.getMessage());
        }
    }

    private void abrirVentanaTransferencia() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PagoTransferencia.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            
            // Cerrar la ventana actual
            Stage currentStage = (Stage) btnPagar.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al abrir ventana de transferencia: " + e.getMessage());
        }
    }
} 