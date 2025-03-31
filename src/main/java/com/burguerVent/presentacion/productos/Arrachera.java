/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.burguerVent.presentacion.productos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Arrachera extends Application{
    
    @Override
    public void start(Stage primaryStage) {
        // Crear AnchorPane (Contenedor principal)
        AnchorPane root = new AnchorPane();
        root.setPrefSize(708, 400);

        // Crear Pane (Contenedor para la imagen)
        Pane imagePane = new Pane();
        imagePane.setLayoutX(14);
        imagePane.setLayoutY(81);
        imagePane.setPrefSize(206, 117);

        // Crear ImageView con la imagen
        ImageView imageView = new ImageView(new Image(getClass().getResource("/Images/arrachera.jpg").toExternalForm()));
        imageView.setFitHeight(166);
        imageView.setFitWidth(206);
        imageView.setPreserveRatio(true);
        imageView.setPickOnBounds(true);

        // Agregar ImageView al Pane
        imagePane.getChildren().add(imageView);

        // Crear Label para el título
        Label titleLabel = new Label("Hamburguesa de Arrachera");
        titleLabel.setLayoutX(32);
        titleLabel.setLayoutY(47);

        // Crear Label para la descripción con ajuste de texto
        Label descriptionLabel = new Label("Hamburguesa de arrachera jugosa, sazonada con especias y cocinada a la parrilla. "
                + "Servida en pan fresco con lechuga, jitomate y cebolla caramelizada. Ideal para disfrutar en cualquier momento.");
        descriptionLabel.setLayoutX(275);
        descriptionLabel.setLayoutY(94);
        descriptionLabel.setPrefSize(350, 90);
        descriptionLabel.setWrapText(true);
        descriptionLabel.setStyle("-fx-text-alignment: justify;");

        // Agregar los elementos al AnchorPane
        root.getChildren().addAll(imagePane, titleLabel, descriptionLabel);

        // Configurar y mostrar la escena
        Scene scene = new Scene(root);
        primaryStage.setTitle("Hamburguesa de Arrachera");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
}
