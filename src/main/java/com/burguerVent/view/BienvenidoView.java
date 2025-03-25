package com.burguerVent.view;

import com.burguerVent.controller.BienvenidoController;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

@Component
public class BienvenidoView extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Crear el AnchorPane
        AnchorPane root = new AnchorPane();

        // Crear etiquetas
        Label label1 = new Label("BurguerVent");
        label1.setFont(Font.font("System Bold", 21));
        label1.setAlignment(Pos.CENTER);
        label1.setLayoutX(196.0);
        label1.setLayoutY(63.0);

        Label label2 = new Label("Bienvenido");
        label2.setFont(Font.font(20));
        label2.setAlignment(Pos.CENTER);
        label2.setLayoutX(196.0);
        label2.setLayoutY(138.0);
        label2.setEffect(new Glow());

        // Crear botón
        Button btnComenzar = new Button("Comenzar");
        btnComenzar.setFont(Font.font(15));
        btnComenzar.setLayoutX(202.0);
        btnComenzar.setLayoutY(214.0);
        btnComenzar.setPrefHeight(46.0);
        btnComenzar.setPrefWidth(170.0);

        // Asignar el controlador de eventos
        BienvenidoController controller = new BienvenidoController(primaryStage);
        btnComenzar.setOnAction(controller.handleComenzarButton());

        // Agregar elementos al AnchorPane
        root.getChildren().addAll(label1, label2, btnComenzar);

        // Crear la escena y mostrarla
        Scene scene = new Scene(root, 574, 400);
        primaryStage.setTitle("Menú");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
