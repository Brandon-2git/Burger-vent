
package com.burguerVent.presentacion.InterfazAdmin;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;
/**
 *
 */
@Component
public class InterfazAdmin {
    private Stage adminStage;
    private boolean adminInitialized = false;
    
    private InterfazAdminController AdminUiController;
    
    
    
    private void initializeUI() {
    if (adminInitialized) {
        return;
    }
    if (!Platform.isFxApplicationThread()) {
        Platform.runLater(this::initializeUI);
        return;
    }

    adminStage = new Stage();
    adminStage.setTitle("Panel de Administrador");

    // Root AnchorPane
    AnchorPane root = new AnchorPane();
    root.setPrefSize(958, 465);
    root.setStyle("-fx-background-color: orange;");

    // BorderPane (puedes añadirle contenido luego si es necesario)
    BorderPane adminPanel = new BorderPane();
    adminPanel.setId("adminPanel");
    root.getChildren().add(adminPanel);

    // HBox con Label
    HBox hBox = new HBox(20);
    hBox.setLayoutX(61.0);
    hBox.setLayoutY(65.0);
    hBox.setAlignment(Pos.CENTER_LEFT);
    hBox.setStyle("-fx-background-color: #ff6347; -fx-padding: 10;");
    Label lblAdmin = new Label(" 👤Administrador");
    lblAdmin.setStyle("-fx-font-size: 20px; -fx-text-fill: white;");
    hBox.getChildren().add(lblAdmin);

    // VBox con botones
    VBox vBox = new VBox(10);
    vBox.setLayoutX(47.0);
    vBox.setLayoutY(130.0);
    vBox.setPrefWidth(200.0);
    vBox.setStyle("-fx-padding: 15;");

    Button btnVerPedidos = new Button("📋 Ver Pedidos");
    btnVerPedidos.setPrefWidth(180);

    Button btnDeshabilitarProducto = new Button("🛑 Deshabilitar Producto");
    btnDeshabilitarProducto.setPrefWidth(180);

    Button btnModificarPrecios = new Button("💰 Modificar Precios");
    btnModificarPrecios.setPrefWidth(180);

    Button btnCerrarSesion = new Button("🔓 Cerrar Sesión");
    btnCerrarSesion.setPrefWidth(180);
    btnCerrarSesion.setOnAction(event -> {
        adminStage.close();
    });

    vBox.getChildren().addAll(
        btnVerPedidos,
        btnDeshabilitarProducto,
        btnModificarPrecios,
        btnCerrarSesion
    );

    // Pane blanco central
    Pane contentPane = new Pane();
    contentPane.setLayoutX(285.0);
    contentPane.setLayoutY(52.0);
    contentPane.setPrefSize(598.0, 354.0);
    contentPane.setStyle("-fx-background-color: white;");
    
    //accion del bton ver pedidos
    btnVerPedidos.setOnAction(event -> {
        // Limpiar el panel antes de agregar la vista de los pedidos
        contentPane.getChildren().clear();
        // Crear una nueva instancia de la clase donde se tiene el pane
        OpcionesInterfaz pedidos = new OpcionesInterfaz();
        pedidos.setMenuController(AdminUiController);
        //ahora obtenemos el pane de la clase
        Pane pedidosPane = pedidos.getPedidosPane();
        contentPane.getChildren().add(pedidosPane);
    });

    // Agregar nodos al root
    root.getChildren().addAll(hBox, vBox, contentPane);

    Scene scene = new Scene(root);
    adminStage.setScene(scene);
    adminInitialized = true;
}

public void muestraAdmin(InterfazAdminController control) {
    this.AdminUiController = control;
    if (!Platform.isFxApplicationThread()) {
        Platform.runLater(() -> this.muestraAdmin(control));
        return;
    }
        initializeUI();
        adminStage.show();
    }
}
