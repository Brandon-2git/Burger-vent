/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.burguerVent.view;

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
/**
 *
 * @author Brandon
 */
@Component
public class BienvenidoView extends Application {
     @Override
    public void start(Stage primaryStage) {
        // Crear el AnchorPane
        AnchorPane root = new AnchorPane();

        // Crear el primer Label (BurguerVent)
        Label label1 = new Label("BurguerVent");
        label1.setFont(Font.font("System Bold", 21));
        label1.setAlignment(Pos.CENTER);
        label1.setLayoutX(196.0);
        label1.setLayoutY(63.0);
        label1.setPrefHeight(18.0);
        label1.setPrefWidth(170.0);

        // Crear el segundo Label (Bienvenido)
        Label label2 = new Label("Bienvenido");
        label2.setFont(Font.font(20));
        label2.setAlignment(Pos.CENTER);
        label2.setLayoutX(196.0);
        label2.setLayoutY(138.0);
        label2.setPrefHeight(18.0);
        label2.setPrefWidth(170.0);

        // Agregar un efecto Glow al segundo Label
        Glow glow = new Glow();
        label2.setEffect(glow);

        // Crear el Button (Comenzar)
        Button btnComenzar = new Button("Comenzar");
        btnComenzar.setFont(Font.font(15));
        btnComenzar.setLayoutX(202.0);
        btnComenzar.setLayoutY(214.0);
        btnComenzar.setPrefHeight(46.0);
        btnComenzar.setPrefWidth(170.0);
        // Evento para abrir la ventana del menú principal
        btnComenzar.setOnAction(event -> {
            MenuView2 menuView = new MenuView2();
            Stage stage = new Stage();
            try {
                menuView.start(stage);
                primaryStage.close(); // Opcional: cerrar la ventana actual
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Agregar los elementos al AnchorPane
        root.getChildren().addAll(label1, label2, btnComenzar);

        // Crear la escena y mostrarla en el Stage
        Scene scene = new Scene(root, 574, 400);
        primaryStage.setTitle("Menú");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
}
