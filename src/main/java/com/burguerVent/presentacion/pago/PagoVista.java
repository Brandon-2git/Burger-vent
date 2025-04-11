package com.burguerVent.presentacion.pago;

import java.util.function.Consumer;

public interface PagoVista {
    void setOnPagar(Runnable action);
    void setOnRegresar(Runnable action);
    String getMetodoPagoSeleccionado();
    void mostrarError(String mensaje);
    void mostrarMensaje(String titulo, String mensaje);
    void mostrar();
    void cerrar();
} 