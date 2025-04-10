package com.burguerVent.negocio.modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPedido;

	private double costoTotal;
	
	//@OneToMany // Relación: Un pedido puede tener muchos productos
	 //@JoinColumn(name = "idPedido")
	// @OneToMany(cascade = CascadeType.PERSIST)
	@OneToMany(targetEntity = Producto.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private List <Producto> productos = new ArrayList <> ();
	
	
	 /**
     * @return the idPedido
     */
    public long getIdPedido() {
        return idPedido;
    }

    /**
     * @param idPedido the idPedido to set
     */
    public void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }

    /**
     * @return the costoTotal
     */
    public double getCostoTotal() {
        return costoTotal;
    }

    /**
     * @param costoTotal the costoTotal to set
     */
    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    /**
     * @return the productos
     */
    public List<Producto> getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
        calcularCostoTotal();
    }

    /**
     * Agrega un producto al pedido y actualiza el costo total.
     */
    public void agregarProducto(Producto producto) {
        productos.add(producto);
        calcularCostoTotal();
    }

    /**
     * Elimina un producto del pedido y actualiza el costo total.
     */
    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
        calcularCostoTotal();
    }

    /**
     * Calcula el costo total del pedido sumando los precios de los productos.
     */
    private void calcularCostoTotal() {
        this.costoTotal = productos.stream().mapToDouble(Producto::getPrecio).sum();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pedido other = (Pedido) obj;
        return idPedido == other.idPedido;
    }

    @Override
    public int hashCode() {
        return (int) (31 * idPedido);
    }

    @Override
    public String toString() {
        return "Pedido [idPedido=" + idPedido + ", costoTotal=" + costoTotal + ", productos=" + productos + "]";
    }
}
