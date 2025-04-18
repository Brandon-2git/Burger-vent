package com.burguerVent.presentacion.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.burguerVent.negocio.ServiceProducto;
import com.burguerVent.negocio.modelo.Producto;
import com.burguerVent.presentacion.resumen.ResumenPedidoController;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.application.Platform;

@Component
public class MenuController {
    
    @Autowired
    private MenuView menuView;
    
    @Autowired
    private ResumenPedidoController resumenPedidoController;
    
    @Autowired
    private ServiceProducto serviceproducto;
    
    private ListView<String> listHamburguesas;
    private Label txtTotal;

    public void inicia() {
        menuView.muestra(this);
    }

    public void setListHamburguesas(ListView<String> listHamburguesas) {
        this.listHamburguesas = listHamburguesas;
        this.listHamburguesas.setItems(serviceproducto.obtenerItemsOrden());
    }

    public void agregarClasica(Producto producto) {
        serviceproducto.agregarProducto(producto);
        actualizarTotal();
    }
    
    public void agregarPremium(Producto producto) {
        serviceproducto.agregarProducto(producto);
        actualizarTotal();
    }
    
    public void agregarBebidas(Producto producto) {
        serviceproducto.agregarProducto(producto);
        actualizarTotal();
    }
    
    public void setTxtTotal(Label txtTotal) {
        this.txtTotal = txtTotal;
    }
    
    public void actualizarTotal() {
        double total = serviceproducto.obtenerTotal();
        txtTotal.setText(String.format("%.2f", total));
    }
    
    public void cancelarpedido() {
        serviceproducto.cancelarPedido();
        	 actualizarTotal();
        }
        
        public void eliminarProducto(String nombre) {
            serviceproducto.eliminarProducto(nombre);
            actualizarTotal();
        }
        
        
    
    public void finalizarPedido() {
        Platform.runLater(() -> {
            var items = serviceproducto.obtenerItemsOrden();
            double total = serviceproducto.obtenerTotal();
            
            if (items != null && !items.isEmpty()) {
                // Limpiar la vista anterior
                resumenPedidoController.limpiarVista();
                
                // Mostrar la vista de resumen
                resumenPedidoController.mostrarVista();
                
                // Agregar los items al resumen
                for (String item : items) {
                    resumenPedidoController.agregarItem(item);
                }
                resumenPedidoController.setPrecioTotal(total);
                
                // Guardar el pedido y limpiar la vista actual
                serviceproducto.guardarPedido();
                txtTotal.setText("0.00");
                serviceproducto.limpiarOrden();
                listHamburguesas.getItems().clear();
            } else {
                resumenPedidoController.mostrarMensaje("No hay items en el pedido");
            }
        });
    }
    
    public void aumentarCantidad(String nombre) {
        serviceproducto.aumentarCantidad(nombre);
        actualizarTotal();
    }
    
    public void disminuirCantidad(String nombre) {
        serviceproducto.disminuirCantidad(nombre); // Llama al método del servicio
        actualizarTotal(); // Actualiza el total en pantalla
    }
    
   }


//	
//	 

//    private List<Producto> orden = new ArrayList<>();
//    private ListView<String> listHamburguesas;
//    private ObservableList<String> itemsOrden = FXCollections.observableArrayList();
//    private double totalOrden = 0.0;
//    private Label txtTotal; // Referencia al Label del total
//
//
//    public void setListHamburguesas(ListView<String> listHamburguesas) {
//        this.listHamburguesas = listHamburguesas;
//        this.listHamburguesas.setItems(itemsOrden); // Enlazar la lista observable al ListView
//    }
//    

//    
//    public void agregarClasica(Producto producto) {
//    	 orden.add(producto);	
//    	//itemsOrden.add(producto.getNombre() + " - $" + producto.getPrecio()); // Agregar a la lista observable
//    	 actualizarItemsOrden(producto);
//    	 totalOrden += producto.getPrecio(); // Sumar el precio
//   	    actualizarTotal(); // Actualizar la etiqueta del total
//    }
//    
//    public void agregarPremium(Producto producto) {
//   	 orden.add(producto);	
//   	//itemsOrden.add(producto.getNombre() + " - $" + producto.getPrecio()); // Agregar a la lista observable
//    actualizarItemsOrden(producto);
//   	totalOrden += producto.getPrecio(); // Sumar el precio
//    actualizarTotal(); // Actualizar la etiqueta del total
//   }
//    
//    public void agregarbebidas(Producto producto) {
//      	 orden.add(producto);	
//      	//itemsOrden.add(producto.getNombre() + " - $" + producto.getPrecio()); // Agregar a la lista observable
//      	 actualizarItemsOrden(producto);
//      	totalOrden += producto.getPrecio(); // Sumar el precio
//	    actualizarTotal(); // Actualizar la etiqueta del total
//      }
//
//    
//    private void actualizarTotal() {
//        txtTotal.setText(String.format("$%.2f", totalOrden)); // Formatear el total a 2 decimales
//    }
//    
//    public void setTxtTotal(Label txtTotal) {
//        this.txtTotal = txtTotal;
//        actualizarTotal(); // Asegurar que se muestra correctamente al inicio
//    }
//
//    private void actualizarItemsOrden(Producto producto) {
//        // Verificar si el producto ya está en la lista
//        boolean encontrado = false;
//        for (int i = 0; i < itemsOrden.size(); i++) {
//            String item = itemsOrden.get(i);
//            if (item.contains(producto.getNombre())) {
//                // Actualizar la cantidad si el producto ya existe
//                String[] partes = item.split(" - \\$");
//                int cantidad = Integer.parseInt(partes[0].split("x")[0].trim()) + 1;
//                itemsOrden.set(i, +cantidad+ "x " + producto.getNombre() + " - $" + producto.getPrecio() * cantidad);
//                encontrado = true;
//                break;
//            }
//        }
//
//        // Si el producto no está en la lista, agregarlo
//        if (!encontrado) {
//            
//            itemsOrden.add("1x " + producto.getNombre() + " - $" + producto.getPrecio());
//        }
//    }



//descartados:
//    @FXML
//    private Pane pnlMostrar;
//    // Método para inyectar pnlMostrar desde MenuView
//    public void setPnlMostrar(Pane pnlMostrar) {
//        this.pnlMostrar = pnlMostrar;
//    }


