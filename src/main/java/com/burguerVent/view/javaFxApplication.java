/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.burguerVent.view;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

/**
 *
 * @author Brandon
 */
@Component
public class javaFxApplication extends Application{
     @Override
    public void start(Stage primaryStage) throws Exception {
        // Cargar el archivo FXML desde la ubicación correcta
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/bienvenido.fxml"));
        
        // Crear la escena a partir del FXML
        Scene scene = new Scene(fxmlLoader.load());
        
        // Configurar la ventana
        primaryStage.setScene(scene);
        primaryStage.setTitle("BueguerVent");//nombre de la ventana
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args); // Llamar a launch para iniciar la aplicación JavaFX
    }
}
