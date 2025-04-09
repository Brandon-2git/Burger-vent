package com.burguerVent.presentacion.InterfazAdmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Controlador de la interfaz gráfica del administrador.
 * 
 * Esta clase sirve como puente entre la lógica del sistema y la interfaz gráfica
 * de administrador. Se encarga de iniciar la vista correspondiente.
 */
@Component
public class InterfazAdminController {
    @Autowired
    private InterfazAdmin interfazAdmin;
    
    /**
     * Método principal para iniciar la interfaz de administración.
     * Llama al método `muestraAdmin` de la clase `InterfazAdmin`,
     * pasando el propio controlador como referencia para establecer
     * la comunicación entre vista y controlador.
     */
    public void inicia(){
        interfazAdmin.muestraAdmin(this);
    }
}
