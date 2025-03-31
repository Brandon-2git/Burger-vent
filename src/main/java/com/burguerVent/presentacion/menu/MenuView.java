package com.burguerVent.presentacion.menu;



import com.burguerVent.presentacion.productos.ProductosView;
import javafx.application.Platform;
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


import org.springframework.stereotype.Component;



@Component
public class MenuView {
 
    private ListView<String> listHamburguesas;

    private MenuController menuController;
    

    private Button btnClasicas;
    private Button btnPremium;
    private Button btnBebidas;
    private Pane pnlMostrar; // Se usará para asignarlo a MenuController
    private Stage stage;
    private boolean initialized = false;
    
    private Label txtTotal;

    public MenuView() {
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
        stage.setTitle("Menú");

        AnchorPane anchorPrincipal = new AnchorPane();
        anchorPrincipal.setPrefSize(1152, 659);
        anchorPrincipal.setStyle("-fx-background-color: white;");

        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(200, 200);
        AnchorPane.setTopAnchor(borderPane, 0.0);
        AnchorPane.setBottomAnchor(borderPane, 0.0);
        AnchorPane.setLeftAnchor(borderPane, 0.0);
        AnchorPane.setRightAnchor(borderPane, 0.0);

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

        AnchorPane leftPane = new AnchorPane();
        leftPane.setPrefSize(180, 436);
        leftPane.setStyle("-fx-background-color: orange;");

        VBox menuBox = new VBox();
        menuBox.setPrefSize(180, 356);
        AnchorPane.setTopAnchor(menuBox, 68.0);
        AnchorPane.setBottomAnchor(menuBox, 170.0);

        btnClasicas = new Button("Hamburguesas clásicas");
        btnPremium = new Button("Hamburguesas Premium");
        btnBebidas = new Button("Bebidas");

        for (Button btn : new Button[]{btnClasicas, btnPremium, btnBebidas}) {
            btn.setPrefSize(180, 35);
            btn.setStyle("-fx-background-color: -fx-text-fill: white; -fx-border-radius: 5px; -fx-border-color: white;");
            btn.setFont(new Font("System Bold", 12));
        }

        menuBox.getChildren().addAll(btnClasicas, btnPremium, btnBebidas);
        leftPane.getChildren().add(menuBox);
        borderPane.setLeft(leftPane);

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

        //Label txtTotal = new Label();
        txtTotal = new Label();
        txtTotal.setLayoutX(728);
        txtTotal.setLayoutY(4);
        txtTotal.setPrefSize(99, 18);
        txtTotal.setStyle("-fx-background-color: white; -fx-border-color: gray;");

        Button btnComprar = new Button("Comprar");
        btnComprar.setLayoutX(895);
        btnComprar.setLayoutY(1);
        btnComprar.setStyle("-fx-background-color: #87CEEB; -fx-border-radius: 5px;");

        orderPane.getChildren().addAll(lblMiOrden, lblTotal, txtTotal, btnComprar);
        
        
        btnComprar.setOnAction(e -> menuController.finalizarPedido());
       

        listHamburguesas = new ListView<>();
        listHamburguesas.setLayoutX(179.2);
        listHamburguesas.setLayoutY(31.2);
        listHamburguesas.setPrefSize(973, 126);
        listHamburguesas.setStyle("-fx-border-radius: 10px;");

        bottomPane.getChildren().addAll(bottomBar, orderPane, listHamburguesas);
        borderPane.setBottom(bottomPane);

        pnlMostrar = new Pane();
        pnlMostrar.setPrefSize(200, 200);
        borderPane.setCenter(pnlMostrar);

        // Asignar eventos a los botones
        btnClasicas.setOnAction(event -> {
            // Limpiar el panel antes de agregar la vista
            pnlMostrar.getChildren().clear();
            // Crear una nueva instancia de la vista ClasicasView
            ProductosView  clasicasView = new ProductosView();
            clasicasView.setMenuController(menuController);
            // Obtener el AnchorPane de la vista
            AnchorPane clasicasPane = clasicasView.getClasicasPane();
            // Agregar la vista al panel
            pnlMostrar.getChildren().add(clasicasPane);
            // Centrar el AnchorPane dentro del panel
            clasicasPane.setLayoutX((pnlMostrar.getWidth() - clasicasPane.getPrefWidth()) / 2 - 80);
        });

        btnPremium.setOnAction(event -> {
            // Limpiar el panel antes de agregar la vista
            pnlMostrar.getChildren().clear();
            ProductosView  premiumView = new ProductosView();
            premiumView.setMenuController(menuController);
            AnchorPane premiumPane = premiumView.getPremiumPane();
            pnlMostrar.getChildren().add(premiumPane);
            premiumPane.setLayoutX((pnlMostrar.getWidth() - premiumPane.getPrefWidth()) / 2 - 80);
        });

        btnBebidas.setOnAction(event -> {
            pnlMostrar.getChildren().clear();
            ProductosView  bebidasView = new ProductosView();
            bebidasView.setMenuController(menuController);
            AnchorPane bebidasPane = bebidasView.getBebidasPane();
            pnlMostrar.getChildren().add(bebidasPane);
            bebidasPane.setLayoutX((pnlMostrar.getWidth() - bebidasPane.getPrefWidth()) / 2);
        });
       
        anchorPrincipal.getChildren().add(borderPane);
        Scene scene = new Scene(anchorPrincipal, 1152, 659);
        stage.setScene(scene);
        stage.setTitle("Sistema de Hamburguesas");
        initialized = true;
    }

    public void muestra(MenuController control) {
        this.menuController = control;
        if (!Platform.isFxApplicationThread()) {
            Platform.runLater(() -> this.muestra(control));
            return;
        }
        initializeUI();

        stage.show();
        
        menuController.setListHamburguesas(listHamburguesas);
        menuController.setTxtTotal(txtTotal);
    }
    
        
}


//        
//        menuController.setListHamburguesas(listHamburguesas);
//        
//        menuController.setPnlMostrar(pnlMostrar);
//        menuController.setListHamburguesas(listHamburguesas);
//        
//        menuController.setTxtTotal(txtTotal);
