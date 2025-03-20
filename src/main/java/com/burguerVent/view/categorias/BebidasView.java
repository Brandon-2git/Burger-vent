package com.burguerVent.view.categorias;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import org.springframework.stereotype.Component;

@Component
public class BebidasView{
   public AnchorPane getBebidasPane() {
        // Crear el AnchorPane principal
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefHeight(372.0);
        anchorPane.setPrefWidth(890.0);

        // Crear el Pane secundario
        Pane pane = new Pane();
        pane.setLayoutY(11.0);
        pane.setPrefHeight(353.0);
        pane.setPrefWidth(882.0);

        // Primer Pane para Coca Cola
        Pane pane1 = new Pane();
        pane1.setLayoutX(29.0);
        pane1.setLayoutY(59.0);
        pane1.setPrefHeight(252.0);
        pane1.setPrefWidth(187.0);
        pane1.setStyle("-fx-background-color: #FFA500;");

        Button btnAgregar1 = new Button("Agregar");
        btnAgregar1.setLayoutX(28.0);
        btnAgregar1.setLayoutY(213.0);

        Label label1 = new Label("Coca Cola");
        label1.setLayoutX(28.0);
        label1.setLayoutY(6.0);
        label1.setStyle("-fx-text-fill: white;");
        label1.setFont(new Font("System Bold", 15.0));

        ImageView myImage = new ImageView(new Image(getClass().getResource("/Images/coca.png").toExternalForm()));
        myImage.setFitHeight(156.0);
        myImage.setFitWidth(155.0);
        myImage.setLayoutX(14.0);
        myImage.setLayoutY(37.0);

        Button btnDetalles1 = new Button("Detalles");
        btnDetalles1.setLayoutX(97.0);
        btnDetalles1.setLayoutY(213.0);

        // Añadir al primer Pane
        pane1.getChildren().addAll(btnAgregar1, label1, myImage, btnDetalles1);

        // Segundo Pane para Pepsi
        Pane pane2 = new Pane();
        pane2.setLayoutX(239.0);
        pane2.setLayoutY(59.0);
        pane2.setPrefHeight(252.0);
        pane2.setPrefWidth(167.0);
        pane2.setStyle("-fx-background-color: #FFA500;");

        Button btnAgregar2 = new Button("Agregar");
        btnAgregar2.setLayoutX(14.0);
        btnAgregar2.setLayoutY(207.0);

        Label label2 = new Label("Pepsi");
        label2.setLayoutX(37.0);
        label2.setLayoutY(4.0);
        label2.setStyle("-fx-text-fill: white;");
        label2.setFont(new Font("System Bold", 15.0));

        ImageView myImage1 = new ImageView(new Image(getClass().getResource("/Images/pepsi.png").toExternalForm()));
        myImage1.setFitHeight(156.0);
        myImage1.setFitWidth(112.0);
        myImage1.setLayoutX(28.0);
        myImage1.setLayoutY(40.0);

        Button btnDetalles2 = new Button("Detalles");
        btnDetalles2.setLayoutX(94.0);
        btnDetalles2.setLayoutY(207.0);

        // Añadir al segundo Pane
        pane2.getChildren().addAll(btnAgregar2, label2, myImage1, btnDetalles2);

        // Tercer Pane para Fanta
        Pane pane3 = new Pane();
        pane3.setLayoutX(434.0);
        pane3.setLayoutY(59.0);
        pane3.setPrefHeight(252.0);
        pane3.setPrefWidth(187.0);
        pane3.setStyle("-fx-background-color: #FFA500;");

        Label label3 = new Label("Fanta");
        label3.setLayoutX(47.0);
        label3.setLayoutY(4.0);
        label3.setRotate(-0.7);
        label3.setStyle("-fx-text-fill: white;");
        label3.setFont(new Font("System Bold", 15.0));

        Button btnAgregar3 = new Button("Agregar");
        btnAgregar3.setLayoutX(27.0);
        btnAgregar3.setLayoutY(206.0);

        ImageView myImage2 = new ImageView(new Image(getClass().getResource("/Images/fanta.png").toExternalForm()));
        myImage2.setFitHeight(156.0);
        myImage2.setFitWidth(142.0);
        myImage2.setLayoutX(23.0);
        myImage2.setLayoutY(38.0);

        Button btnDetalles = new Button("Detalles");
        btnDetalles.setLayoutX(104.0);
        btnDetalles.setLayoutY(206.0);

        // Añadir al tercer Pane
        pane3.getChildren().addAll(label3, btnAgregar3, myImage2, btnDetalles);

        // Cuarto Pane para Sprite
        Pane pane4 = new Pane();
        pane4.setLayoutX(645.0);
        pane4.setLayoutY(59.0);
        pane4.setPrefHeight(252.0);
        pane4.setPrefWidth(187.0);
        pane4.setStyle("-fx-background-color: #FFA500;");

        Label label4 = new Label("Sprite");
        label4.setLayoutX(47.0);
        label4.setLayoutY(4.0);
        label4.setRotate(-0.7);
        label4.setStyle("-fx-text-fill: white;");
        label4.setFont(new Font("System Bold", 15.0));

        Button btnAgregar31 = new Button("Agregar");
        btnAgregar31.setLayoutX(27.0);
        btnAgregar31.setLayoutY(206.0);

        ImageView myImage21 = new ImageView(new Image(getClass().getResource("/Images/sprite.png").toExternalForm()));
        myImage21.setFitHeight(156.0);
        myImage21.setFitWidth(112.0);
        myImage21.setLayoutX(38.0);
        myImage21.setLayoutY(40.0);

        Button btnDetalles3 = new Button("Detalles");
        btnDetalles3.setLayoutX(104.0);
        btnDetalles3.setLayoutY(206.0);

        // Añadir al cuarto Pane
        pane4.getChildren().addAll(label4, btnAgregar31, myImage21, btnDetalles3);

        // Crear la etiqueta "Bebidas"
        Label labelBebidas = new Label("Bebidas");
        labelBebidas.setLayoutX(68.0);
        labelBebidas.setLayoutY(25.0);
        labelBebidas.setFont(new Font("System Bold", 17.0));

        // Añadir todos los panes y la etiqueta al pane principal
        pane.getChildren().addAll(pane1, pane2, pane3, pane4, labelBebidas);

        // Añadir el pane principal al AnchorPane
        anchorPane.getChildren().add(pane);

        return anchorPane;
    }
}
