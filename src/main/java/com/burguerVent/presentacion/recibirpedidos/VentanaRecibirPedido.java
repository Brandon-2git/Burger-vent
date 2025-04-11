package com.burguerVent.presentacion.recibirpedidos;

import java.util.List;

import org.springframework.stereotype.Component;

import com.burguerVent.negocio.modelo.Pedido;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

@Component
public class VentanaRecibirPedido {

	private Stage stage;
	private ControlRecibirPedido control;
	private boolean initialized = false;
	private TableView<Pedido> tablaPedidos;
    private ObservableList<Pedido> pedidos;
    
    
    public VentanaRecibirPedido() {
		
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
	    stage.setTitle("Sistema de hamburguesas");

	    // === Texto principal "Pedidos" ===
	    javafx.scene.text.Text titulo = new javafx.scene.text.Text("Pedidos");
	    titulo.setFont(new Font("Pristina", 40));
	    titulo.setLayoutX(291); //241
	    titulo.setLayoutY(44);
	    titulo.setWrappingWidth(110);
	    
	    // === Imagen en la esquina superior izquierda ===
       // Image logo = new Image("ruta/a/tu/imagen/logo.png"); // Reemplaza con la ruta de la imagen
	 // === Imagen en la esquina superior derecha ===
	    ImageView imageView1 = new ImageView(new Image(getClass().getResourceAsStream("/Images/Logo1.png")));
	    imageView1.setFitHeight(90.0);  // Ajusta el tamaño de la imagen
	    imageView1.setFitWidth(90.0);   // Ajusta el tamaño de la imagen

	    // Coloca la imagen en la esquina superior derecha con un margen de 10 píxeles
	    imageView1.setLayoutX(702- imageView1.getFitWidth() - 10);  // 702 es el ancho del AnchorPane
	    imageView1.setLayoutY(0);  // Posición vertical (10px desde la parte superior)

	    // === Tabla de pedidos ===
	    tablaPedidos = new TableView<>();
	    tablaPedidos.setLayoutX(56);
	    tablaPedidos.setLayoutY(95);
	    tablaPedidos.setPrefSize(580, 269);
	    tablaPedidos.setStyle("-fx-background-color: #FFF8F0;");
	    pedidos = FXCollections.observableArrayList();
	    tablaPedidos.setItems(pedidos);

	    TableColumn<Pedido, Long> columnaId = new TableColumn<>("numero de pedido");
	    columnaId.setCellValueFactory(new PropertyValueFactory<>("idPedido"));
	    columnaId.setPrefWidth(182);

	    TableColumn<Pedido, String> columnaProductos = new TableColumn<>("lista de productos");
	    columnaProductos.setPrefWidth(423);
	    
	    columnaProductos.setCellValueFactory(cellData -> 
	    new SimpleStringProperty(control.cantidadproducto(cellData.getValue().getProductos()).toString())
	);

	    
	    columnaProductos.setCellFactory(column -> new TableCell<>() {
            private final Text text = new Text();

            {
                text.wrappingWidthProperty().bind(column.widthProperty().subtract(10));
                text.setStyle("-fx-font-size: 14px;");
            }

            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null);
                } else {
                    text.setText(item);
                    setGraphic(text);
                    setPrefHeight(text.getLayoutBounds().getHeight() + 20);
                }
            }
        });

        columnaProductos.setPrefWidth(400);

	    tablaPedidos.getColumns().addAll(columnaId, columnaProductos);

	    // === AnchorPane como en el FXML ===
	    AnchorPane anchor = new AnchorPane();
	    anchor.setPrefSize(702, 439);
	    anchor.setStyle("-fx-background-color: #FF8C00;");
	    anchor.getChildren().addAll(titulo, tablaPedidos, imageView1);

	    Scene scene = new Scene(anchor);
	    stage.setScene(scene);

	    initialized = true;
	}
	
	public void muestra(ControlRecibirPedido control) {
		this.control = control;
		
		if (!Platform.isFxApplicationThread()) {
			Platform.runLater(() -> this.muestra(control));
			return;
		}
		
		initializeUI();
		stage.show();
	}

	 public void mostrarPedidos(List<Pedido> listaPedidos) {
	        pedidos.setAll(listaPedidos);  // Actualiza la lista observable de pedidos
	}
}

