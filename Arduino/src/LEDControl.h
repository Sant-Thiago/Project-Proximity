#ifndef LEDCONTROL_H
#define LEDCONTROL_H

// Constantes para pinos
extern const int TRIG_PIN;
extern const int ECHO_PIN;
extern const int LED_PIN;

// Função para calcular a porcentagem mínima de brilho
double calculateMinBrightnessPercent();

// Função para calcular a porcentagem mínima de brilho com parametro desejado
double calculateMinBrightnessPercent(double wantedMinPercent);

// Função para reduzir o brilho do LED
void reduceBrightness(double targetPercent);

// Função para aumentar o brilho do LED
void increaseBrightness();

#endif // LEDCONTROL_H
