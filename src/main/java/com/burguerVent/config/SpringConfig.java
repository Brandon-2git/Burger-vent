package com.burguerVent.config;

import com.burguerVent.presentacion.pago.PagoEfectivoVista;
import com.burguerVent.presentacion.pago.PagoEfectivoVistaImpl;
import com.burguerVent.presentacion.pago.PagoEfectivoView;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringConfig {
    
    @Bean
    @Primary
    @Scope("prototype")
    public PagoEfectivoVista pagoEfectivoVista() {
        System.out.println("Creando nueva instancia de PagoEfectivoVista");
        return new PagoEfectivoVistaImpl();
    }
    
    @Bean
    @Scope("singleton")
    public PagoEfectivoView pagoEfectivoView() {
        System.out.println("Creando PagoEfectivoView");
        return new PagoEfectivoView();
    }
} 