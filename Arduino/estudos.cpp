#include <Arduino.h>

#define led 3 // define que o primeiro led será conectado ao pino 9
		     // no arduino UNO apenas os pinos 3, 5, 6, 9, 10, 11 porem ser usados como pw,

const int trigPin = 10; 
const int echoPin = 9;

// const são variaveis imutaveis
// extern const indica para o compilador que essa const é definida em outro arquivo, permite compartilhar a mesma constante entre varios arquivos
// static const define uma const que está limitada ao arquivo onde é definida, não podendo ser acessada em outros arquivos
// #define não tem escopo limitado, define uma const simbolica que é substituida pelo pré-processador antes da compilação. Usado para criar macros( == var) e constantes simbolicas

double calcPercent() {
  const int total = 255;
  const double percentTotal = 100;
  const double minPercentPotency = 8; // define o percentual da potência mínima desejada
  const double percent = (total * minPercentPotency) / percentTotal;
  return percent;
}

const double percent = calcPercent();
float duration, distance;
int brilho = 0;

// clojure

void reduce(int pinLed, double percent) {
  if (brilho > percent) {
    brilho = brilho - 15;
    analogWrite(pinLed, brilho);
    delay(1000);
  }
}

void increase(int pinLed) {
  if (brilho < 255) {
    brilho = brilho + 15;
    analogWrite(pinLed, brilho);
    delay(100);
  }
}



void setup() { // inicio de void setup - configurações iniciais que são executadas apenas uma vez
  pinMode(trigPin, OUTPUT);
  pinMode(echoPin, INPUT);
  
  Serial.begin(9600);
  Serial.println("Setup is complete");

  pinMode(led, OUTPUT); // define o pino do led como saída
}	// fim do void setup - o programa segue para o void loop

void loop() {
  digitalWrite(trigPin, LOW);
  delayMicroseconds(2);
  
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);
  
  digitalWrite(trigPin, LOW);
  
  duration = pulseIn(echoPin, HIGH);
  
  // SIMULAR duration de MIN 420 MAX 14200
  // Serial.println(duration);
  
  distance = (duration * 0.0343) / 2;


  // a intensidade na saida pwm varia de 0 a 255
  // aciona o peno do led com determindad intensidade
  // fim do void loop - o programa retorna ao inicio do void loop
  if (distance > 100) {
    reduce(led, percent);
  } else {
    increase(led);
  }
  
  // Serial.println(brilho);
}
