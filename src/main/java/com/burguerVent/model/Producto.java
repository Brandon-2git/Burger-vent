/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.burguerVent.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author Brandon
 */
@Entity
@Data
public class Producto {

	@Id // Indica que este es el identificador
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Genera automáticamente el ID
	private long idProducto;

	private String nombre;
	
	private double precio;
	
	//private String personalizacion;
	
	@ManyToOne
    @JoinColumn(name = "idPedido")
    private Pedido pedido;
	
	public void setNombre(String nombre) {
	    this.nombre = nombre;
	}
	
	public String getNombre() {
	    return nombre;
	}
    
	public void setPrecio(double precio) {
	    this.precio = precio;
	}
	
	public double getPrecio() {
	    return precio;
	}
}
