package com.example.beck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javafx.application.Application;
import javafx.stage.Stage;

@SpringBootApplication
public class BeckApplication extends Application {

	@Autowired
	private Interface userInterface;

	public static void main(String[] args) {
		SpringApplication.run(BeckApplication.class, args);
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		userInterface.start(primaryStage);
	}


}
