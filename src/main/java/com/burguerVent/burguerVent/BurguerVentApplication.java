package com.burguerVent.burguerVent;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BurguerVentApplication extends Application {

	public static void main(String[] args) {

		SpringApplication.run(BurguerVentApplication.class, args);
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		var context = SpringApplication.run(BurguerVentApplication.class);

		var fxml = new FXMLLoader(getClass().getResource("/view/Bienvenido.fxml"));
		var scene = new Scene(fxml.load());
		stage.setTitle("BurguerVent");
		stage.setScene(scene);
		stage.show();
	}
}
