package com.burguerVent.presentacion.menu;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.burguerVent.negocio.ServiceProducto;
import com.burguerVent.negocio.modelo.Producto;



@Component
public class MenuController {
    
    
    @Autowired
    private MenuView menuView;
    
    public void inicia() {

        menuView.muestra(this);
    }

    @Autowired
    private ServiceProducto serviceproducto;
    
   

    
    public void actualizarVista() {
       List<String> productosorden = serviceproducto.obtenerproductosorden();
        double total = serviceproducto.obtenerTotal();
        menuView.actualizarListaProductos(productosorden);
        menuView.actualizarTotal(total);
    }

    // Método para agregar una hamburguesa clásica a la orden
   
    public void agregarClasica(Producto producto) {
        // Llamar al servicio para agregar el producto
        serviceproducto.agregarProducto(producto);
        actualizarVista();
    }
    
    // Método para agregar una hamburguesa premium  a la orden
    public void agregarPremium(Producto producto) {
        // Llamar al servicio para agregar el producto
        serviceproducto.agregarProducto(producto);
        actualizarVista();
    }
    
    // // Método para agregar una bebida a la orden
    public void agregarBebidas(Producto producto) {
        // Llamar al servicio para agregar el producto
        serviceproducto.agregarProducto(producto);
        actualizarVista();
    }
    
    
    public void finalizarPedido() {
        serviceproducto.guardarPedido();
        actualizarVista();
        
    }
 
 //metodo para cancelar un pedido(borrar toda la orden)
public void cancelarpedido() {
	    //llama al servicio para limpiar la orden y dejar el total en 0
    	serviceproducto.limpiarOrden();
    	//actualizar vista para reflejar los cambios 
    	  actualizarVista();
    }

//Elimina un producto de la orden en el servicio y actualiza la vista.
public void eliminarproducto(String producto) {
	 // Elimina el producto de la orden a través del servicio
	 serviceproducto.eliminarProducto(producto);
	 // Actualiza la vista para reflejar los cambios en la lista y el total
	 actualizarVista();
	  
	
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
//    	    actualizarTotal(); // Actualizar la etiqueta del total
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


