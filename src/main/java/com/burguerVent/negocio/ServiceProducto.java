package com.burguerVent.negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burguerVent.datos.PedidoRepository;
import com.burguerVent.datos.ProductoRepository;
import com.burguerVent.negocio.modelo.Pedido;
import com.burguerVent.negocio.modelo.Producto;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@Service
public class ServiceProducto {

	private List<Producto> orden = new ArrayList<>();
    private ObservableList<String> itemsOrden = FXCollections.observableArrayList();
    private double totalOrden = 0.0;
    
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ProductoRepository productorepository;
    
   
    // Método para agregar un producto a la orden
    public void agregarProducto(Producto producto) {
        orden.add(producto);  // Agregar el producto a la lista de la orden
        //itemsOrden.add(producto.getNombre() + " - $" + producto.getPrecio()); // Agregar a la lista observable
        actualizarItemsOrden(producto);
        totalOrden += producto.getPrecio(); // Actualizar el total de la orden
    }

    // Método para obtener la lista observable de productos en la orden
    public ObservableList<String> obtenerItemsOrden() {
        return itemsOrden;
    }

    // Método para obtener el total de la orden
    public double obtenerTotal() {
        return totalOrden;
    }

    // Método para obtener la lista de productos en la orden
    public List<Producto> obtenerOrden() {
        return orden;
    }
    
    private void actualizarItemsOrden(Producto producto) {
        // Verificar si el producto ya está en la lista
        boolean encontrado = false;
        for (int i = 0; i < itemsOrden.size(); i++) {
            String item = itemsOrden.get(i);
            if (item.contains(producto.getNombre())) {
                // Actualizar la cantidad si el producto ya existe
                String[] partes = item.split(" - \\$");
                int cantidad = Integer.parseInt(partes[0].split("x")[0].trim()) + 1;
                itemsOrden.set(i, cantidad + "x " + producto.getNombre() + " - $" + String.format("%.2f", producto.getPrecio() * cantidad));
                encontrado = true;
                break;
            }
        }

        // Si el producto no está en la lista, agregarlo
        if (!encontrado) {
            itemsOrden.add("1x " + producto.getNombre() + " - $" + String.format("%.2f", producto.getPrecio()));
        }
    }
    
    
    public void guardarPedido() {
        if (!orden.isEmpty()) {
            // Crear un nuevo pedido
            Pedido pedido = new Pedido();
            pedido.setProductos(new ArrayList<>(orden)); // Clonar la lista de productos
            pedido.setCostoTotal(totalOrden);

            // Guardar el pedido junto con los productos
            pedidoRepository.save(pedido); // Esto guardará el pedido y los productos automáticamente si son nuevos
            limpiarOrden(); // Limpiar la orden después de guardarla
        }
    }


    public void limpiarOrden() {
        orden.clear();
        itemsOrden.clear();
        totalOrden = 0.0;
    }

    
   
    
}
