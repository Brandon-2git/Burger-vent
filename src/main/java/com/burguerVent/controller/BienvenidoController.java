
package com.burguerVent.controller;


import com.burguerVent.view.MenuView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import org.springframework.stereotype.Controller;

@Controller
public class BienvenidoController {
    private Stage primaryStage;

    public BienvenidoController(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    
    public EventHandler<ActionEvent> handleComenzarButton() {
        return event -> {
            MenuView menuView = new MenuView();
            Stage stage = new Stage();
            try {
                menuView.start(stage);
                primaryStage.close(); // Cerrar la ventana actual
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }

}
