package com.burguerVent.view;


import com.burguerVent.controller.MenuController;
import com.burguerVent.view.categorias.BebidasView;
import com.burguerVent.view.categorias.ClasicasView;
import com.burguerVent.view.categorias.PremiumView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;


@Component
public class MenuView extends Application {
    
    @Autowired
    private MenuController menuController;  // Inyectar el controlador

    private Button btnClasicas;
    private Button btnPremium;
    private Button btnBebidas;
     @Override
    public void start(Stage primaryStage) {
        // AnchorPane principal
        AnchorPane anchorPrincipal = new AnchorPane();
        anchorPrincipal.setPrefSize(1152, 659);
        anchorPrincipal.setStyle("-fx-background-color: white;");

        // BorderPane como estructura principal
        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(200, 200);
        AnchorPane.setTopAnchor(borderPane, 0.0);
        AnchorPane.setBottomAnchor(borderPane, 0.0);
        AnchorPane.setLeftAnchor(borderPane, 0.0);
        AnchorPane.setRightAnchor(borderPane, 0.0);

        // Sección superior
        AnchorPane topPane = new AnchorPane();
        topPane.setPrefSize(200, 65);
        topPane.setStyle("-fx-background-color: white;");

        Pane topBar = new Pane();
        topBar.setPrefSize(200, 25);
        topBar.setStyle("-fx-background-color: orange;");
        AnchorPane.setTopAnchor(topBar, 0.0);
        AnchorPane.setLeftAnchor(topBar, 0.0);
        AnchorPane.setRightAnchor(topBar, 0.0);

        Label menuLabel = new Label("☰Menu");
        menuLabel.setFont(new Font(18));
        menuLabel.setLayoutX(38);
        menuLabel.setLayoutY(36);

        topPane.getChildren().addAll(topBar, menuLabel);
        borderPane.setTop(topPane);

        // Sección izquierda (Menú de opciones)
        AnchorPane leftPane = new AnchorPane();
        leftPane.setPrefSize(180, 436);
        leftPane.setStyle("-fx-background-color: orange;");

        VBox menuBox = new VBox();
        menuBox.setPrefSize(180, 356);
        AnchorPane.setTopAnchor(menuBox, 68.0);
        AnchorPane.setBottomAnchor(menuBox, 170.0);

        Button btnClasicas = new Button(" Hamburguesas clásicas");
        Button btnPremium = new Button("Hamburguesas Premium");
        Button btnBebidas = new Button("Bebidas");

        for (Button btn : new Button[]{btnClasicas, btnPremium, btnBebidas}) {
            btn.setPrefSize(180, 35);
            btn.setStyle("-fx-background-color: -fx-text-fill: white; -fx-border-radius: 5px; -fx-border-color: white;");
            btn.setFont(new Font("System Bold", 12));
        }

        menuBox.getChildren().addAll(btnClasicas, btnPremium, btnBebidas);
        leftPane.getChildren().add(menuBox);
        borderPane.setLeft(leftPane);

        // Sección inferior
        AnchorPane bottomPane = new AnchorPane();
        bottomPane.setPrefSize(200, 140);

        Pane bottomBar = new Pane();
        bottomBar.setPrefSize(180, 162);
        bottomBar.setStyle("-fx-background-color: orange;");
        bottomBar.setLayoutY(-5);

        ImageView logoView = new ImageView(new Image(getClass().getResourceAsStream("/Images/Logo1.png")));
        logoView.setFitWidth(180);
        logoView.setFitHeight(161);
        logoView.setLayoutY(24);
        logoView.setPreserveRatio(true);

        bottomBar.getChildren().add(logoView);

        Pane orderPane = new Pane();
        orderPane.setPrefSize(972, 32);
        orderPane.setLayoutX(180);
        orderPane.setStyle("-fx-background-color: gray;");

        Label lblMiOrden = new Label("Mi orden");
        lblMiOrden.setLayoutX(40);
        lblMiOrden.setLayoutY(6);
        lblMiOrden.setStyle("-fx-text-fill: white;");
        lblMiOrden.setFont(new Font("System Bold", 15));

        Label lblTotal = new Label("Total:");
        lblTotal.setLayoutX(669);
        lblTotal.setLayoutY(5);
        lblTotal.setStyle("-fx-text-fill: white;");

        Label txtTotal = new Label();
        txtTotal.setLayoutX(728);
        txtTotal.setLayoutY(4);
        txtTotal.setPrefSize(99, 18);
        txtTotal.setStyle("-fx-background-color: white; -fx-border-color: gray;");

        Button btnComprar = new Button("Comprar");
        btnComprar.setLayoutX(895);
        btnComprar.setLayoutY(1);
        btnComprar.setStyle("-fx-background-color: #87CEEB; -fx-border-radius: 5px;");

        orderPane.getChildren().addAll(lblMiOrden, lblTotal, txtTotal, btnComprar);

        
        /*Aqui esta lisview para que trabajes en la hu-3 y 4*/
        ListView<String> listHamburguesas = new ListView<>();
        listHamburguesas.setLayoutX(179.2);
        listHamburguesas.setLayoutY(31.2);
        listHamburguesas.setPrefSize(973, 126);
        listHamburguesas.setStyle("-fx-border-radius: 10px;");

        bottomPane.getChildren().addAll(bottomBar, orderPane, listHamburguesas);
        borderPane.setBottom(bottomPane);

        // Sección central (contenido dinámico)
        Pane pnlMostrar = new Pane();
        pnlMostrar.setPrefSize(200, 200);
        borderPane.setCenter(pnlMostrar);
        
        // Acción para el botón "Hamburguesas clásicas"
        btnClasicas.setOnAction(event -> {
            pnlMostrar.getChildren().clear();
            ClasicasView clasicasView = new ClasicasView();
            AnchorPane clasicasPane = clasicasView.getClasicasPane();
            pnlMostrar.getChildren().add(clasicasPane);
            clasicasPane.setLayoutX((pnlMostrar.getWidth() - clasicasPane.getPrefWidth()) / 2 - 80);
        });
        
        // Acción para el botón "Premium"
        btnPremium.setOnAction(event -> {
            pnlMostrar.getChildren().clear();
            PremiumView premiumView = new PremiumView();
            AnchorPane premiumPane = premiumView.getPremiumPane();
            pnlMostrar.getChildren().add(premiumPane);
            premiumPane.setLayoutX((pnlMostrar.getWidth() - premiumPane.getPrefWidth()) / 2 - 80);
        });
        
        // Acción para el botón "Bebidas"
        btnBebidas.setOnAction(event -> {
            pnlMostrar.getChildren().clear();
            BebidasView bebidasView = new BebidasView();
            AnchorPane bebidasPane = bebidasView.getBebidasPane();
            pnlMostrar.getChildren().add(bebidasPane);
            bebidasPane.setLayoutX((pnlMostrar.getWidth() - bebidasPane.getPrefWidth()) / 2);
        });
        
        anchorPrincipal.getChildren().add(borderPane);
        Scene scene = new Scene(anchorPrincipal, 1152, 659);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sistema de Hamburguesas");
        primaryStage.show();
        

    }
}
