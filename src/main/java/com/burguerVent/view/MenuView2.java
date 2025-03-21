/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.burguerVent.view;
import com.burguerVent.model.Producto;
import com.burguerVent.view.com.burguerVent.detalles.view.Arrachera;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MenuView2 extends Application {
	
	   // Lista para almacenar los productos agregados al carrito (orden)
		 private List<Producto> orden = new ArrayList<>();
		 private ListView<String> listHamburguesas; // Referencia al ListView existente
    
   @Override
public void start(Stage primaryStage) {
    // Crear el contenedor principal
    AnchorPane root = new AnchorPane();
    root.setStyle("-fx-background-color: #FF4500;");
    root.setPrefSize(1152, 659);

    // Panel 1 - Hamburguesa de Arrachera
    Pane pane1 = createPane(30, 59, "Hamburguesa de Arrachera", "Images/arrachera.jpg","verDetalles1",55);
    root.getChildren().add(pane1);

    // Panel 2 - Hamburguesa de Pollo
    Pane pane2 = createPane(275, 59, "Hamburguesa de Pollo", "Images/pollo.jpg","verDetalles2",55);
    root.getChildren().add(pane2);

    // Panel 3 - Hamburguesa de Res
    Pane pane3 = createPane(518, 59, "Hamburguesa de Res", "Images/res.jpg","verDetalles3",67);
    root.getChildren().add(pane3);

    // Lista de hamburguesas
    //ListView<String> listHamburguesas = new ListView<>();
    listHamburguesas = new ListView<>(); 
    listHamburguesas.setLayoutX(309);
    listHamburguesas.setLayoutY(428);
    listHamburguesas.setPrefSize(771, 123);
    root.getChildren().add(listHamburguesas);

    // Panel inferior - Total y Mi orden
    Pane bottomPane = new Pane();
    bottomPane.setLayoutX(309);
    bottomPane.setLayoutY(382);
    bottomPane.setPrefSize(771, 32);
    bottomPane.setStyle("-fx-background-color: gray;");
    
    Label lblMiOrden = new Label("Mi orden");
    lblMiOrden.setLayoutX(40);
    lblMiOrden.setLayoutY(6);
    lblMiOrden.setFont(new Font("System Bold", 15));
    lblMiOrden.setStyle("-fx-text-fill: white;");
    
    Label lblTotal = new Label("Total:");
    lblTotal.setLayoutX(596);
    lblTotal.setLayoutY(7);
    lblTotal.setStyle("-fx-text-fill: white;");
    
    Label txtTotal = new Label();
    txtTotal.setLayoutX(643);
    txtTotal.setLayoutY(8);
    txtTotal.setPrefSize(99, 18);
    txtTotal.setStyle("-fx-background-color: white; -fx-border-color: gray;");
    txtTotal.setId("txtTotal");  // Asegúrate de asignar el ID
    
    bottomPane.getChildren().addAll(lblMiOrden, lblTotal, txtTotal);
    root.getChildren().add(bottomPane);

    // Botón Siguiente
    Button btnSiguiente = new Button("Comprar");
    btnSiguiente.setLayoutX(1001);
    btnSiguiente.setLayoutY(572);
    root.getChildren().add(btnSiguiente);

    // Mostrar la ventana
    Scene scene = new Scene(root);
    primaryStage.setTitle("Menú de Hamburguesas");
    primaryStage.setScene(scene);
    primaryStage.show();
}

private Pane createPane(double x, double y, String title, String imagePath, String buttonId, double precio) {
    // Crear un panel para la hamburguesa
    Pane pane = new Pane();
    pane.setLayoutX(x);
    pane.setLayoutY(y);
    pane.setPrefSize(225, 200);
    pane.setStyle("-fx-background-color: #FFA500;");
    
    // Label para el nombre de la hamburguesa
    Label label = new Label(title);
    label.setLayoutX(28);
    label.setLayoutY(6);
    label.setFont(new Font("System Bold", 12));
    label.setStyle("-fx-text-fill: white;");
    
    // Imagen de la hamburguesa
    ImageView imageView = new ImageView(new Image(imagePath));
    imageView.setFitWidth(197);
    imageView.setFitHeight(117);
    imageView.setLayoutX(14);
    imageView.setLayoutY(32);
    
    // Botón para agregar la hamburguesa
    Button btnAgregar = new Button("Agregar");
    btnAgregar.setLayoutX(28);
    btnAgregar.setLayoutY(161);
    
 // Agregar manejador de eventos para el botón "Agregar"
    btnAgregar.setOnAction(e -> {
        // Crear el producto con los detalles
        Producto producto = new Producto();
        producto.setNombre(title);
        producto.setPrecio(precio);  // El precio puede ser ajustado

        // Agregar el producto a la lista de orden
        orden.add(producto);

        // Actualizar la lista de hamburguesas en la interfaz
        actualizarLista();
    });
    
    
    
    // Botón para ver los detalles
    Button btnDetalles = new Button("Ver Detalles");
    btnDetalles.setLayoutX(125);
    btnDetalles.setLayoutY(161); // Asignar el ID correspondiente
    btnDetalles.setId(buttonId); // Asignar el ID correspondiente

    
    // Agregar manejador de eventos para los botones de detalles
        btnDetalles.setOnAction(e -> {
            if ("verDetalles1".equals(buttonId)) {
                // Solo abre la ventana de detalles de la Arrachera
                Arrachera arracheraView = new Arrachera();
                Stage arracheraStage = new Stage();
                try {
                    arracheraView.start(arracheraStage);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else if ("verDetalles2".equals(buttonId)) {
                // Lógica para la vista de detalles de la Hamburguesa de Pollo
                // Similar a la acción de Arrachera pero con la vista correspondiente
                System.out.println("Ver detalles de la Hamburguesa de Pollo");
            } else if ("verDetalles3".equals(buttonId)) {
                // Lógica para la vista de detalles de la Hamburguesa de Res
                // Similar a la acción de Arrachera pero con la vista correspondiente
                System.out.println("Ver detalles de la Hamburguesa de Res");
            }
        });
    
    // Añadir todos los elementos al panel
    pane.getChildren().addAll(label, imageView, btnAgregar, btnDetalles);
    
    return pane;
}
private void actualizarLista() {
	 // Crear la lista de nombres de productos para mostrar en el ListView
	
 List<String> nombresProductos = new ArrayList<>();

 for (Producto producto : orden) {
    // nombresProductos.add(producto.getNombre());
	 nombresProductos.add(producto.getNombre() + " ($" + producto.getPrecio() + ")");
	
 }

 // Actualizar el ListView con los nombres de los productos
 listHamburguesas.getItems().setAll(nombresProductos);
 

 
 }
  
}



