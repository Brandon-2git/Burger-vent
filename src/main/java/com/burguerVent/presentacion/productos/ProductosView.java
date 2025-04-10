/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.burguerVent.presentacion.productos;

import com.burguerVent.negocio.modelo.Producto;
import com.burguerVent.presentacion.menu.MenuController;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

/**
 *
 * @author Brandon
 */
public class ProductosView {
    
    
    private MenuController menuController;
    
 // Método para inyectar el controlador
    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }
    
    /*
        Este es anchorPane que contiene los productos de hamburguesas clasicas
        que sera inyectado en el Pane del menuView
    */
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
        
       
       btnAgregar1.setOnAction(e -> {
        	 Producto producto1 = new Producto("Hamburguesa Aracherra", 50.0);
            menuController.agregarClasica(producto1); // Usar el controlador para agregar el producto
        });

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
        
          btnAgregar2.setOnAction(e -> {
         	 Producto producto2 = new Producto("Hamburguesa de pollo", 56.0);
            menuController.agregarClasica(producto2); // Usar el controlador para agregar el producto
       });


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
        
        btnAgregar3.setOnAction(e -> {
          	 Producto producto3 = new Producto("Hamburguesa de res", 65.0);
              menuController.agregarClasica(producto3); // Usar el controlador para agregar el producto
          });


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
    
    
    /*
    Este es anchorPane que contiene los productos de Hamburguesas Premium
    que sera inyectado en el Pane del menuView
    */
    public AnchorPane getPremiumPane() {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefSize(600, 400);

        // Crear el contenedor principal Pane
        Pane mainPane = new Pane();
        mainPane.setPrefSize(780, 321);
        AnchorPane.setTopAnchor(mainPane, 0.0);
        AnchorPane.setLeftAnchor(mainPane, 0.0);
        AnchorPane.setBottomAnchor(mainPane, 0.0);

        // Crear y configurar el primer Pane (Hamburguesa a la BBQ)
        Pane pane1 = new Pane();
        pane1.setLayoutX(30.0);
        pane1.setLayoutY(59.0);
        pane1.setPrefSize(225.0, 200.0);
        pane1.setStyle("-fx-background-color: #FFA500;");

        Button btnAgregar1 = new Button("Agregar");
        btnAgregar1.setLayoutX(28.0);
        btnAgregar1.setLayoutY(161.0);

        Label label1 = new Label("Hamburguesa a la BBQ");
        label1.setLayoutX(28.0);
        label1.setLayoutY(6.0);
        label1.setStyle("-fx-text-fill: white;");
        label1.setFont(new Font("System Bold", 12));

        ImageView imageView1 = new ImageView(new Image(getClass().getResourceAsStream("/Images/BBQ.jpg")));
        imageView1.setFitHeight(117.0);
        imageView1.setFitWidth(197.0);
        imageView1.setLayoutX(14.0);
        imageView1.setLayoutY(32.0);

        Button btnDetalles1 = new Button("Detalles");
        btnDetalles1.setLayoutX(137.0);
        btnDetalles1.setLayoutY(161.0);

        pane1.getChildren().addAll(btnAgregar1, label1, imageView1, btnDetalles1);
        
        btnAgregar1.setOnAction(e -> {
       	 Producto producto1 = new Producto("Hamburguesa a la BBQ", 80.0);
           menuController.agregarPremium(producto1); // Usar el controlador para agregar el producto
          // Button btnelimina3 = new Button("Agregar");
           //btnAgregar1.setLayoutX(29.0);
           //btnAgregar1.setLayoutY(172.0);
       });

        // Crear y configurar el segundo Pane (Hamburguesa buffalo chicken)
        Pane pane2 = new Pane();
        pane2.setLayoutX(275.0);
        pane2.setLayoutY(59.0);
        pane2.setPrefSize(226.0, 200.0);
        pane2.setStyle("-fx-background-color: #FFA500;");

        Button btnAgregar2 = new Button("Agregar");
        btnAgregar2.setLayoutX(21.0);
        btnAgregar2.setLayoutY(161.0);

        Label label2 = new Label("Hamburguesa buffalo chicken");
        label2.setLayoutX(8.0);
        label2.setLayoutY(4.0);
        label2.setStyle("-fx-text-fill: white;");
        label2.setFont(new Font("System Bold", 15));

        ImageView imageView2 = new ImageView(new Image(getClass().getResourceAsStream("/Images/polloBufalo.jpg")));
        imageView2.setFitHeight(117.0);
        imageView2.setFitWidth(197.0);
        imageView2.setLayoutX(15.0);
        imageView2.setLayoutY(31.0);

        Button btnDetalles2 = new Button("Detalles");
        btnDetalles2.setLayoutX(136.0);
        btnDetalles2.setLayoutY(161.0);

        pane2.getChildren().addAll(btnAgregar2, label2, imageView2, btnDetalles2);
        
        btnAgregar2.setOnAction(e -> {
          	 Producto producto2 = new Producto("Hamburguesa buffalo chicken", 70.0);
              menuController.agregarPremium(producto2); // Usar el controlador para agregar el producto
          });

        // Crear y configurar el tercer Pane (Hamburguesa con aros)
        Pane pane3 = new Pane();
        pane3.setLayoutX(518.0);
        pane3.setLayoutY(59.0);
        pane3.setPrefSize(238.0, 200.0);
        pane3.setStyle("-fx-background-color: #FFA500;");

        Label label3 = new Label("Hamburguesa con aros");
        label3.setLayoutX(47.0);
        label3.setLayoutY(4.0);
        label3.setStyle("-fx-text-fill: white;");
        label3.setFont(new Font("System Bold", 15));

        Button btnAgregar3 = new Button("Agregar");
        btnAgregar3.setLayoutX(35.0);
        btnAgregar3.setLayoutY(161.0);

        ImageView imageView3 = new ImageView(new Image(getClass().getResourceAsStream("/Images/aros.jpg")));
        imageView3.setFitHeight(117.0);
        imageView3.setFitWidth(197.0);
        imageView3.setLayoutX(21.0);
        imageView3.setLayoutY(26.0);

        Button btnDetalles3 = new Button("Detalles");
        btnDetalles3.setLayoutX(151.0);
        btnDetalles3.setLayoutY(161.0);

        pane3.getChildren().addAll(btnAgregar3, label3, imageView3, btnDetalles3);
        
        btnAgregar3.setOnAction(e -> {
         	 Producto producto3 = new Producto("Hamburguesa con aros", 81.0);
             menuController.agregarPremium(producto3); // Usar el controlador para agregar el producto
         });


        // Añadir panes secundarios al pane principal
        mainPane.getChildren().addAll(pane1, pane2, pane3);

        // Crear y configurar el Label de título
        Label titulo = new Label("Premium");
        titulo.setLayoutX(68.0);
        titulo.setLayoutY(25.0);
        titulo.setFont(new Font("System Bold", 17.0));

        // Añadir el título y el pane principal al AnchorPane
        anchorPane.getChildren().addAll(titulo, mainPane);

        // Devolver el AnchorPane que contiene todo
        return anchorPane;
    }
    
    
    /*
    Este es anchorPane que contiene los productos de bebidas
    que sera inyectado en el Pane del menuView
    */
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
        
        btnAgregar1.setOnAction(e -> {
       	 Producto producto1 = new Producto("Coca cola", 30.0);
           menuController.agregarBebidas(producto1); // Usar el controlador para agregar el producto
       });

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
        
        btnAgregar2.setOnAction(e -> {
          	 Producto producto2 = new Producto("Pepsi", 30.0);
              menuController.agregarBebidas(producto2); // Usar el controlador para agregar el producto
          });


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
        
        btnAgregar3.setOnAction(e -> {
         	 Producto producto3 = new Producto("Fanta", 30.0);
             menuController.agregarBebidas(producto3); // Usar el controlador para agregar el producto
         });

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
        
//        btnAgregar31.setOnAction(e -> {
//        	 Producto producto4 = new Producto("Sprite", 30.0);
//            menuController.agregarbebidas(producto4); // Usar el controlador para agregar el producto
//        });

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
