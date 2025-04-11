package com.burguerVent.presentacion.recibirpedidos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.burguerVent.negocio.ServicePedido;
import com.burguerVent.negocio.modelo.Pedido;
import com.burguerVent.negocio.modelo.Producto;

@Component
public class ControlRecibirPedido {

	@Autowired
	private VentanaRecibirPedido ventana;
	
	@Autowired
	private ServicePedido servicePedido;
	
	@Autowired
	private VentanaDetalles ventanadetalles;
	
 private boolean ventanaMostrada = false;
	 
	 private List<Integer> pedidosMostrados = new ArrayList<>();
	
	
	public void inicia() {

		ventana.muestra(this);
	}
	
	
	public void actualizarPedidos() {
        List<Pedido> pedidos = servicePedido.obtenerTodosLosPedidos();
        ventana.mostrarPedidos(pedidos);
        // Si hay pedidos, mostrar una ventana emergente por cada uno
        for (Pedido pedido : pedidos) {
        	 if (!pedidosMostrados.contains(pedido.getIdPedido())) {
            String mensaje = "Pedido #" + pedido.getIdPedido() + ":\n";
            mensaje += cantidadproducto2(pedido.getProductos());  // Productos del pedido
            
            // Llamamos a la ventana emergente para cada pedido
            mostrarVentanaEmergente(mensaje);
            
            pedidosMostrados.add(pedido.getIdPedido());
            
        }
        	 
       
        }
        ventanaMostrada = true;
         
	}
	
	 private void mostrarVentanaEmergente(String mensaje) {
	        // Llamamos al método mostrarVentana() de VentanaEmergente con el mensaje
	       ventanadetalles.mostrarVentana(mensaje);
	    }
	 
	 public String cantidadproducto(List<Producto> productos) {
		return servicePedido.cantidadDeProductos(productos);
	 }
	 
	 public String cantidadproducto2(List<Producto> productos) {
		return servicePedido.cantidadDeProductos2(productos);
	 }
}
