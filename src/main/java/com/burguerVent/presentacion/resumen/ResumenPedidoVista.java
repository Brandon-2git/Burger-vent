package com.burguerVent.presentacion.resumen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.geometry.Pos;

import java.io.IOException;

@Component
public class ResumenPedidoVista {
    @Autowired
    @Lazy
    private ResumenPedidoController controller;
    private Stage stage;
    private ListView<String> listaPedidos;
    private Label precioTotalLabel;

    public ResumenPedidoVista() {
        Platform.runLater(() -> {
            this.stage = new Stage();
            stage.setTitle("Resumen del Pedido");
            stage.setResizable(false);
        });
    }

    public void mostrar() {
        Platform.runLater(() -> {
            try {
                if (stage == null) {
                    this.stage = new Stage();
                    stage.setTitle("Resumen del Pedido");
                    stage.setResizable(false);
                }

                // Crear el layout principal
                AnchorPane anchorPane = new AnchorPane();
                anchorPane.setPrefSize(600, 400);

                // Panel principal naranja
                Pane mainPane = new Pane();
                mainPane.setStyle("-fx-background-color: f58629;");
                mainPane.setPrefSize(600, 400);
                mainPane.setMaxSize(600, 400);
                mainPane.setMinSize(600, 400);

                // Logo de fondo
                ImageView backgroundLogo = new ImageView();
                try {
                    Image logoImage = new Image(getClass().getResourceAsStream("/Images/Logo1.png"));
                    backgroundLogo.setImage(logoImage);
                    backgroundLogo.setFitHeight(379);
                    backgroundLogo.setFitWidth(491);
                    backgroundLogo.setLayoutX(58);
                    backgroundLogo.setLayoutY(35);
                    backgroundLogo.setOpacity(0.21);
                    backgroundLogo.setPreserveRatio(true);
                } catch (Exception e) {
                    System.err.println("No se pudo cargar el logo: " + e.getMessage());
                }

                // Título "Resumen"
                Label titleLabel = new Label("Resumen");
                titleLabel.setAlignment(Pos.CENTER);
                titleLabel.setLayoutX(138);
                titleLabel.setLayoutY(52);
                titleLabel.setPrefSize(189, 40);
                titleLabel.setStyle("-fx-background-color: #25a953; -fx-background-radius: 30;");
                titleLabel.setFont(Font.font("Arial Black", 27));

                // Bordes verdes
                Pane leftBorder = createBorderPane(14, 0, 13, 400);
                Pane rightBorder = createBorderPane(573, 0, 13, 400);
                Pane bottomBorder = createBorderPane(-1, 380, 608, 11);
                Pane topBorder = createBorderPane(0, 9, 600, 11);

                // Logo pequeño
                ImageView smallLogo = new ImageView();
                try {
                    Image logoImage = new Image(getClass().getResourceAsStream("/Images/Logo1.png"));
                    smallLogo.setImage(logoImage);
                    smallLogo.setFitHeight(116);
                    smallLogo.setFitWidth(141);
                    smallLogo.setLayoutX(413);
                    smallLogo.setLayoutY(30);
                    smallLogo.setOpacity(0.67);
                    smallLogo.setPreserveRatio(true);
                } catch (Exception e) {
                    System.err.println("No se pudo cargar el logo pequeño: " + e.getMessage());
                }

                // Lista de pedidos
                listaPedidos = new ListView<>();
                listaPedidos.setLayoutX(60);
                listaPedidos.setLayoutY(113);
                listaPedidos.setPrefSize(322, 219);
                listaPedidos.setStyle("-fx-background-color: e9db09;");

                // Botones
                Button btnRegresar = new Button("REGRESAR");
                btnRegresar.setLayoutX(436);
                btnRegresar.setLayoutY(253);
                btnRegresar.setPrefSize(96, 37);
                btnRegresar.setOnAction(e -> controller.manejarRegreso());

                Button btnPagar = new Button("PAGAR");
                btnPagar.setLayoutX(433);
                btnPagar.setLayoutY(170);
                btnPagar.setPrefSize(96, 37);
                btnPagar.setOnAction(e -> controller.manejarPago());

                // Labels de precio
                Label precioLabel = new Label("Precio Total:");
                precioLabel.setLayoutX(79);
                precioLabel.setLayoutY(341);
                precioLabel.setPrefSize(106, 27);
                precioLabel.setFont(Font.font("System", FontWeight.BOLD, 18));

                precioTotalLabel = new Label("$");
                precioTotalLabel.setLayoutX(195);
                precioTotalLabel.setLayoutY(338);
                precioTotalLabel.setPrefSize(177, 32);
                precioTotalLabel.setFont(Font.font("System", FontWeight.BOLD, 22));

                // ScrollBar
                ScrollBar scrollBar = new ScrollBar();
                scrollBar.setLayoutX(367);
                scrollBar.setLayoutY(113);
                scrollBar.setOrientation(javafx.geometry.Orientation.VERTICAL);
                scrollBar.setPrefSize(14, 219);

                // Agregar todos los elementos al panel principal
                mainPane.getChildren().addAll(
                    backgroundLogo, titleLabel, leftBorder, rightBorder,
                    bottomBorder, topBorder, smallLogo, listaPedidos,
                    btnRegresar, btnPagar, precioLabel, precioTotalLabel, scrollBar
                );

                // Agregar el panel principal al AnchorPane
                anchorPane.getChildren().add(mainPane);

                Scene scene = new Scene(anchorPane);
                stage.setScene(scene);
                stage.show();
                stage.toFront();

                // Dar acceso al controlador a los elementos de la UI
                controller.setListaPedidos(listaPedidos);
                controller.setPrecioTotalLabel(precioTotalLabel);

            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Error al crear la vista de resumen: " + e.getMessage());
                if (controller != null) {
                    controller.mostrarMensaje("Error al abrir la ventana de resumen: " + e.getMessage());
                }
            }
        });
    }

    private Pane createBorderPane(double x, double y, double width, double height) {
        Pane border = new Pane();
        border.setLayoutX(x);
        border.setLayoutY(y);
        border.setPrefSize(width, height);
        border.setStyle("-fx-background-color: #25a953;");
        return border;
    }

    public void actualizarListaPedidos(Object pedidos) {
        if (controller != null) {
            Platform.runLater(() -> {
                controller.actualizarListaPedidos(pedidos);
            });
        }
    }

    public void actualizarPrecioTotal(double precioTotal) {
        if (controller != null) {
            Platform.runLater(() -> {
                controller.actualizarPrecioTotal(precioTotal);
            });
        }
    }

    public void mostrarMensaje(String mensaje) {
        if (controller != null) {
            Platform.runLater(() -> {
                controller.mostrarMensaje(mensaje);
            });
        }
    }

    public void cerrar() {
        if (stage != null) {
            stage.close();
        }
    }
} 