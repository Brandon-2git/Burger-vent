/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.burguerVent.view;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import org.springframework.stereotype.Component;

@Component
public class MenuView extends Application {
    @Override
    public void start(Stage primaryStage) {
        AnchorPane root = new AnchorPane();
        root.setStyle("-fx-background-color: #FF4500;");
        root.setPrefSize(847, 607);

        // Panel 1 - Hamburguesa de Arrachera
        Pane pane1 = createPane(54, 70, "Hamburguesa de Arrachera", "Images/arrachera.jpg");
        root.getChildren().add(pane1);

        // Panel 2 - Hamburguesa de Pollo
        Pane pane2 = createPane(322, 70, "Hamburguesa de Pollo", "Images/pollo.jpg");
        root.getChildren().add(pane2);

        // Panel 3 - Hamburguesa de Res
        Pane pane3 = createPane(576, 70, "Hamburguesa de Res", "Images/res.jpg");
        root.getChildren().add(pane3);

        // Lista de hamburguesas
        ListView<String> listHamburguesas = new ListView<>();
        listHamburguesas.setLayoutX(48);
        listHamburguesas.setLayoutY(411);
        listHamburguesas.setPrefSize(771, 123);
        root.getChildren().add(listHamburguesas);

        // Panel inferior - Total y Mi orden
        Pane bottomPane = new Pane();
        bottomPane.setLayoutX(48);
        bottomPane.setLayoutY(370);
        bottomPane.setPrefSize(771, 32);
        bottomPane.setStyle("-fx-background-color: gray;");
        
        Label lblMiOrden = new Label("Mi orden");
        lblMiOrden.setLayoutX(40);
        lblMiOrden.setLayoutY(6);
        lblMiOrden.setFont(new Font("System Bold", 15));
        lblMiOrden.setStyle("-fx-text-fill: white;");
        
        Label lblTotal = new Label("Total:");
        lblTotal.setLayoutX(596);
        lblTotal.setLayoutY(7);
        lblTotal.setStyle("-fx-text-fill: white;");
        
        Label txtTotal = new Label();
        txtTotal.setLayoutX(643);
        txtTotal.setLayoutY(8);
        txtTotal.setPrefSize(99, 18);
        txtTotal.setStyle("-fx-background-color: white; -fx-border-color: gray;");
        
        bottomPane.getChildren().addAll(lblMiOrden, lblTotal, txtTotal);
        root.getChildren().add(bottomPane);

        // Botón Siguiente
        Button btnSiguiente = new Button("Siguiente");
        btnSiguiente.setLayoutX(710);
        btnSiguiente.setLayoutY(547);
        root.getChildren().add(btnSiguiente);

        Scene scene = new Scene(root);
        primaryStage.setTitle("Menú de Hamburguesas");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Pane createPane(double x, double y, String title, String imagePath) {
        Pane pane = new Pane();
        pane.setLayoutX(x);
        pane.setLayoutY(y);
        pane.setPrefSize(225, 200);
        pane.setStyle("-fx-background-color: #FFA500;");
        
        Label label = new Label(title);
        label.setLayoutX(28);
        label.setLayoutY(6);
        label.setFont(new Font("System Bold", 12));
        label.setStyle("-fx-text-fill: white;");
        
        ImageView imageView = new ImageView(new Image(imagePath));
        imageView.setFitWidth(197);
        imageView.setFitHeight(117);
        imageView.setLayoutX(14);
        imageView.setLayoutY(32);
        
        Button btnAgregar = new Button("Agregar");
        btnAgregar.setLayoutX(28);
        btnAgregar.setLayoutY(161);
        
        Button btnDetalles = new Button("Ver Detalles");
        btnDetalles.setLayoutX(125);
        btnDetalles.setLayoutY(161);
        
        pane.getChildren().addAll(label, imageView, btnAgregar, btnDetalles);
        return pane;
    }   
    
    
}

