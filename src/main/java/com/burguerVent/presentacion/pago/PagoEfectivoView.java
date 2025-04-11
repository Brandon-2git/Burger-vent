package com.burguerVent.presentacion.pago;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Modality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.net.URL;

@Component
public class PagoEfectivoView {
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    private PagoEfectivoVistaImpl controller;
    
    @Autowired
    private ApplicationContext applicationContext;
    
    private void initializeUI() {
        try {
            if (root == null) {
                System.out.println("Cargando PagoEfectivo.fxml...");
                
                URL fxmlUrl = getClass().getResource("/fxml/PagoEfectivo.fxml");
                if (fxmlUrl == null) {
                    System.err.println("No se pudo encontrar el archivo PagoEfectivo.fxml");
                    throw new RuntimeException("No se pudo encontrar el archivo PagoEfectivo.fxml");
                }
                
                System.out.println("FXML encontrado en: " + fxmlUrl);
                
                FXMLLoader loader = new FXMLLoader(fxmlUrl);
                loader.setControllerFactory(applicationContext::getBean);
                
                try {
                    root = loader.load();
                    controller = loader.getController();
                    
                    if (controller == null) {
                        System.err.println("Error: El controlador es null después de cargar el FXML");
                        throw new RuntimeException("No se pudo cargar el controlador PagoEfectivoVistaImpl");
                    }
                    
                    System.out.println("Controller cargado exitosamente: " + controller);
                } catch (IOException e) {
                    System.err.println("Error al cargar el FXML: " + e.getMessage());
                    e.printStackTrace();
                    throw new RuntimeException("Error al cargar el FXML", e);
                }
            }
            
            if (stage == null) {
                stage = new Stage();
                stage.setTitle("Pago en Efectivo");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setResizable(false);
                
                scene = new Scene(root);
                stage.setScene(scene);
                
                // Configurar el stage en el controlador
                controller.setStage(stage);
            }
            
            System.out.println("UI inicializada correctamente");
            
        } catch (Exception e) {
            System.err.println("Error al inicializar la UI: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al cargar la vista de pago en efectivo", e);
        }
    }
    
    public void mostrar() {
        if (!Platform.isFxApplicationThread()) {
            Platform.runLater(this::mostrar);
            return;
        }
        
        try {
            System.out.println("Intentando mostrar la vista de pago en efectivo...");
            initializeUI();
            if (stage != null) {
                stage.show();
                stage.toFront();
                System.out.println("Vista de pago en efectivo mostrada correctamente");
            } else {
                throw new RuntimeException("Error: stage es null al intentar mostrar la vista");
            }
        } catch (Exception e) {
            System.err.println("Error al mostrar la vista de pago en efectivo: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al mostrar la vista de pago en efectivo", e);
        }
    }
    
    public void cerrar() {
        if (stage != null) {
            stage.close();
        }
    }
} 