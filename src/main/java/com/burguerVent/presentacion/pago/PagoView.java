package com.burguerVent.presentacion.pago;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class PagoView {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private double total;

    @Autowired
    private ApplicationContext applicationContext;
    
    @Autowired
    @Lazy
    private PagoController pagoController;

    public void setTotal(double total) {
        this.total = total;
        if (pagoController != null) {
            pagoController.setTotal(total);
        }
    }

    public void mostrar() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Pago.fxml"));
            loader.setControllerFactory(applicationContext::getBean);
            root = loader.load();
            
            if (stage == null) {
                stage = new Stage();
                stage.setTitle("Pago");
                stage.setResizable(false);
            }
            
            if (scene == null) {
                scene = new Scene(root, 600, 400);
            } else {
                scene.setRoot(root);
            }
            
            // Asegurarse de que el controlador tenga el total actualizado
            pagoController.setTotal(total);
            
            stage.setScene(scene);
            stage.show();
            stage.toFront();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al cargar la vista de pago", e);
        }
    }

    public void cerrar() {
        if (stage != null) {
            stage.close();
        }
    }
} 