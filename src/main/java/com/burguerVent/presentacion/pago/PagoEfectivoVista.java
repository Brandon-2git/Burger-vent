package com.burguerVent.presentacion.pago;

import java.util.function.Consumer;

/**
 * Interfaz que define el contrato para la vista de pago en efectivo.
 * Proporciona los métodos necesarios para interactuar con la interfaz de usuario
 * y manejar las operaciones de pago en efectivo.
 * 
 * @author Equipo de Desarrollo
 * @version 1.0
 */
public interface PagoEfectivoVista {
    /**
     * Establece el manejador para el evento de pago.
     * 
     * @param action Callback que se ejecutará cuando el usuario realice un pago
     */
    void setOnPagar(Consumer<Double> action);
    
    /**
     * Establece el manejador para el evento de regreso.
     * 
     * @param action Callback que se ejecutará cuando el usuario quiera regresar
     */
    void setOnRegresar(Runnable action);
    
    /**
     * Establece el monto total a pagar.
     * 
     * @param total Monto total del pago
     */
    void setTotal(double total);
    
    /**
     * Muestra la ventana de pago en efectivo.
     */
    void mostrar();
    
    /**
     * Cierra la ventana de pago en efectivo.
     */
    void cerrar();
    
    /**
     * Limpia los campos de entrada de la vista.
     */
    void limpiarCampos();
    
    /**
     * Muestra un mensaje de error al usuario.
     * 
     * @param mensaje Mensaje de error a mostrar
     */
    void mostrarError(String mensaje);
    
    /**
     * Muestra un mensaje informativo al usuario.
     * 
     * @param titulo Título del mensaje
     * @param mensaje Contenido del mensaje
     */
    void mostrarMensaje(String titulo, String mensaje);
} 