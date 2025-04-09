package com.burguerVent.presentacion.recibirpedidos;

import org.springframework.stereotype.Component;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

@Component
public class VentanaDetalles {

	private Stage stage;

    public void mostrarVentana(String mensaje) {
        stage = new Stage();
        stage.setTitle("Nuevo Pedido");

        Label label = new Label(mensaje);
        
        VBox layout = new VBox(10);
        layout.getChildren().add(label);
        
        Scene scene = new Scene(layout, 300, 100);
        stage.setScene(scene);
        stage.show();
    }
}
