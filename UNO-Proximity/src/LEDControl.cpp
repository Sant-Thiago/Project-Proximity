// LEDControl.cpp

#include "LEDControl.h"
#include <Arduino.h>

const int TRIG_PIN = 10; 
const int ECHO_PIN = 9;
const int LED_PIN = 3;

const int MAX_BRIGHTNESS = 255;
const double MIN_PERCENTAGE = 8.0;

int BRIGHTNESS = 0;

double calculateMinBrightnessPercent() {
    return (MAX_BRIGHTNESS * MIN_PERCENTAGE) / 100; 
}

void reduceBrightness(double targetPercent) {
    int targetBrightness = static_cast<int>(targetPercent);

    if (BRIGHTNESS > targetBrightness) {
        BRIGHTNESS--;
        analogWrite(LED_PIN, BRIGHTNESS);
        delay(1000);
    }
}

void increaseBrightness() {
    if (BRIGHTNESS < MAX_BRIGHTNESS) {
        BRIGHTNESS++;
        analogWrite(LED_PIN, BRIGHTNESS);
        delayMicroseconds(1000);
  }
}
