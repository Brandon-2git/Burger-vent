package com.burguerVent.controller;

import com.burguerVent.view.categorias.BebidasView;
import com.burguerVent.view.categorias.ClasicasView;
import com.burguerVent.view.categorias.PremiumView;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.springframework.stereotype.Controller;

@Controller
public class MenuController {
    @FXML
    private Pane pnlMostrar;

    // Método para inyectar pnlMostrar desde MenuView
    public void setPnlMostrar(Pane pnlMostrar) {
        this.pnlMostrar = pnlMostrar;
    }

    public void mostrarClasicas() {
        if (pnlMostrar == null) {
            System.err.println("Error: pnlMostrar no ha sido inicializado.");
            return;
        }
        pnlMostrar.getChildren().clear();
        ClasicasView clasicasView = new ClasicasView();
        AnchorPane clasicasPane = clasicasView.getClasicasPane();
        pnlMostrar.getChildren().add(clasicasPane);
        clasicasPane.setLayoutX((pnlMostrar.getWidth() - clasicasPane.getPrefWidth()) / 2 - 80);
    }

    public void mostrarPremium() {
        if (pnlMostrar == null) {
            System.err.println("Error: pnlMostrar no ha sido inicializado.");
            return;
        }
        pnlMostrar.getChildren().clear();
        PremiumView premiumView = new PremiumView();
        AnchorPane premiumPane = premiumView.getPremiumPane();
        pnlMostrar.getChildren().add(premiumPane);
        premiumPane.setLayoutX((pnlMostrar.getWidth() - premiumPane.getPrefWidth()) / 2 - 80);
    }

    public void mostrarBebidas() {
        if (pnlMostrar == null) {
            System.err.println("Error: pnlMostrar no ha sido inicializado.");
            return;
        }
        pnlMostrar.getChildren().clear();
        BebidasView bebidasView = new BebidasView();
        AnchorPane bebidasPane = bebidasView.getBebidasPane();
        pnlMostrar.getChildren().add(bebidasPane);
        bebidasPane.setLayoutX((pnlMostrar.getWidth() - bebidasPane.getPrefWidth()) / 2);
    }
}



