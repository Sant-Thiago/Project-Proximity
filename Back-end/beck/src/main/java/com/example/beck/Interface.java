package com.example.beck;

import org.springframework.stereotype.Component;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

@Component
public class Interface {
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Configurar minPercentage");

        Label label = new Label("minPercentage");
        TextField minPercentageText = new TextField();

        Button sendButton = new Button("Enviar");
    }
}
