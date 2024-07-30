// LEDControl.h

#ifndef LEDCONTROL_H
#define LEDCONTROL_H


// Constantes para pinos
extern const int TRIG_PIN;
extern const int ECHO_PIN;
extern const int LED_PIN;

// Função para calcular a porcentagem mínima de brilho
double calculateMinBrightnessPercent();

// Função para reduzir o brilho do LED
void reduceBrightness(int pinLed, double targetPercent);

// Função para aumentar o brilho do LED
void increaseBrightness(int pinLed);

#endif // LEDCONTROL_H
