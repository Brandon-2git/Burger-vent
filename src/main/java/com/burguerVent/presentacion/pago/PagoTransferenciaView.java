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
public class PagoTransferenciaView {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @Autowired
    private ApplicationContext applicationContext;

    public void mostrar() {
        try {
            System.out.println("Cargando vista de pago con transferencia...");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PagoTransferencia.fxml"));
            loader.setControllerFactory(applicationContext::getBean);
            root = loader.load();
            
            if (stage == null) {
                stage = new Stage();
                stage.setTitle("Pago con Transferencia");
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
            System.out.println("Vista de pago con transferencia mostrada correctamente");
        } catch (IOException e) {
            System.err.println("Error al cargar la vista de pago con transferencia: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al cargar la vista de pago con transferencia", e);
        }
    }

    public void cerrar() {
        if (stage != null) {
            stage.close();
        }
    }
} 