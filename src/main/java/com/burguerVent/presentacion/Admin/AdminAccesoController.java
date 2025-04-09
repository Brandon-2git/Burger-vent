package com.burguerVent.presentacion.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * Controlador que actúa como puente entre la lógica del sistema y la vista de autenticación del administrador.
 * Se encarga de iniciar la vista del login del administrador.
 */
@Component
public class AdminAccesoController {
    @Autowired
    private AdminAcceso adminAcceso;
    
    /**
     * Llama al método `muestra` de la clase `AdminAcceso` para mostrar la interfaz de login.
     */
    public void inicia() {
        adminAcceso.muestra(this);
    }

}