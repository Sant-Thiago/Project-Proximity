package com.example.beck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.stage.Stage;

@SpringBootApplication
public class BeckApplication extends Application {

	private static ConfigurableApplicationContext applicationContext;

	public static void main(String[] args) {
		// Inicializa o contexto Spring
		applicationContext = SpringApplication.run(BeckApplication.class, args);
		// Inicializa o JavaFX
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		// Obter o bean da Interface a partir do contexto Spring
		Interface userInterface = applicationContext.getBean(Interface.class);
		// Iniciar a interface do usuário
		userInterface.start(primaryStage);
	}

	@Override
    public void stop() throws Exception {
        super.stop();
        if (applicationContext != null) {
            applicationContext.close(); // Fecha o contexto Spring Boot
        }
        System.out.println("Application is shutting down...");
    }

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

}
