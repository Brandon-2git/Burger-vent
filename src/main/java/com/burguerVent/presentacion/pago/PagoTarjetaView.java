package com.burguerVent.presentacion.pago;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class PagoTarjetaView {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @Autowired
    private ApplicationContext applicationContext;

    public void mostrar() {
        try {
            System.out.println("Cargando vista de pago con tarjeta...");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PagoTarjeta.fxml"));
            loader.setControllerFactory(applicationContext::getBean);
            root = loader.load();
            
            if (stage == null) {
                stage = new Stage();
                stage.setTitle("Pago con Tarjeta");
                stage.setResizable(false);
            }
            
            if (scene == null) {
                scene = new Scene(root, 600, 400);
            } else {
                scene.setRoot(root);
            }
            
            stage.setScene(scene);
            stage.show();
            stage.toFront();
            System.out.println("Vista de pago con tarjeta mostrada correctamente");
        } catch (IOException e) {
            System.err.println("Error al cargar la vista de pago con tarjeta: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al cargar la vista de pago con tarjeta", e);
        }
    }

    public void cerrar() {
        if (stage != null) {
            stage.close();
        }
    }
} 