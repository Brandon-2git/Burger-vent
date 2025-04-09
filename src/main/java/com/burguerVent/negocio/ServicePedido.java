package com.burguerVent.negocio;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burguerVent.datos.PedidoRepository;
import com.burguerVent.negocio.modelo.Pedido;
import com.burguerVent.negocio.modelo.Producto;



@Service
public class ServicePedido {

	@Autowired
    private PedidoRepository pedidoRepository;

	// Método para obtener todos los pedidos
    public List<Pedido> obtenerTodosLosPedidos() {
        return pedidoRepository.findAll();
    }
    
    public String cantidadDeProductos(List<Producto> productos) {
	    List<String> productosContados = new ArrayList<>();
	    String cantidadDeProductos = "";  // Usamos un String vacío para comenzar

	    // Recorremos la lista de productos
	    for (Producto producto : productos) {
	        // Si ya hemos contado este producto, lo saltamos
	        if (productosContados.contains(producto.getNombre())) continue;

	        int count = 0;
	        // Contamos cuántas veces aparece este producto en la lista
	        for (Producto p : productos) {
	            if (producto.getNombre().equals(p.getNombre())) count++;
	        }

	        // Si ya hay algo en cantidadDeProductos, agregamos una coma para separar
	        if (!cantidadDeProductos.isEmpty()) {
	            cantidadDeProductos += ", ";  // Usamos "+" para concatenar
	        }

	        // Añadimos el nombre del producto y, si hay más de uno, agregamos la cantidad
	        cantidadDeProductos += producto.getNombre();
	        if (count > 1) {
	            cantidadDeProductos += " x" + count;  // Concatenamos la cantidad si es mayor que 1
	        }

	        // Marcamos el producto como contado para no agregarlo de nuevo
	        productosContados.add(producto.getNombre());
	    }

	    return cantidadDeProductos;  // Retornamos la cadena con los productos formateados
	}

	public String cantidadDeProductos2(List<Producto> productos) {
	    List<String> productosContados = new ArrayList<>();
	    String cantidadDeProductos = "";  // Usamos un String vacío para comenzar

	    // Recorremos la lista de productos
	    for (Producto producto : productos) {
	        // Si ya hemos contado este producto, lo saltamos
	        if (productosContados.contains(producto.getNombre())) continue;

	        int count = 0;
	        // Contamos cuántas veces aparece este producto en la lista
	        for (Producto p : productos) {
	            if (producto.getNombre().equals(p.getNombre())) count++;
	        }

	        // Si ya hay algo en cantidadDeProductos, agregamos una coma para separar
	        if (!cantidadDeProductos.isEmpty()) {
	            cantidadDeProductos += "\n ";  // Usamos "+" para concatenar
	        }

	        // Añadimos el nombre del producto y, si hay más de uno, agregamos la cantidad
	        cantidadDeProductos += producto.getNombre();
	        if (count > 1) {
	            cantidadDeProductos += " x" + count;  // Concatenamos la cantidad si es mayor que 1
	        }

	        // Marcamos el producto como contado para no agregarlo de nuevo
	        productosContados.add(producto.getNombre());
	    }

	    return cantidadDeProductos;  // Retornamos la cadena con los productos formateados
	}

    
}
