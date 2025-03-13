/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.burguerVent.controller;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.control.Button;


/**
 Este controlador manejará los eventos cuando el usuario 
 * interactúe con la interfaz.
 */
public class MenuController{
   
    @FXML
    private Button btnComenzar;  // ID correcto

   
    @FXML
    private void cambiarVentana() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Menu.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) btnComenzar.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    
    
}
