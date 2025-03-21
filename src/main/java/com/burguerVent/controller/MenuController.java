package com.burguerVent.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MenuController {

    @FXML
    private AnchorPane pnlMostrar;  // El panel donde se cargará el contenido dinámicamente
    @FXML
    private Button btnClasicas;

    @FXML
    private Button btnPremium;

    @FXML
    private Button btnBebidas;
    @FXML
    private void cambiarClasicas(ActionEvent event) throws IOException {
        // Cargar el archivo FXML de hamburguesas
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Hamburguesas.fxml"));
        Parent hamburguesasRoot = loader.load();

        // Limpiar cualquier contenido anterior y agregar el nuevo contenido
        pnlMostrar.getChildren().clear();
        pnlMostrar.getChildren().add(hamburguesasRoot);
        // Centrar el contenido en pnlMostrar (AnchorPane)
        AnchorPane.setTopAnchor(hamburguesasRoot, 40.0);
        AnchorPane.setLeftAnchor(hamburguesasRoot, 100.0);
        AnchorPane.setRightAnchor(hamburguesasRoot, 0.0);
        AnchorPane.setBottomAnchor(hamburguesasRoot, 0.0);
    }
    @FXML
    private void cambiarPremium(ActionEvent event) throws IOException {
        // Cargar el archivo FXML de hamburguesas
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/HamPremium.fxml"));
        Parent hamburguesasRoot = loader.load();

        // Limpiar cualquier contenido anterior y agregar el nuevo contenido
        pnlMostrar.getChildren().clear();
        pnlMostrar.getChildren().add(hamburguesasRoot);
        // Centrar el contenido en pnlMostrar (AnchorPane)
        AnchorPane.setTopAnchor(hamburguesasRoot, 40.0);
        AnchorPane.setLeftAnchor(hamburguesasRoot, 100.0);
        AnchorPane.setRightAnchor(hamburguesasRoot, 0.0);
        AnchorPane.setBottomAnchor(hamburguesasRoot, 0.0);
    }
    @FXML
    private void cambiarBebidas(ActionEvent event) throws IOException {
        // Cargar el archivo FXML de hamburguesas
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/bebidas.fxml"));
        Parent bebidas = loader.load();

        // Limpiar cualquier contenido anterior y agregar el nuevo contenido
        pnlMostrar.getChildren().clear();
        pnlMostrar.getChildren().add(bebidas);
        // Centrar el contenido en pnlMostrar (AnchorPane)
        AnchorPane.setTopAnchor(bebidas, 0.0);
        AnchorPane.setLeftAnchor(bebidas, 60.0);
        AnchorPane.setRightAnchor(bebidas, 0.0);
        AnchorPane.setBottomAnchor(bebidas, 0.0);

    }



    @FXML
    private void cambiarAEscenaMenu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Menu.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        // Centrar la ventana en la pantalla
        stage.centerOnScreen();
        stage.show();
    }



}
