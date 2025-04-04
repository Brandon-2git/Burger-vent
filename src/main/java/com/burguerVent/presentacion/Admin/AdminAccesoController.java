/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.burguerVent.presentacion.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Brandon
 */
@Component
public class AdminAccesoController {
    @Autowired
    private AdminAcceso adminAcceso;
    
    public void inicia() {
        adminAcceso.muestra(this);
    }

}
/*
como se puede autenticar un usuario con javaFx este es mi codigo de la interfaz dime que 
me falta que sea sencillo (de ser necesario no usar una base de datos ):
*/