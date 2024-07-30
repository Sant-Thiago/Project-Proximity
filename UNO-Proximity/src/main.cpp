#include <Arduino.h>
// #include "MyLEDControl.h"

const int TRIG_PIN = 10; 
const int ECHO_PIN = 9;
const int LED_PIN = 3;

const int MAX_BRIGHTNESS = 255;
const double MIN_PERCENTAGE = 8.0; 

float duration = 0.0; pulseIn(echoPin, HIGH);
float distance = 0.0; (duration * 0.0343) / 2;
int brightness = 0;

double calcPercent() {
  return (MAX_BRIGHTNESS * MIN_PERCENTAGE) / 100.0;
}


void reduceBrightness(int pinLed, double targetPercent) {
  int targetBrightness = static_cast<int>(targetPercent);

  if (brightness > targetBrightness) {
    brightness--;
    analogWrite(pinLed, brightness);
    delay(1000);
  }
}

void increaseBrigthness(int pinLed) {
  if (brightness < MAX_BRIGHTNESS) {
    brightness++;
    analogWrite(pinLed, brightness);
    delayMicroseconds(1000);
  }
}



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
