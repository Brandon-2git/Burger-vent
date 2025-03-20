package com.burguerVent.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.burguerVent.model.Producto;

@Component
public class ClasicasView {
	
	private List<Producto> orden = new ArrayList<>();
    private ListView<String> listHamburguesas; // Referencia al ListView existente

    public AnchorPane getClasicasPane() {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefSize(600, 400);

        // Crear el contenedor principal Pane
        Pane mainPane = new Pane();
        mainPane.setPrefSize(782, 400);
        AnchorPane.setTopAnchor(mainPane, 0.0);
        AnchorPane.setLeftAnchor(mainPane, 0.0);
        AnchorPane.setBottomAnchor(mainPane, 0.0);

        // Crear y configurar el primer Pane (Hamburguesa de Arachera)
        Pane pane1 = new Pane();
        pane1.setLayoutX(30.0);
        pane1.setLayoutY(59.0);
        pane1.setPrefSize(225.0, 200.0);
        pane1.setStyle("-fx-background-color: #FFA500;");

        Button btnAgregar1 = new Button("Agregar");
        btnAgregar1.setLayoutX(28.0);
        btnAgregar1.setLayoutY(161.0);
        
    

        Label label1 = new Label("Hamburguesa de Arachera");
        label1.setLayoutX(28.0);
        label1.setLayoutY(6.0);
        label1.setStyle("-fx-text-fill: white;");
        label1.setFont(new Font("System Bold", 12));

        ImageView imageView1 = new ImageView(new Image(getClass().getResourceAsStream("/Images/arrachera.jpg")));
        imageView1.setFitHeight(117.0);
        imageView1.setFitWidth(197.0);
        imageView1.setLayoutX(14.0);
        imageView1.setLayoutY(32.0);

        Button btnDetalles1 = new Button("Detalles");
        btnDetalles1.setLayoutX(137.0);
        btnDetalles1.setLayoutY(161.0);

        pane1.getChildren().addAll(btnAgregar1, label1, imageView1, btnDetalles1);

        // Crear y configurar el segundo Pane (Hamburguesa de Pollo)
        Pane pane2 = new Pane();
        pane2.setLayoutX(275.0);
        pane2.setLayoutY(59.0);
        pane2.setPrefSize(226.0, 200.0);
        pane2.setStyle("-fx-background-color: #FFA500;");

        Button btnAgregar2 = new Button("Agregar");
        btnAgregar2.setLayoutX(21.0);
        btnAgregar2.setLayoutY(161.0);

        Label label2 = new Label("Hamburguesa de Pollo");
        label2.setLayoutX(37.0);
        label2.setLayoutY(4.0);
        label2.setStyle("-fx-text-fill: white;");
        label2.setFont(new Font("System", 15));

        ImageView imageView2 = new ImageView(new Image(getClass().getResourceAsStream("/Images/pollo.jpg")));
        imageView2.setFitHeight(117.0);
        imageView2.setFitWidth(197.0);
        imageView2.setLayoutX(15.0);
        imageView2.setLayoutY(31.0);

        Button btnDetalles2 = new Button("Detalles");
        btnDetalles2.setLayoutX(136.0);
        btnDetalles2.setLayoutY(161.0);

        pane2.getChildren().addAll(btnAgregar2, label2, imageView2, btnDetalles2);

        // Crear y configurar el tercer Pane (Hamburguesa de Res)
        Pane pane3 = new Pane();
        pane3.setLayoutX(518.0);
        pane3.setLayoutY(59.0);
        pane3.setPrefSize(238.0, 200.0);
        pane3.setStyle("-fx-background-color: #FFA500;");

        Button btnAgregar3 = new Button("Agregar");
        btnAgregar3.setLayoutX(35.0);
        btnAgregar3.setLayoutY(161.0);

        Label label3 = new Label("Hamburguesa de Res");
        label3.setLayoutX(47.0);
        label3.setLayoutY(4.0);
        label3.setStyle("-fx-text-fill: white;");
        label3.setFont(new Font("System Bold", 15));

        ImageView imageView3 = new ImageView(new Image(getClass().getResourceAsStream("/Images/res.jpg")));
        imageView3.setFitHeight(117.0);
        imageView3.setFitWidth(197.0);
        imageView3.setLayoutX(21.0);
        imageView3.setLayoutY(26.0);

        Button btnDetalles3 = new Button("Detalles");
        btnDetalles3.setLayoutX(151.0);
        btnDetalles3.setLayoutY(161.0);

        pane3.getChildren().addAll(btnAgregar3, label3, imageView3, btnDetalles3);

        // Añadir panes secundarios al pane principal
        mainPane.getChildren().addAll(pane1, pane2, pane3);

        // Crear y configurar el Label de título
        Label titulo = new Label("Clásicas");
        titulo.setLayoutX(68.0);
        titulo.setLayoutY(25.0);
        titulo.setFont(new Font("System Bold", 17.0));

        // Añadir el título y el pane principal al AnchorPane
        anchorPane.getChildren().addAll(titulo, mainPane);

        // Devolver el AnchorPane que contiene todo
        return anchorPane;
    }
}


