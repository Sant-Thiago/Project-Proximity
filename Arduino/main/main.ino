#include <Arduino.h>
#include "LEDControl.h"

float duration = 0.0;
float distance = 0.0;

// Molotov - A Oração feat. A-Ka
void setup() {
  pinMode(TRIG_PIN, OUTPUT);
  pinMode(ECHO_PIN, INPUT);
  pinMode(LED_PIN, OUTPUT);
  
  Serial.begin(9600);
  Serial.println("Setup is complete");
}

void loop() {
  digitalWrite(TRIG_PIN, LOW);
  delayMicroseconds(2);
  
  digitalWrite(TRIG_PIN, HIGH);
  delayMicroseconds(10);
  
  digitalWrite(TRIG_PIN, LOW);
  
  duration = pulseIn(ECHO_PIN, HIGH);
  
  distance = (duration * 0.0343) / 2;

  double percent;
  // Verifica se há dados disponíveis para leitura
  if (Serial.available() > 0) {
    double wishedPercent = Serial.parseFloat(); // Lê o valor enviado
    percent = calculateMinBrightnessPercent(wishedPercent);
  }

  Serial.println("Valor recebido:: ");
  Serial.println(percent);

  if (distance > 100) {
    reduceBrightness(percent);
  } else {
    increaseBrightness();
  }
}
