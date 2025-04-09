package com.burguerVent.presentacion.InterfazAdmin;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * Clase que representa la vista de opciones dentro de la interfaz de administrador.
 * Actualmente, implementa la vista de pedidos en un panel gráfico.
 */
public class OpcionesInterfaz {
    
    private InterfazAdminController AdminUi;
    
    /**
     * Método para establecer el controlador de la interfaz de administrador.
     * 
     * @param AdminUIController instancia del controlador principal de la interfaz admin
     */
    public void setMenuController(InterfazAdminController AdminUIController) {
        this.AdminUi = AdminUIController;
    }
    
    /**
     * Genera y retorna un panel (`Pane`) que representa la lista de pedidos del administrador.
     * @return Pane con la interfaz gráfica para mostrar los pedidos
     */
    public Pane getPedidosPane() {
        // Crear el Pane principal
        Pane pedidosPane = new Pane();
        pedidosPane.setPrefHeight(354.0);
        pedidosPane.setPrefWidth(598.0);

        // Crear y configurar la etiqueta "Pedidos"
        Label pedidosLabel = new Label("Pedidos");
        pedidosLabel.setLayoutX(39.0);
        pedidosLabel.setLayoutY(22.0);
        pedidosLabel.setPrefHeight(17.0);
        pedidosLabel.setPrefWidth(149.0);

        // Crear y configurar el ListView
        ListView<String> listView = new ListView<>();
        listView.setLayoutX(33.0);
        listView.setLayoutY(93.0);
        listView.setPrefHeight(232.0);
        listView.setPrefWidth(543.0);

        // Crear y configurar el HBox
        HBox headerHBox = new HBox();
        headerHBox.setLayoutX(33.0);
        headerHBox.setLayoutY(64.0);
        headerHBox.setPrefHeight(29.0);
        headerHBox.setPrefWidth(543.0);
        headerHBox.setStyle("-fx-background-color: #d3d3d3;");

        // Crear etiquetas dentro del HBox
        Label idLabel = new Label("     Id");
        idLabel.setPrefHeight(40.0);
        idLabel.setPrefWidth(54.0);

        Label detallesLabel = new Label("Detalles");
        detallesLabel.setPrefHeight(30.0);
        detallesLabel.setPrefWidth(170.0);

        Label costoLabel = new Label("Costo");
        costoLabel.setPrefHeight(30.0);
        costoLabel.setPrefWidth(94.0);

        Label estadoLabel = new Label("Estado");
        estadoLabel.setPrefHeight(30.0);
        estadoLabel.setPrefWidth(116.0);

        Label fechaLabel = new Label("Fecha");
        fechaLabel.setPrefHeight(40.0);
        fechaLabel.setPrefWidth(54.0);

        // Agregar las etiquetas al HBox
        headerHBox.getChildren().addAll(idLabel, detallesLabel, costoLabel, estadoLabel, fechaLabel);

        // Agregar todos los elementos al Pane principal
        pedidosPane.getChildren().addAll(pedidosLabel, listView, headerHBox);

        return pedidosPane;
    }
    
    //Aqui se agregaran los demas paneles para cada opcion de los botones de la interfaz del administrador
}
