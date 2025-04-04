package com.burguerVent.presentacion.Admin;

import com.burguerVent.presentacion.bienvenido.BienvenidoController;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminAcceso {
    // Credenciales predefinidas
    private final String usuarioCorrecto = "admin";
    private final String contraseñaCorrecta = "1234";
    
    // Elementos de la interfaz
    private TextField textFieldUser;
    private PasswordField passwordField;
    private Button btnAcceso;
  
    @Autowired
    private BienvenidoController controlBienvenido;
    
    private AdminAccesoController controlAcceso;
    private Stage stage;
    private boolean initialized = false;

    public AdminAcceso() {
        // Constructor vacío
    }

    private void initializeUI() {
         if (initialized) return;
        if (!Platform.isFxApplicationThread()) {
            Platform.runLater(this::initializeUI);
            return;
        }

        stage = new Stage();
        stage.setTitle("Inicio de Sesión");

        // Crear el AnchorPane
        AnchorPane root = new AnchorPane();
        root.setStyle("-fx-background-color: orange;");
        // Crear el botón "Regresar" en la parte superior izquierda
        Button btnRegresar = new Button("⬅");
        btnRegresar.setLayoutX(10);
        btnRegresar.setLayoutY(10);
        btnRegresar.setStyle("-fx-background-color: red; -fx-text-fill: white;");
        
        /*Estos son solo eventos al posicionar el mouse y que cambien de color*/
        btnRegresar.setOnMouseEntered(event -> {
            btnRegresar.setStyle("-fx-background-color: #FF6347; -fx-text-fill: black;");
        });
        btnRegresar.setOnMouseExited(event -> {
            btnRegresar.setStyle("-fx-background-color: red; -fx-text-fill: white;");
        });
        /*Accion para volver a la pantalla de bienvenido por si el admin no quiere acceder*/
        btnRegresar.setOnAction(event -> {

            controlBienvenido.inicia(); // Esto abrirá una nueva ventana para el menú
            stage.close();
        });

    

        // Crear el Pane con color de fondo
        Pane pane = new Pane();
        pane.setLayoutX(46.0);
        pane.setLayoutY(41.0);
        pane.setPrefHeight(314.0);
        pane.setPrefWidth(351.0);
        pane.setStyle("-fx-background-color: #FF8C00;");

        // Crear el icono de perfil
        Label labelIcon = new Label("  👤");
        labelIcon.setLayoutX(34.0);
        labelIcon.setLayoutY(29.0);
        labelIcon.setPrefHeight(25.0);
        labelIcon.setPrefWidth(28.0);
        labelIcon.setStyle("-fx-background-radius: 50%; -fx-background-color: #E65100;");

        // Crear el texto "Inicio de sesión"
        Label labelTitle = new Label("Inicio de sesión");
        labelTitle.setLayoutX(69.0);
        labelTitle.setLayoutY(33.0);

        // Crear el campo de texto para el usuario
        Label labelUser = new Label("Usuario");
        labelUser.setLayoutX(32.0);
        labelUser.setLayoutY(101.0);
        labelUser.setPrefHeight(17.0);
        labelUser.setPrefWidth(61.0);

        textFieldUser = new TextField();
        textFieldUser.setLayoutX(110.0);
        textFieldUser.setLayoutY(97.0);

        // Crear el campo de texto para la contraseña
        Label labelPassword = new Label("Contraseña");
        labelPassword.setLayoutX(27.0);
        labelPassword.setLayoutY(145.0);
        labelPassword.setPrefHeight(17.0);
        labelPassword.setPrefWidth(61.0);

        passwordField = new PasswordField();
        passwordField.setLayoutX(110.0);
        passwordField.setLayoutY(141.0);

        // Botón de acceso
        btnAcceso = new Button("Acceder");
        btnAcceso.setLayoutX(259.0);
        btnAcceso.setLayoutY(243.0);
        btnAcceso.setStyle("-fx-background-color: red; -fx-text-fill: white;");
        btnAcceso.setOnAction(event -> autenticarUsuario());
        
        /*Estos son solo eventos al posicionar el mouse y que cambien de color*/
        btnAcceso.setOnMouseEntered(event -> {
            btnAcceso.setStyle("-fx-background-color: #FF6347; -fx-text-fill: black;");
        });
        btnAcceso.setOnMouseExited(event -> {
            btnAcceso.setStyle("-fx-background-color: red; -fx-text-fill: white;");
        });

        // Crear el título "BurguerVent"
        Label labelBurguerVent = new Label("BurguerVent");
        labelBurguerVent.setFont(Font.font("System Bold", 21));
        labelBurguerVent.setAlignment(Pos.CENTER);
        labelBurguerVent.setLayoutX(150.0);
        labelBurguerVent.setLayoutY(9.0);
        labelBurguerVent.setStyle("-fx-text-fill: white;");

        // Agregar todos los elementos al Pane
        pane.getChildren().addAll(labelIcon, labelTitle, labelUser, textFieldUser, labelPassword, passwordField, btnAcceso);

        // Agregar el Pane y el título al AnchorPane
        root.getChildren().addAll(pane, labelBurguerVent, btnRegresar);

        // Crear la escena y mostrarla
        Scene scene = new Scene(root, 451.0, 400);
        stage.setScene(scene);
        initialized = true;
    }
    
        private void autenticarUsuario() {
        String usuarioIngresado = textFieldUser.getText();
        String contraseñaIngresada = passwordField.getText();

        if (usuarioIngresado.equals(usuarioCorrecto) && contraseñaIngresada.equals(contraseñaCorrecta)) {
            mostrarAlerta("Acceso permitido", "Bienvenido, " + usuarioCorrecto, Alert.AlertType.INFORMATION);
        } else {
            mostrarAlerta("Acceso denegado", "Usuario o contraseña incorrectos", Alert.AlertType.ERROR);
        }
    }

    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    public void muestra(AdminAccesoController control) {
        this.controlAcceso = control;
        if (!Platform.isFxApplicationThread()) {
            Platform.runLater(() -> this.muestra(control));
            return;
        }
            initializeUI();
            stage.show();
    }
}

