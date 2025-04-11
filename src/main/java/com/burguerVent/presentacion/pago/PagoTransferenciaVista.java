package com.burguerVent.presentacion.pago;

import java.util.function.Consumer;

/**
 * Interfaz que define los métodos necesarios para la vista de pago por transferencia.
 * Proporciona los métodos necesarios para manejar la interacción del usuario
 * y las operaciones de pago por transferencia.
 * 
 * @author Equipo de Desarrollo
 * @version 1.0
 */
public interface PagoTransferenciaVista {
    /**
     * Establece el manejador para el evento de pago.
     * 
     * @param handler Manejador del evento
     */
    void setOnPagar(Consumer<String> handler);
    
    /**
     * Establece el manejador para el evento de regreso.
     * 
     * @param handler Manejador del evento
     */
    void setOnRegresar(Runnable handler);
    
    /**
     * Establece el manejador para el evento de selección de método de pago.
     * 
     * @param handler Manejador del evento
     */
    void setOnMetodoPagoSeleccionado(Runnable handler);
    
    /**
     * Muestra un mensaje de error.
     * 
     * @param mensaje Mensaje a mostrar
     */
    void mostrarError(String mensaje);
    
    /**
     * Muestra un mensaje.
     * 
     * @param titulo Título del mensaje
     * @param mensaje Contenido del mensaje
     */
    void mostrarMensaje(String titulo, String mensaje);
    
    /**
     * Muestra la vista.
     */
    void mostrar();
    
    /**
     * Cierra la vista.
     */
    void cerrar();
} 