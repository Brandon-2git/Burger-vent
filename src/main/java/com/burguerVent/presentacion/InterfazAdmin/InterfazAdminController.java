package com.burguerVent.presentacion.InterfazAdmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class InterfazAdminController {
    @Autowired
    private InterfazAdmin interfazAdmin;
    
    public void inicia(){
        interfazAdmin.muestraAdmin(this);
    }
}
