package com.burguerVent.presentacion.bienvenido;

import com.burguerVent.presentacion.Admin.AdminAcceso;
import com.burguerVent.presentacion.Admin.AdminAccesoController;
import com.burguerVent.presentacion.menu.MenuController;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/*<*/
@Component
public class BienvenidoView {
    private Stage stage;
    
    private BienvenidoController controlBienvenido;
    private boolean initialized = false;
    @Autowired
    private MenuController menuController;  // Inyectamos el controlador de Menu
    @Autowired
    private AdminAccesoController adminController;
    
    
    public BienvenidoView() {
        // Constructor vacío
    }

    private void initializeUI() {
        if (initialized) {
            return;
        }
        if (!Platform.isFxApplicationThread()) {
            Platform.runLater(this::initializeUI);
            return;
        }

        stage = new Stage();
        stage.setTitle("Bienvenido");

        // Crear el AnchorPane
        AnchorPane root = new AnchorPane();
        root.setStyle("-fx-background-color: orange;");
        
        // Crear el Pane con color de fondo
        Pane pane = new Pane();
        pane.setLayoutX(46.0);
        pane.setLayoutY(41.0);
        pane.setPrefHeight(314.0);
        pane.setPrefWidth(488.0);
        pane.setStyle("-fx-background-color: #FF8C00;");

        // Crear etiquetas
        Label label1 = new Label("BurguerVent");
        label1.setFont(Font.font("System Bold", 21));
        label1.setAlignment(Pos.CENTER);
        label1.setLayoutX(191.0);
        label1.setLayoutY(71.0);
        label1.setStyle("-fx-text-fill: white;");

        Label label2 = new Label("Bienvenido");
        label2.setFont(Font.font(20));
        label2.setAlignment(Pos.CENTER);
        label2.setLayoutX(200.0);
        label2.setLayoutY(121.0);
        label2.setStyle("-fx-text-fill: white;");
        label2.setEffect(new Glow());

        // Crear botón
        Button btnComenzar = new Button("Comenzar");
        btnComenzar.setFont(Font.font(15));
        btnComenzar.setLayoutX(159.0);
        btnComenzar.setLayoutY(207.0);
        btnComenzar.setPrefHeight(46.0);
        btnComenzar.setPrefWidth(170.0);
        btnComenzar.setStyle("-fx-background-color: green; -fx-text-fill: white;");
        // Agregar efecto hover en el botón
        btnComenzar.setOnMouseEntered(event -> {
            btnComenzar.setStyle("-fx-background-color: #FF6347; -fx-text-fill: black;");
        });
        btnComenzar.setOnMouseExited(event -> {
            btnComenzar.setStyle("-fx-background-color: green; -fx-text-fill: white;");
        });
        //Boton que acciona el evento de cambiar de pagina
        btnComenzar.setOnAction(event -> {
            if (controlBienvenido != null) {
                controlBienvenido.comenzar();
            }
            // Cambiar a la vista del menú
            menuController.inicia(); // Esto abrirá una nueva ventana para el menú
            stage.close(); // Esto cierra la ventana de BienvenidoView
        });
        
            // Crear el botón circular con el ícono de persona
        Button btnProfile = new Button("👤");
        btnProfile.setLayoutX(446.0);
        btnProfile.setLayoutY(275.0);
        btnProfile.setStyle("-fx-background-radius: 50%; -fx-background-color: #E65100; -fx-text-fill: black;");
        
        btnProfile.setOnMouseEntered(event -> {
            btnProfile.setStyle("-fx-background-radius: 50%; -fx-background-color: #FF6347; -fx-text-fill: white;");
        });
        btnProfile.setOnMouseExited(event -> {
            btnProfile.setStyle("-fx-background-radius: 50%; -fx-background-color: #E65100; -fx-text-fill: black;");
        });
        
        //Boton que acciona el evento de cambiar de pagina
        btnProfile.setOnAction(event -> {
           
            // Cambiar a una interfaz de acceso
            adminController.inicia();
            stage.close(); // Esto cierra la ventana de BienvenidoView
        });
        
        

        // Agregar elementos al AnchorPane
        pane.getChildren().addAll(label1, label2, btnComenzar, btnProfile);
        // Agregar el Pane al AnchorPane
        root.getChildren().add(pane);
        
        // Crear la escena y mostrarla
        Scene scene = new Scene(root, 574, 400);
        stage.setScene(scene);
        initialized = true;
    }
    

    public void muestra(BienvenidoController control) {
        this.controlBienvenido = control;
        if (!Platform.isFxApplicationThread()) {
            Platform.runLater(() -> this.muestra(control));
            return;
        }
        initializeUI();
        stage.show();
    }
    
}



        // Asignar el controlador de eventos para el botón directamente en la vista
//        btnComenzar.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                if (controlBienvenido != null) {
//                    controlBienvenido.comenzar();
//                }
//            }
//        });
