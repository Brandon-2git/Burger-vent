package com.burguerVent.presentacion.bienvenido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BienvenidoController {

    @Autowired
    private BienvenidoView bienvenidoView;


    public void inicia() {

        bienvenidoView.muestra(this);
    }


    // Método que se llama desde el botón "Comenzar"
    public void comenzar() {
        // Lógica que deseas ejecutar al presionar "Comenzar"
        System.out.println("Comenzando el proceso...");
    }
}


    
     /**
     * Método para manejar el flujo cuando el usuario hace clic en "Comenzar"
     */
//    public void comenzar() {
//            controlMenu.inicia();
//       }

