#include <Arduino.h>
#include "LEDControl.h"

 

// pulseIn(echoPin, HIGH);

float duration = 0.0;
float distance = 0.0; (duration * 0.0343) / 2;

void increaseBrigthness(int pinLed) {
  
}


// VaVa x ROLAND JONES - 凍京 // Molotov - A Oração feat. A-Ka
void setup() {
  pinMode(TRIG_PIN, OUTPUT);
  pinMode(ECHO_PIN, INPUT);
  pinMode(LED_PIN, OUTPUT);
  
  Serial.begin(9600);
  Serial.println("Setup is complete");
}

void loop() {
  float duration, distance;

  digitalWrite(TRIG_PIN, LOW);
  delayMicroseconds(2);
  
  digitalWrite(TRIG_PIN, HIGH);
  delayMicroseconds(10);
  
  digitalWrite(TRIG_PIN, LOW);
  
  duration = pulseIn(ECHO_PIN, HIGH);
  distance = (duration * 0.0343) / 2;

  double percent = calcPercent();

  if (distance > 100) {
    reduceBrightness(LED_PIN, percent);
  } else {
    increaseBrigthness(LED_PIN);
  }
  
  // Serial.println(brilho);
}
