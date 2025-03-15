package com.burguerVent.burguerVent;
import com.burguerVent.view.BienvenidoView;
import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BurguerVentApplication {

        
	public static void main(String[] args) {
		// Lanzar la aplicación JavaFX
            ConfigurableApplicationContext context =SpringApplication.run(BurguerVentApplication.class, args);

            //esta linea lansa el menuView
            Application.launch(BienvenidoView.class, args);
        }
        
       
}
