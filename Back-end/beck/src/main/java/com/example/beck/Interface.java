package com.example.beck;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.function.UnaryOperator;

import org.springframework.stereotype.Component;

import com.fazecast.jSerialComm.SerialPort;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

@Component
public class Interface {

    private PrintWriter serialWritter;
    private SerialPort serialPort;

    public void start(Stage primaryStage) {
        primaryStage.setTitle("ST-Led | Configuration");

        // Cria os componentes
        Label label = new Label("minPercentage");
        TextField minPercentageText = new TextField();
        
        // Configura o TextFormatter para aceitar apenas números
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*")) { // Aceita apenas dígitos
                return change;
            }
            return null;
        };
        TextFormatter<String> textFormatter = new TextFormatter<>(filter);
        minPercentageText.setTextFormatter(textFormatter);

        Button sendButton = new Button("Enviar");

        // Configuração da comunicação serial
        setupSerialPort();

        // Adiciona um EventHandler ao botão
        sendButton.setOnAction(event -> {
            // Obtém o valor do TextField
            String minPercent = minPercentageText.getText();
            if (serialPort != null && serialPort.isOpen()) {
                try {
                    serialPort.getOutputStream().write((minPercent + "\n").getBytes()); // Envia o valor com quebra de linha
                    serialPort.getOutputStream().flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // Cria o layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, minPercentageText, sendButton);
        layout.setAlignment(javafx.geometry.Pos.CENTER);

        // Cria a cena
        Scene scene = new Scene(layout, 300, 200);
        
        // Carrega e aplica o CSS
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        // Configura e exibe o placo
        primaryStage.setScene(scene);
        primaryStage.show();
        
        primaryStage.setOnCloseRequest(event -> {
            if (serialPort != null && serialPort.isOpen()) {
                serialPort.closePort();
                System.out.println("Porta serial fechada.");
            }
        });
    }

    private void setupSerialPort() {
        try {
            serialPort = SerialPort.getCommPort("COM3");
            serialPort.setBaudRate(9600);
            serialPort.setNumDataBits(8);
            serialPort.setNumStopBits(SerialPort.ONE_STOP_BIT);
            serialPort.setParity(SerialPort.NO_PARITY);

            serialPort.openPort();

            System.out.println("Porta serial aberta.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
