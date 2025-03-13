package com.burguerVent.burguerVent;
import com.burguerVent.view.javaFxApplication;

import jakarta.annotation.PostConstruct; // Indica que un método debe ejecutarse automáticamente después de la inyección de dependencias.  
import javafx.application.Application; // Proporciona la base para aplicaciones JavaFX, gestionando el ciclo de vida de la interfaz gráfica.  
import org.springframework.boot.SpringApplication; // Inicia la aplicación Spring Boot y gestiona su contexto.  
import org.springframework.boot.autoconfigure.SpringBootApplication; // Configura automáticamente la aplicación Spring Boot, habilitando escaneo de componentes y configuración predeterminada.  

@SpringBootApplication
public class BurguerVentApplication {

	public static void main(String[] args) {
		SpringApplication.run(BurguerVentApplication.class, args);
	}
       @PostConstruct
        public void startJavaFx() {
            // Lanza JavaFX en un hilo independiente
            new Thread(() -> Application.launch(javaFxApplication.class)).start();
        }
        
         

}
