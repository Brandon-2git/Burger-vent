package com.burguerVent.negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burguerVent.datos.PedidoRepository;
import com.burguerVent.negocio.modelo.Pedido;
import com.burguerVent.negocio.modelo.Producto;

@Service
public class ServiceProducto {

	private List<Producto> orden = new ArrayList<>();
	private List<String> productosorden = new ArrayList<>();
    private double totalOrden = 0.0;
    
    @Autowired
    private PedidoRepository pedidoRepository;
    
    
   
    // Método para agregar un producto a la orden
    public void agregarProducto(Producto producto) {
        orden.add(producto);  // Agregar el producto a la lista de la orden
        actualizarproductosOrden(producto);
        totalOrden += producto.getPrecio(); // Actualizar el total de la orden
    }
    
    


    
    public List<String> obtenerproductosorden() {
      
        return productosorden;
    	
    }
    
   


    // Método para obtener el total de la orden
    public double obtenerTotal() {
        return totalOrden;
    }

    // Método para obtener la lista de productos en la orden
    public List<Producto> obtenerOrden() {
        return orden;
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
        productosorden.clear();
        totalOrden = 0.0;
    }
    
    public void actualizarproductosOrden(Producto producto) {
        // Verificar si el producto ya está en la lista
        boolean encontrado = false;
        for (int i = 0; i < productosorden.size(); i++) {
            String item = productosorden.get(i);
            if (item.contains(producto.getNombre())) {
                // Actualizar la cantidad si el producto ya existe
                String[] partes = item.split(" - \\$");
                int cantidad = Integer.parseInt(partes[0].split("x")[0].trim()) + 1;
                // Actualizar el precio con la nueva cantidad
                productosorden.set(i, cantidad + "x " + producto.getNombre() + " - $" + (producto.getPrecio() * cantidad));
                encontrado = true;
                break;
            }
        }

        // Si el producto no está en la lista, agregarlo
        if (!encontrado) {
            productosorden.add("1x "+producto.getNombre() + " - $" + producto.getPrecio());
        }
    }
    
    //metodo para eliminar el producto de la lista de la orden
    public void eliminarProducto(String nombre) {
        
        // Eliminar el producto de la lista de productosorden
        for (int i = 0; i < productosorden.size();) {
            String producto = productosorden.get(i);
            if (producto.contains(nombre)) {
                productosorden.remove(i); // Elimina si contiene el nombre buscado
                // No se incrementa i, porque al eliminar el elemento actual, el siguiente ocupa su lugar
            }else {
            	i++; // Solo se incrementa si no se elimina
            }
        }
    
              // Eliminar el producto de la lista de orden
        for (int i = 0; i <orden.size();) {
            Producto producto = orden.get(i);
            if (producto.getNombre().equals(nombre)) {
            	totalOrden -= producto.getPrecio();// Actualiza el total restando el precio del producto eliminado
                orden.remove(i); // Elimina el producto de la lista

              
               
            }else {
            	i++;
            }
        }

    }

}

    
 




    
   
    

