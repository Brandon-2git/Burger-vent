package com.burguerVent.burguerVent;
import com.burguerVent.presentacion.Admin.AdminAccesoController;
import com.burguerVent.presentacion.bienvenido.BienvenidoController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Clase principal que arranca la aplicación 
 * construida usando el principio de 
 * inversión de control
 * Adaptada para usar JavaFX
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.burguerVent")
@EntityScan(basePackages = {"com.burguerVent.negocio.modelo"})
@EnableJpaRepositories("com.burguerVent.datos")
public class BurguerVentApplication {


        //Método principal
	public static void main(String[] args) {
            Application.launch(JavaFXApplication.class, args);  // Inicia JavaFX

        }
        
        /**
	 * Clase interna para manejar la inicialización de JavaFX
	 */
        public static class JavaFXApplication extends Application {
            private static ConfigurableApplicationContext applicationContext;

            @Override
            public void init() throws Exception {
                // Crear el contexto de Spring Boot
                SpringApplicationBuilder builder = new SpringApplicationBuilder(BurguerVentApplication.class);
                builder.headless(false);
                applicationContext = builder.run(getParameters().getRaw().toArray(new String[0]));
            }

        @Override
        public void start(Stage primaryStage) {
            // Lanza la interfaz desde el controlador principal
            Platform.runLater(() -> {
                applicationContext.getBean(BurguerVentApplication.class).inicia();
            });
        }

        @Override
        public void stop() throws Exception {
            applicationContext.close();
            Platform.exit();
        }
    }
        
    /**
    * Metodo que arranca la aplicacion
    * inicializa la bd y arranca el controlador
    */	
    @Autowired
    private BienvenidoController bienvenidoController;
//    @Autowired
//    private AdminAccesoController accesoController;

    public void inicia() {
        Platform.runLater(() -> {
            bienvenidoController.inicia();
//            accesoController.inicia();
	});
    }
   
}
