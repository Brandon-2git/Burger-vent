package com.burguerVent.view.MetodoPagoView;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Pago {
    public void start(Stage stage) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Pago.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Selección de Método de Pago");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al cargar ventana de pago: " + e.getMessage());
            throw e;
        }
    }
} 