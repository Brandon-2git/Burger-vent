package com.burguerVent.presentacion.pago;

/**
 * Interfaz que define el contrato para la vista de pago con tarjeta.
 * Proporciona los métodos necesarios para interactuar con la interfaz de usuario
 * y manejar las operaciones de pago con tarjeta.
 * 
 * @author Equipo de Desarrollo
 * @version 1.0
 */
public interface PagoTarjetaVista {
    /**
     * Establece el manejador para el evento de pago.
     * 
     * @param action Callback que se ejecutará cuando el usuario realice un pago
     */
    void setOnPagar(Runnable action);
    
    /**
     * Establece el manejador para el evento de regreso.
     * 
     * @param action Callback que se ejecutará cuando el usuario quiera regresar
     */
    void setOnRegresar(Runnable action);
    
    /**
     * Obtiene el número de tarjeta ingresado por el usuario.
     * 
     * @return Número de tarjeta
     */
    String getNumeroTarjeta();
    
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
    
    /**
     * Muestra la ventana de pago con tarjeta.
     */
    void mostrar();
    
    /**
     * Cierra la ventana de pago con tarjeta.
     */
    void cerrar();
} 