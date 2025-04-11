package com.burguerVent.presentacion.resumen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.application.Platform;
import com.burguerVent.presentacion.pago.PagoView;

@Component
public class ResumenPedidoController {
    @Autowired
    @Lazy
    private ResumenPedidoVista vista;

    @Autowired
    private PagoView pagoView;

    private ListView<String> listaPedidos;
    private Label precioTotalLabel;
    private ObservableList<String> items = FXCollections.observableArrayList();
    private double precioTotal = 0.0;

    public void setListaPedidos(ListView<String> listaPedidos) {
        this.listaPedidos = listaPedidos;
        this.listaPedidos.setItems(items);
    }

    public void setPrecioTotalLabel(Label precioTotalLabel) {
        this.precioTotalLabel = precioTotalLabel;
        actualizarPrecioTotal(this.precioTotal);
    }

    public void limpiarVista() {
        Platform.runLater(() -> {
            if (listaPedidos != null) {
                listaPedidos.getItems().clear();
            }
            if (precioTotalLabel != null) {
                precioTotalLabel.setText("$0.00");
            }
            items.clear();
            precioTotal = 0.0;
        });
    }

    public void mostrarVista() {
        vista.mostrar();
    }

    public void agregarItem(String item) {
        Platform.runLater(() -> {
            items.add(item);
            if (listaPedidos != null) {
                listaPedidos.setItems(items);
            }
        });
    }

    public void setPrecioTotal(double precio) {
        Platform.runLater(() -> {
            this.precioTotal = precio;
            actualizarPrecioTotal(precio);
        });
    }

    public void actualizarListaPedidos(Object pedidos) {
        Platform.runLater(() -> {
            if (listaPedidos != null) {
                listaPedidos.getItems().clear();
                if (pedidos != null) {
                    listaPedidos.getItems().add(pedidos.toString());
                }
            }
        });
    }

    public void actualizarPrecioTotal(double precioTotal) {
        Platform.runLater(() -> {
            if (precioTotalLabel != null) {
                precioTotalLabel.setText(String.format("$%.2f", precioTotal));
            }
        });
    }

    public void mostrarMensaje(String mensaje) {
        Platform.runLater(() -> {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setHeaderText(null);
            alert.setContentText(mensaje);
            alert.showAndWait();
        });
    }

    @FXML
    public void manejarPago() {
        Platform.runLater(() -> {
            System.out.println("Iniciando proceso de pago con monto: " + precioTotal);
            if (precioTotal <= 0) {
                mostrarMensaje("No hay productos en el carrito para pagar");
                return;
            }
            vista.cerrar();
            pagoView.setTotal(precioTotal);
            pagoView.mostrar();
        });
    }

    @FXML
    public void manejarRegreso() {
        Platform.runLater(() -> {
            limpiarVista();
            vista.mostrarMensaje("Regresando al menú principal");
            vista.cerrar();
        });
    }
} 