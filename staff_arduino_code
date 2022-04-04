//Pantalla
int valor[7];
int j;
int led1 = 27;

//Neopixel
#include <Adafruit_NeoPixel.h>
#define PIN        6
#define NUMPIXELS 12
int ant = 0;
int i = 0;
int R = 255;
int G = 255;
int B = 0;
//#define UNO 0
//#define DOS 1
Adafruit_NeoPixel pixels(NUMPIXELS, PIN, NEO_GRB + NEO_KHZ800);
int intneo = 75;
int intneoi = 100;
int intneof = 200;

//Encoders
const int intPin1 = 2;
volatile long ISRCounter1 = 0;
long counter1 = 0;

const int intPin2 = 3;
volatile long ISRCounter2 = 0;
long counter2 = 0;

int rango = 100;
//M2 ES EL MOTOR IZQUIERDO Y M1 EL MOTOR DERECHO
int m1 = 15; //Derecho m1
int m2 = 17; //Derecho m2 y giro hora 1 m2
int m3 = 18; //Giro hora 1 m1
int m4 = 15; //Giro anti 2 m1
int m5 = 21; //Giro anti 2 m2

int interm = 4;

//Reles
#define rel1 49
#define rel2 41
#define relg 7

//Valvula Intervalo inicial y final
//int intvali = 1000;
//int intvalf = 2000;

//Etiquetar Estados
#define EINI 0
#define EUNO 1
#define EGIROA 2
#define EDOS 3
#define EGIROB 4
#define ETRES 5
#define EGIROC 6
#define ECUATRO 7
#define EGIROD 8
#define ECINCO 9
#define EGIROE 10
#define ESEIS 11
#define EGIROF 12
#define ESIETE 13
#define EGIROG 14
#define EALARMA 15
#define EFIN 16
//Pulsos en rectas
#define D1 190000
#define D2 19000
#define D3 128874
#define D4 128874
#define D5 19000
#define D6 190000
#define D7 9500
//Pulsos en giros
#define GA 25000
#define GB 25500
#define GC 44100
#define GD 25500
#define GE 25000
#define GF 25000
#define GG 25000


//Boton de emergencia
#define btne 4

//Tiempo Neopixel
unsigned long tini0 = 0; // Tiempo inicial
unsigned long tact0 = 0; // Tiempo actual
unsigned long trel0 = 0; // Tiempo relativo
//Tiempo Motor 1
unsigned long tini1 = 0; // Tiempo inicial
unsigned long tact1 = 0; // Tiempo actual
unsigned long trel1 = 0; // Tiempo relativo
//Tiempo Motor 2
unsigned long tini2 = 0; // Tiempo inicial
unsigned long tact2 = 0; // Tiempo actual
unsigned long trel2 = 0; // Tiempo relativo
//Tiempo Valvula
unsigned long tini3 = 0; // Tiempo inicial
unsigned long tact3 = 0; // Tiempo actual
unsigned long trel3 = 0; // Tiempo relativo
const long intervalo = 250;

//Declaro estado
unsigned int estado = 0;

int power1 = 64; //Motor Izquierdo
int power2 = 191; //Motor Derecho

//Subrutinas y/o funciones
void disminuyo1()
{
  tact1 = millis();
  if (tact1 - tini1 >= intervalo) {
    tini1 = tact1;
    power1--;
    Serial1.print (power1);
  }
}
void disminuyo2()
{
  tact2 = millis();
  if (tact2 - tini2 >= intervalo) {
    tini2 = tact2;
    power2--;
    Serial1.print (power2);
  }
}
void aumento1()
{
  tact1 = millis();
  if (tact1 - tini1 >= intervalo) {
    tini1 = tact1;
    power1++;
    Serial1.print (power1);
  }
}
void aumento2()
{
  tact2 = millis();
  if (tact2 - tini2 >= intervalo) {
    tini2 = tact2;
    power2++;
    Serial1.print (power2);
  }
}
void stop1()
{
  power1 = 64;
  power2 = 191;
  Serial1.print (power1);
  Serial1.print (power2);
}
//Pantalla Void =======================================================================
void ff()
{
  Serial3.write(0xff);
  Serial3.write(0xff);
  Serial3.write(0xff);
}

void detectar_boton()
{
  j = 0;

  if (Serial3.available() > 0) // si la pantalla me pide un dato
  {
    //    Serial.println("Detecto tecla");
    delay(20);
    while (Serial3.available() > 0)
    {
      valor[j] = Serial3.read(); /*leo la infor que me manda */
      j++; /* la almacena en i */
    }

    if ((valor[0] == 0x65) && (valor[6] == 0xFF))  // si el valor en la posicion 0 es 6
    {
      if (valor[1] == 0x03 && valor[2] == 0x02)  // // pulsador 1 de la pagina 0
      {
        estado = EUNO;
        Serial.println("Estado: EUNO");
        tini0 = millis();
        tini1 = millis();
        tini2 = millis();
        tini3 = millis();
      }
      //    if (valor[1] == 0 && valor[2] == 3)  // // pulsador 2 de la pagina 0
      //    {
      //      digitalWrite(led1, LOW);
      //      Serial.println("Apaga led");
      //    }
    }
  }
}
//Pantalla Void =======================================================================
//Configuracion
void setup()
{
  Serial3.begin(9600);
  pinMode(btne, INPUT);
#if defined(__AVR_ATtiny85__) && (F_CPU == 16000000)
  clock_prescale_set(clock_div_1);
#endif
  pixels.begin(); // INITIALIZE NeoPixel strip object (REQUIRED)

  pinMode(intPin1, INPUT_PULLUP);
  Serial.begin(9600);
  attachInterrupt(0, interruptCount1, FALLING);

  pinMode(intPin2, INPUT_PULLUP);
  Serial.begin(9600);
  attachInterrupt(1, interruptCount2, FALLING);

  //Limpieza de salidas fisicas
  pinMode(rel1, OUTPUT);
  pinMode(rel2, OUTPUT);
  pinMode(relg, OUTPUT);
  digitalWrite(rel1, HIGH);
  digitalWrite(rel2, HIGH);
  digitalWrite(relg, LOW);
  ISRCounter1 = 0;
  ISRCounter2 = 0;
  //Comunicaciones
  Serial.begin(9600); //Inicio comunicaciones con el computador (monitor serial)
  Serial1.begin(9600);
  // estado = EGIROA;
  estado = EUNO;
  Serial.println("Estado: EINI"); //Imprimo el estado
  tini0 = millis();
  tini1 = millis();
  tini2 = millis();
  tini3 = millis();

}

void loop()
{
  tact0 = millis();
  tact1 = millis();
  tact2 = millis();
  tact3 = millis();//Tomo el tiempo actual en todo momento
  counter1 = ISRCounter1;
  counter2 = ISRCounter2;
  // Serial.println(counter1);
  // Serial.println(counter2);

  //MEF
  switch (estado)
  {
    case EINI:
      ff();
      digitalWrite(rel1, HIGH);
      digitalWrite(rel2, HIGH);
      ("\"");
      detectar_boton();
      Serial.print(counter1);
      Serial.print(" / ");
      Serial.println(counter2);
      //Preguntas de transicion
      //      if (digitalRead() == LOW)
      //      {
      //        estado = EUNO; //Cambio de estado
      //        Serial.println("Estado: EUNO"); //Imprimo estado
      //        tini0 = millis();
      //        tini1 = millis();
      //        tini2 = millis();
      //        tini3 = millis();
      //      }
      break;
    // ------------------------------------------------------------------------------------------------------
    case EUNO:
      digitalWrite(rel1, LOW);
      digitalWrite(rel2, LOW);
      digitalWrite(relg, HIGH);
      //Serial.println(estado);
      Serial.print(counter1);
      //Serial.println("EUNO");
      //Serial.println(power1);
      Serial.print(" / ");
      //Serial.println(power2);
      Serial.println(counter2);

      //Neopixel-----------------------------------------------------------------------------------------------
      tact0 = millis();
      trel0 = tact0 - tini0;
      ant = i - 1;
      pixels.setPixelColor(i, pixels.Color(R, G, B));
      pixels.setPixelColor(i + 1, pixels.Color(R, G, B));
      pixels.setPixelColor(i + 2, pixels.Color(R, G, B));
      if (ant > -1)
      {
        pixels.setPixelColor(ant, pixels.Color(0, 0, 0));
      }
      if (i == 10)
      {
        pixels.setPixelColor(11, pixels.Color(R, G, B));
        pixels.setPixelColor(0, pixels.Color(R, G, B));
      }
      if (i == 11)
      {
        pixels.setPixelColor(0, pixels.Color(R, G, B));
        pixels.setPixelColor(1, pixels.Color(R, G, B));
      }
      if (i == 0)
      {
        pixels.setPixelColor(11, pixels.Color(0, 0, 0));
      }
      if (trel0 >= intneo)
      {
        i++;
        tini0 = millis();
      }
      if (i >= 12)
      {
        i = 0;
        tini0 = millis();
      }
      pixels.show();
      //Neopixel-----------------------------------------------------------------------------------------------

      //Valvula------------------------------------------------------------------------------------------------
      //      tact3 = millis();
      //      trel3 = tact3 - tini3;
      //      if (trel3 <= intvali)
      //      {
      //        digitalWrite(rel2, LOW);
      //      }
      //      if (trel3 > intvali)
      //      {
      //        digitalWrite(rel2, HIGH);
      //      }
      //      if (trel3 >= intvalf)
      //      {
      //        tini3 = millis();
      //      }
      //Valvula------------------------------------------------------------------------------------------------
      if (counter1 < (counter2 + rango) && counter1 > (counter2 - rango))
      {
        power1 = 64 + m1;
        power2 = 191 - m2;
      }
      if (counter1 >= (counter2 + rango) && power2 < 191 - m2 + interm)
      {
        aumento2();
        //Serial.println(power1);
      }
      if (counter1 <= (counter2 - rango) && power2 > 191 - m2 - interm)
      {
        disminuyo2();
        //Serial.println(power1);
      }

      if ( counter2 >= D1 )
      {
        ISRCounter1 = 0;
        ISRCounter2 = 0;
        power1 = 64;
        power2 = 191;
        estado = EGIROA;
        Serial.println("Estado: EGIROA");
        tini0 = millis();
        tini1 = millis();
        tini2 = millis();
        tini3 = millis();
      }
      if (digitalRead(btne) == LOW)
      {
        estado = EALARMA;
        Serial.println("Estado: EALARMA");
      }
      Serial1.write(power1);
      Serial1.write(power2);
      break;
    // ------------------------------------------------------------------------------------------------------
    case EGIROA:
      digitalWrite(rel1, LOW);
      digitalWrite(relg, HIGH);
      //Serial.println(estado);
      //Serial.println(counter1);
      //Serial.println(counter2);

      //Neopixel-----------------------------------------------------------------------------------------------
      tact0 = millis();
      trel0 = tact0 - tini0;
      ant = i - 1;
      pixels.setPixelColor(i, pixels.Color(R, G, B));
      pixels.setPixelColor(i + 1, pixels.Color(R, G, B));
      pixels.setPixelColor(i + 2, pixels.Color(R, G, B));
      if (ant > -1)
      {
        pixels.setPixelColor(ant, pixels.Color(0, 0, 0));
      }
      if (i == 10)
      {
        pixels.setPixelColor(11, pixels.Color(R, G, B));
        pixels.setPixelColor(0, pixels.Color(R, G, B));
      }
      if (i == 11)
      {
        pixels.setPixelColor(0, pixels.Color(R, G, B));
        pixels.setPixelColor(1, pixels.Color(R, G, B));
      }
      if (i == 0)
      {
        pixels.setPixelColor(11, pixels.Color(0, 0, 0));
      }
      if (trel0 >= intneo)
      {
        i++;
        tini0 = millis();
      }
      if (i >= 12)
      {
        i = 0;
        tini0 = millis();
      }
      pixels.show();
      //Neopixel-----------------------------------------------------------------------------------------------

      //Valvula------------------------------------------------------------------------------------------------
      digitalWrite(rel2, HIGH);
      //Valvula------------------------------------------------------------------------------------------------
      //Serial.println(power1);
      //Serial.print(" / ");
      //Serial.println(power2);
      if (counter1 < (counter2 + rango) && counter1 > (counter2 - rango))
      {
        power1 = 64 - m3;
        power2 = 191 - m2;
      }
      if (counter1 >= (counter2 + rango) && power2 < 191 - m2 + interm)
      {
        aumento2();
        //Serial.println(power1);
      }
      if (counter1 <= (counter2 - rango) && power2 > 191 - m2 - interm)
      {
        disminuyo2();
        //Serial.println(power1);
      }

      if (counter2 >= GA)
      {
        ISRCounter1 = 0;
        ISRCounter2 = 0;
        power1 = 64;
        power2 = 191;
        estado = EDOS;
        Serial.println("Estado: EDOS");
        tini0 = millis();
        tini1 = millis();
        tini2 = millis();
        tini3 = millis();
      }
      if (digitalRead(btne) == LOW)
      {
        estado = EALARMA;
        Serial.println("Estado: EALARMA");
      }
      Serial1.write(power1);
      Serial1.write(power2);
      break;
    // ------------------------------------------------------------------------------------------------------
    case EDOS:
      digitalWrite(rel1, LOW);
      digitalWrite(rel2, LOW);
      digitalWrite(relg, HIGH);
      //Serial.println(estado);
      //Serial.print(counter1);
      //Serial.println("EUNO");
      //Serial.println(power1);
      //Serial.print(" / ");
      //Serial.println(power2);
      //Serial.println(counter2);

      //Neopixel-----------------------------------------------------------------------------------------------
      tact0 = millis();
      trel0 = tact0 - tini0;
      ant = i - 1;
      pixels.setPixelColor(i, pixels.Color(R, G, B));
      pixels.setPixelColor(i + 1, pixels.Color(R, G, B));
      pixels.setPixelColor(i + 2, pixels.Color(R, G, B));
      if (ant > -1)
      {
        pixels.setPixelColor(ant, pixels.Color(0, 0, 0));
      }
      if (i == 10)
      {
        pixels.setPixelColor(11, pixels.Color(R, G, B));
        pixels.setPixelColor(0, pixels.Color(R, G, B));
      }
      if (i == 11)
      {
        pixels.setPixelColor(0, pixels.Color(R, G, B));
        pixels.setPixelColor(1, pixels.Color(R, G, B));
      }
      if (i == 0)
      {
        pixels.setPixelColor(11, pixels.Color(0, 0, 0));
      }
      if (trel0 >= intneo)
      {
        i++;
        tini0 = millis();
      }
      if (i >= 12)
      {
        i = 0;
        tini0 = millis();
      }
      pixels.show();
      //Neopixel-----------------------------------------------------------------------------------------------

      //Valvula------------------------------------------------------------------------------------------------
      //      tact3 = millis();
      //      trel3 = tact3 - tini3;
      //      if (trel3 <= intvali)
      //      {
      //        digitalWrite(rel2, LOW);
      //      }
      //      if (trel3 > intvali)
      //      {
      //        digitalWrite(rel2, HIGH);
      //      }
      //      if (trel3 >= intvalf)
      //      {
      //        tini3 = millis();
      //      }
      //Valvula------------------------------------------------------------------------------------------------
      if (counter1 < (counter2 + rango) && counter1 > (counter2 - rango))
      {
        power1 = 64 + m1;
        power2 = 191 - m2;
      }
      if (counter1 >= (counter2 + rango) && power2 < 191 - m2 + interm)
      {
        aumento2();
        //Serial.println(power1);
      }
      if (counter1 <= (counter2 - rango) && power2 > 191 - m2 - interm)
      {
        disminuyo2();
        //Serial.println(power1);
      }

      if ( counter2 >= D2 )
      {
        ISRCounter1 = 0;
        ISRCounter2 = 0;
        power1 = 64;
        power2 = 191;
        estado = EGIROB;
        Serial.println("Estado: EGIROB");
        tini0 = millis();
        tini1 = millis();
        tini2 = millis();
        tini3 = millis();
      }
      if (digitalRead(btne) == LOW)
      {
        estado = EALARMA;
        Serial.println("Estado: EALARMA");
      }
      Serial1.write(power1);
      Serial1.write(power2);
      break;
    // ------------------------------------------------------------------------------------------------------
    case EGIROB:
      digitalWrite(rel1, LOW);
      digitalWrite(relg, HIGH);
      //Serial.println(estado);
      //Serial.println(counter1);
      //Serial.println(counter2);

      //Neopixel-----------------------------------------------------------------------------------------------
      tact0 = millis();
      trel0 = tact0 - tini0;
      ant = i - 1;
      pixels.setPixelColor(i, pixels.Color(R, G, B));
      pixels.setPixelColor(i + 1, pixels.Color(R, G, B));
      pixels.setPixelColor(i + 2, pixels.Color(R, G, B));
      if (ant > -1)
      {
        pixels.setPixelColor(ant, pixels.Color(0, 0, 0));
      }
      if (i == 10)
      {
        pixels.setPixelColor(11, pixels.Color(R, G, B));
        pixels.setPixelColor(0, pixels.Color(R, G, B));
      }
      if (i == 11)
      {
        pixels.setPixelColor(0, pixels.Color(R, G, B));
        pixels.setPixelColor(1, pixels.Color(R, G, B));
      }
      if (i == 0)
      {
        pixels.setPixelColor(11, pixels.Color(0, 0, 0));
      }
      if (trel0 >= intneo)
      {
        i++;
        tini0 = millis();
      }
      if (i >= 12)
      {
        i = 0;
        tini0 = millis();
      }
      pixels.show();
      //Neopixel-----------------------------------------------------------------------------------------------

      //Valvula------------------------------------------------------------------------------------------------
      digitalWrite(rel2, HIGH);
      //Valvula------------------------------------------------------------------------------------------------
      //Serial.println(power1);
      //Serial.print(" / ");
      //Serial.println(power2);
      if (counter1 < (counter2 + rango) && counter1 > (counter2 - rango))
      {
        power1 = 64 + m4;
        power2 = 191 + m5;
      }
      if (counter1 >= (counter2 + rango) && power2 < 191 + m2 + interm)
      {
        aumento2();
        //Serial.println(power1);
      }
      if (counter1 <= (counter2 - rango) && power2 > 191 + m2 - interm)
      {
        disminuyo2();
        //Serial.println(power1);
      }

      if (counter2 >= GB)
      {
        ISRCounter1 = 0;
        ISRCounter2 = 0;
        power1 = 64;
        power2 = 191;
        estado = ETRES;
        Serial.println("Estado: ETRES");
        tini0 = millis();
        tini1 = millis();
        tini2 = millis();
        tini3 = millis();
      }
      if (digitalRead(btne) == LOW)
      {
        estado = EALARMA;
        Serial.println("Estado: EALARMA");
      }
      Serial1.write(power1);
      Serial1.write(power2);
      break;
    // ------------------------------------------------------------------------------------------------------
    case ETRES:
      digitalWrite(rel1, LOW);
      digitalWrite(rel2, LOW);
      digitalWrite(relg, HIGH);
      //Serial.println(estado);
      //Serial.print(counter1);
      //Serial.println("EUNO");
      //Serial.println(power1);
      //Serial.print(" / ");
      //Serial.println(power2);
      //Serial.println(counter2);

      //Neopixel-----------------------------------------------------------------------------------------------
      tact0 = millis();
      trel0 = tact0 - tini0;
      ant = i - 1;
      pixels.setPixelColor(i, pixels.Color(R, G, B));
      pixels.setPixelColor(i + 1, pixels.Color(R, G, B));
      pixels.setPixelColor(i + 2, pixels.Color(R, G, B));
      if (ant > -1)
      {
        pixels.setPixelColor(ant, pixels.Color(0, 0, 0));
      }
      if (i == 10)
      {
        pixels.setPixelColor(11, pixels.Color(R, G, B));
        pixels.setPixelColor(0, pixels.Color(R, G, B));
      }
      if (i == 11)
      {
        pixels.setPixelColor(0, pixels.Color(R, G, B));
        pixels.setPixelColor(1, pixels.Color(R, G, B));
      }
      if (i == 0)
      {
        pixels.setPixelColor(11, pixels.Color(0, 0, 0));
      }
      if (trel0 >= intneo)
      {
        i++;
        tini0 = millis();
      }
      if (i >= 12)
      {
        i = 0;
        tini0 = millis();
      }
      pixels.show();
      //Neopixel-----------------------------------------------------------------------------------------------

      //Valvula------------------------------------------------------------------------------------------------
      //      tact3 = millis();
      //      trel3 = tact3 - tini3;
      //      if (trel3 <= intvali)
      //      {
      //        digitalWrite(rel2, LOW);
      //      }
      //      if (trel3 > intvali)
      //      {
      //        digitalWrite(rel2, HIGH);
      //      }
      //      if (trel3 >= intvalf)
      //      {
      //        tini3 = millis();
      //}
      //Valvula------------------------------------------------------------------------------------------------
      if (counter1 < (counter2 + rango) && counter1 > (counter2 - rango))
      {
        power1 = 64 + m1;
        power2 = 191 - m2;
      }
      if (counter1 >= (counter2 + rango) && power2 < 191 - m2 + interm)
      {
        aumento2();
        //Serial.println(power1);
      }
      if (counter1 <= (counter2 - rango) && power2 > 191 - m2 - interm)
      {
        disminuyo2();
        //Serial.println(power1);
      }

      if ( counter2 >= D3 )
      {
        ISRCounter1 = 0;
        ISRCounter2 = 0;
        power1 = 64;
        power2 = 191;
        estado = EGIROC;
        Serial.println("Estado: EGIROC");
        tini0 = millis();
        tini1 = millis();
        tini2 = millis();
        tini3 = millis();
      }
      if (digitalRead(btne) == LOW)
      {
        estado = EALARMA;
        Serial.println("Estado: EALARMA");
      }
      Serial1.write(power1);
      Serial1.write(power2);
      break;
    // ------------------------------------------------------------------------------------------------------
    case EGIROC:
      digitalWrite(rel1, LOW);
      digitalWrite(relg, HIGH);
      //Serial.println(estado);
      //Serial.println(counter1);
      //Serial.println(counter2);

      //Neopixel-----------------------------------------------------------------------------------------------
      tact0 = millis();
      trel0 = tact0 - tini0;
      ant = i - 1;
      pixels.setPixelColor(i, pixels.Color(R, G, B));
      pixels.setPixelColor(i + 1, pixels.Color(R, G, B));
      pixels.setPixelColor(i + 2, pixels.Color(R, G, B));
      if (ant > -1)
      {
        pixels.setPixelColor(ant, pixels.Color(0, 0, 0));
      }
      if (i == 10)
      {
        pixels.setPixelColor(11, pixels.Color(R, G, B));
        pixels.setPixelColor(0, pixels.Color(R, G, B));
      }
      if (i == 11)
      {
        pixels.setPixelColor(0, pixels.Color(R, G, B));
        pixels.setPixelColor(1, pixels.Color(R, G, B));
      }
      if (i == 0)
      {
        pixels.setPixelColor(11, pixels.Color(0, 0, 0));
      }
      if (trel0 >= intneo)
      {
        i++;
        tini0 = millis();
      }
      if (i >= 12)
      {
        i = 0;
        tini0 = millis();
      }
      pixels.show();
      //Neopixel-----------------------------------------------------------------------------------------------

      //Valvula------------------------------------------------------------------------------------------------
      digitalWrite(rel2, HIGH);
      //Valvula------------------------------------------------------------------------------------------------
      //Serial.println(power1);
      //Serial.print(" / ");
      //Serial.println(power2);
      if (counter1 < (counter2 + rango) && counter1 > (counter2 - rango))
      {
        power1 = 64 + m4;
        power2 = 191 + m5;
      }
      if (counter1 >= (counter2 + rango) && power2 < 191 + m2 + interm)
      {
        aumento2();
        //Serial.println(power1);
      }
      if (counter1 <= (counter2 - rango) && power2 > 191 + m2 - interm)
      {
        disminuyo2();
        //Serial.println(power1);
      }

      if (counter2 >= GC)
      {
        ISRCounter1 = 0;
        ISRCounter2 = 0;
        power1 = 64;
        power2 = 191;
        estado = ECUATRO;
        Serial.println("Estado: ECUATRO");
        tini0 = millis();
        tini1 = millis();
        tini2 = millis();
        tini3 = millis();
      }
      if (digitalRead(btne) == LOW)
      {
        estado = EALARMA;
        Serial.println("Estado: EALARMA");
      }
      Serial1.write(power1);
      Serial1.write(power2);
      break;
    // ------------------------------------------------------------------------------------------------------
    case ECUATRO:
      digitalWrite(rel1, LOW);
      digitalWrite(rel2, LOW);
      digitalWrite(relg, HIGH);
      //Serial.println(estado);
      //Serial.print(counter1);
      //Serial.println("EUNO");
      //Serial.println(power1);
      //Serial.print(" / ");
      //Serial.println(power2);
      //Serial.println(counter2);

      //Neopixel-----------------------------------------------------------------------------------------------
      tact0 = millis();
      trel0 = tact0 - tini0;
      ant = i - 1;
      pixels.setPixelColor(i, pixels.Color(R, G, B));
      pixels.setPixelColor(i + 1, pixels.Color(R, G, B));
      pixels.setPixelColor(i + 2, pixels.Color(R, G, B));
      if (ant > -1)
      {
        pixels.setPixelColor(ant, pixels.Color(0, 0, 0));
      }
      if (i == 10)
      {
        pixels.setPixelColor(11, pixels.Color(R, G, B));
        pixels.setPixelColor(0, pixels.Color(R, G, B));
      }
      if (i == 11)
      {
        pixels.setPixelColor(0, pixels.Color(R, G, B));
        pixels.setPixelColor(1, pixels.Color(R, G, B));
      }
      if (i == 0)
      {
        pixels.setPixelColor(11, pixels.Color(0, 0, 0));
      }
      if (trel0 >= intneo)
      {
        i++;
        tini0 = millis();
      }
      if (i >= 12)
      {
        i = 0;
        tini0 = millis();
      }
      pixels.show();
      //Neopixel-----------------------------------------------------------------------------------------------

      //Valvula------------------------------------------------------------------------------------------------
      //      tact3 = millis();
      //      trel3 = tact3 - tini3;
      //      if (trel3 <= intvali)
      //      {
      //        digitalWrite(rel2, LOW);
      //      }
      //      if (trel3 > intvali)
      //      {
      //        digitalWrite(rel2, HIGH);
      //      }
      //      if (trel3 >= intvalf)
      //      {
      //        tini3 = millis();
      //      }
      //Valvula------------------------------------------------------------------------------------------------
      if (counter1 < (counter2 + rango) && counter1 > (counter2 - rango))
      {
        power1 = 64 + m1;
        power2 = 191 - m2;
      }
      if (counter1 >= (counter2 + rango) && power2 < 191 - m2 + interm)
      {
        aumento2();
        //Serial.println(power1);
      }
      if (counter1 <= (counter2 - rango) && power2 > 191 - m2 - interm)
      {
        disminuyo2();
        //Serial.println(power1);
      }

      if ( counter2 >= D4 )
      {
        ISRCounter1 = 0;
        ISRCounter2 = 0;
        power1 = 64;
        power2 = 191;
        estado = EGIROD;
        Serial.println("Estado: EGIROD");
        tini0 = millis();
        tini1 = millis();
        tini2 = millis();
        tini3 = millis();
      }
      if (digitalRead(btne) == LOW)
      {
        estado = EALARMA;
        Serial.println("Estado: EALARMA");
      }
      Serial1.write(power1);
      Serial1.write(power2);
      break;
    // ------------------------------------------------------------------------------------------------------
    case EGIROD:
      digitalWrite(rel1, LOW);
      digitalWrite(relg, HIGH);
      //Serial.println(estado);
      //Serial.println(counter1);
      //Serial.println(counter2);

      //Neopixel-----------------------------------------------------------------------------------------------
      tact0 = millis();
      trel0 = tact0 - tini0;
      ant = i - 1;
      pixels.setPixelColor(i, pixels.Color(R, G, B));
      pixels.setPixelColor(i + 1, pixels.Color(R, G, B));
      pixels.setPixelColor(i + 2, pixels.Color(R, G, B));
      if (ant > -1)
      {
        pixels.setPixelColor(ant, pixels.Color(0, 0, 0));
      }
      if (i == 10)
      {
        pixels.setPixelColor(11, pixels.Color(R, G, B));
        pixels.setPixelColor(0, pixels.Color(R, G, B));
      }
      if (i == 11)
      {
        pixels.setPixelColor(0, pixels.Color(R, G, B));
        pixels.setPixelColor(1, pixels.Color(R, G, B));
      }
      if (i == 0)
      {
        pixels.setPixelColor(11, pixels.Color(0, 0, 0));
      }
      if (trel0 >= intneo)
      {
        i++;
        tini0 = millis();
      }
      if (i >= 12)
      {
        i = 0;
        tini0 = millis();
      }
      pixels.show();
      //Neopixel-----------------------------------------------------------------------------------------------

      //Valvula------------------------------------------------------------------------------------------------
      digitalWrite(rel2, HIGH);
      //Valvula------------------------------------------------------------------------------------------------
      //Serial.println(power1);
      //Serial.print(" / ");
      //Serial.println(power2);
      if (counter1 < (counter2 + rango) && counter1 > (counter2 - rango))
      {
        power1 = 64 + m4;
        power2 = 191 + m5;
      }
      if (counter1 >= (counter2 + rango) && power2 < 191 + m2 + interm)
      {
        aumento2();
        //Serial.println(power1);
      }
      if (counter1 <= (counter2 - rango) && power2 > 191 + m2 - interm)
      {
        disminuyo2();
        //Serial.println(power1);
      }

      if (counter2 >= GD)
      {
        ISRCounter1 = 0;
        ISRCounter2 = 0;
        power1 = 64;
        power2 = 191;
        estado = ECINCO;
        Serial.println("Estado: ECINCO");
        tini0 = millis();
        tini1 = millis();
        tini2 = millis();
        tini3 = millis();
      }
      if (digitalRead(btne) == LOW)
      {
        estado = EALARMA;
        Serial.println("Estado: EALARMA");
      }
      Serial1.write(power1);
      Serial1.write(power2);
      break;
    // ------------------------------------------------------------------------------------------------------
    case ECINCO:
      digitalWrite(rel1, LOW);
      digitalWrite(rel2, LOW);
      digitalWrite(relg, HIGH);
      //Serial.println(estado);
      //Serial.print(counter1);
      //Serial.println("EUNO");
      //Serial.println(power1);
      //Serial.print(" / ");
      //Serial.println(power2);
      //Serial.println(counter2);

      //Neopixel-----------------------------------------------------------------------------------------------
      tact0 = millis();
      trel0 = tact0 - tini0;
      ant = i - 1;
      pixels.setPixelColor(i, pixels.Color(R, G, B));
      pixels.setPixelColor(i + 1, pixels.Color(R, G, B));
      pixels.setPixelColor(i + 2, pixels.Color(R, G, B));
      if (ant > -1)
      {
        pixels.setPixelColor(ant, pixels.Color(0, 0, 0));
      }
      if (i == 10)
      {
        pixels.setPixelColor(11, pixels.Color(R, G, B));
        pixels.setPixelColor(0, pixels.Color(R, G, B));
      }
      if (i == 11)
      {
        pixels.setPixelColor(0, pixels.Color(R, G, B));
        pixels.setPixelColor(1, pixels.Color(R, G, B));
      }
      if (i == 0)
      {
        pixels.setPixelColor(11, pixels.Color(0, 0, 0));
      }
      if (trel0 >= intneo)
      {
        i++;
        tini0 = millis();
      }
      if (i >= 12)
      {
        i = 0;
        tini0 = millis();
      }
      pixels.show();
      //Neopixel-----------------------------------------------------------------------------------------------

      //Valvula------------------------------------------------------------------------------------------------
      //      tact3 = millis();
      //      trel3 = tact3 - tini3;
      //      if (trel3 <= intvali)
      //      {
      //        digitalWrite(rel2, LOW);
      //      }
      //      if (trel3 > intvali)
      //      {
      //        digitalWrite(rel2, HIGH);
      //      }
      //      if (trel3 >= intvalf)
      //      {
      //        tini3 = millis();
      //      }
      //Valvula------------------------------------------------------------------------------------------------
      if (counter1 < (counter2 + rango) && counter1 > (counter2 - rango))
      {
        power1 = 64 + m1;
        power2 = 191 - m2;
      }
      if (counter1 >= (counter2 + rango) && power2 < 191 - m2 + interm)
      {
        aumento2();
        //Serial.println(power1);
      }
      if (counter1 <= (counter2 - rango) && power2 > 191 - m2 - interm)
      {
        disminuyo2();
        //Serial.println(power1);
      }

      if ( counter2 >= D5 )
      {
        ISRCounter1 = 0;
        ISRCounter2 = 0;
        power1 = 64;
        power2 = 191;
        estado = EGIROE;
        Serial.println("Estado: EGIROE");
        tini0 = millis();
        tini1 = millis();
        tini2 = millis();
        tini3 = millis();
      }
      if (digitalRead(btne) == LOW)
      {
        estado = EALARMA;
        Serial.println("Estado: EALARMA");
      }
      Serial1.write(power1);
      Serial1.write(power2);
      break;
    // ------------------------------------------------------------------------------------------------------
    case EGIROE:
      digitalWrite(rel1, LOW);
      digitalWrite(relg, HIGH);
      //Serial.println(estado);
      //Serial.println(counter1);
      //Serial.println(counter2);

      //Neopixel-----------------------------------------------------------------------------------------------
      tact0 = millis();
      trel0 = tact0 - tini0;
      ant = i - 1;
      pixels.setPixelColor(i, pixels.Color(R, G, B));
      pixels.setPixelColor(i + 1, pixels.Color(R, G, B));
      pixels.setPixelColor(i + 2, pixels.Color(R, G, B));
      if (ant > -1)
      {
        pixels.setPixelColor(ant, pixels.Color(0, 0, 0));
      }
      if (i == 10)
      {
        pixels.setPixelColor(11, pixels.Color(R, G, B));
        pixels.setPixelColor(0, pixels.Color(R, G, B));
      }
      if (i == 11)
      {
        pixels.setPixelColor(0, pixels.Color(R, G, B));
        pixels.setPixelColor(1, pixels.Color(R, G, B));
      }
      if (i == 0)
      {
        pixels.setPixelColor(11, pixels.Color(0, 0, 0));
      }
      if (trel0 >= intneo)
      {
        i++;
        tini0 = millis();
      }
      if (i >= 12)
      {
        i = 0;
        tini0 = millis();
      }
      pixels.show();
      //Neopixel-----------------------------------------------------------------------------------------------

      //Valvula------------------------------------------------------------------------------------------------
      digitalWrite(rel2, HIGH);
      //Valvula------------------------------------------------------------------------------------------------
      //Serial.println(power1);
      //Serial.print(" / ");
      //Serial.println(power2);
      if (counter1 < (counter2 + rango) && counter1 > (counter2 - rango))
      {
        power1 = 64 - m3;
        power2 = 191 - m2;
      }
      if (counter1 >= (counter2 + rango) && power2 < 191 - m2 + interm)
      {
        aumento2();
        //Serial.println(power1);
      }
      if (counter1 <= (counter2 - rango) && power2 > 191 - m2 - interm)
      {
        disminuyo2();
        //Serial.println(power1);
      }
      if (counter2 >= GE)
      {
        ISRCounter1 = 0;
        ISRCounter2 = 0;
        power1 = 64;
        power2 = 191;
        estado = ESEIS;
        Serial.println("Estado: ESEIS");
        tini0 = millis();
        tini1 = millis();
        tini2 = millis();
        tini3 = millis();
      }
      if (digitalRead(btne) == LOW)
      {
        estado = EALARMA;
        Serial.println("Estado: EALARMA");
      }
      Serial1.write(power1);
      Serial1.write(power2);
      break;
    // ------------------------------------------------------------------------------------------------------
    case ESEIS:
      digitalWrite(rel1, LOW);
      digitalWrite(rel2, LOW);
      digitalWrite(relg, HIGH);
      //Serial.println(estado);
      //Serial.print(counter1);
      //Serial.println("EUNO");
      //Serial.println(power1);
      //Serial.print(" / ");
      //Serial.println(power2);
      //Serial.println(counter2);

      //Neopixel-----------------------------------------------------------------------------------------------
      tact0 = millis();
      trel0 = tact0 - tini0;
      ant = i - 1;
      pixels.setPixelColor(i, pixels.Color(R, G, B));
      pixels.setPixelColor(i + 1, pixels.Color(R, G, B));
      pixels.setPixelColor(i + 2, pixels.Color(R, G, B));
      if (ant > -1)
      {
        pixels.setPixelColor(ant, pixels.Color(0, 0, 0));
      }
      if (i == 10)
      {
        pixels.setPixelColor(11, pixels.Color(R, G, B));
        pixels.setPixelColor(0, pixels.Color(R, G, B));
      }
      if (i == 11)
      {
        pixels.setPixelColor(0, pixels.Color(R, G, B));
        pixels.setPixelColor(1, pixels.Color(R, G, B));
      }
      if (i == 0)
      {
        pixels.setPixelColor(11, pixels.Color(0, 0, 0));
      }
      if (trel0 >= intneo)
      {
        i++;
        tini0 = millis();
      }
      if (i >= 12)
      {
        i = 0;
        tini0 = millis();
      }
      pixels.show();
      //Neopixel-----------------------------------------------------------------------------------------------

      //Valvula------------------------------------------------------------------------------------------------
      //      tact3 = millis();
      //      trel3 = tact3 - tini3;
      //      if (trel3 <= intvali)
      //      {
      //        digitalWrite(rel2, LOW);
      //      }
      //      if (trel3 > intvali)
      //      {
      //        digitalWrite(rel2, HIGH);
      //      }
      //      if (trel3 >= intvalf)
      //      {
      //        tini3 = millis();
      //      }
      //Valvula------------------------------------------------------------------------------------------------
      if (counter1 < (counter2 + rango) && counter1 > (counter2 - rango))
      {
        power1 = 64 + m1;
        power2 = 191 - m2;
      }
      if (counter1 >= (counter2 + rango) && power2 < 191 - m2 + interm)
      {
        aumento2();
        //Serial.println(power1);
      }
      if (counter1 <= (counter2 - rango) && power2 > 191 - m2 - interm)
      {
        disminuyo2();
        //Serial.println(power1);
      }

      if ( counter2 >= D6 )
      {
        ISRCounter1 = 0;
        ISRCounter2 = 0;
        power1 = 64;
        power2 = 191;
        estado = EGIROF;
        Serial.println("Estado: EGIROF");
        tini0 = millis();
        tini1 = millis();
        tini2 = millis();
        tini3 = millis();
      }
      if (digitalRead(btne) == LOW)
      {
        estado = EALARMA;
        Serial.println("Estado: EALARMA");
      }
      Serial1.write(power1);
      Serial1.write(power2);
      break;
    // ------------------------------------------------------------------------------------------------------
    case EGIROF:
      digitalWrite(rel1, LOW);
      digitalWrite(relg, HIGH);
      //Serial.println(estado);
      //Serial.println(counter1);
      //Serial.println(counter2);

      //Neopixel-----------------------------------------------------------------------------------------------
      tact0 = millis();
      trel0 = tact0 - tini0;
      ant = i - 1;
      pixels.setPixelColor(i, pixels.Color(R, G, B));
      pixels.setPixelColor(i + 1, pixels.Color(R, G, B));
      pixels.setPixelColor(i + 2, pixels.Color(R, G, B));
      if (ant > -1)
      {
        pixels.setPixelColor(ant, pixels.Color(0, 0, 0));
      }
      if (i == 10)
      {
        pixels.setPixelColor(11, pixels.Color(R, G, B));
        pixels.setPixelColor(0, pixels.Color(R, G, B));
      }
      if (i == 11)
      {
        pixels.setPixelColor(0, pixels.Color(R, G, B));
        pixels.setPixelColor(1, pixels.Color(R, G, B));
      }
      if (i == 0)
      {
        pixels.setPixelColor(11, pixels.Color(0, 0, 0));
      }
      if (trel0 >= intneo)
      {
        i++;
        tini0 = millis();
      }
      if (i >= 12)
      {
        i = 0;
        tini0 = millis();
      }
      pixels.show();
      //Neopixel-----------------------------------------------------------------------------------------------

      //Valvula------------------------------------------------------------------------------------------------
      digitalWrite(rel2, HIGH);
      //Valvula------------------------------------------------------------------------------------------------
      //Serial.println(power1);
      //Serial.print(" / ");
      //Serial.println(power2);
      if (counter1 < (counter2 + rango) && counter1 > (counter2 - rango))
      {
        power1 = 64 + m4;
        power2 = 191 + m5;
      }
      if (counter1 >= (counter2 + rango) && power2 < 191 + m2 + interm)
      {
        aumento2();
        //Serial.println(power1);
      }
      if (counter1 <= (counter2 - rango) && power2 > 191 + m2 - interm)
      {
        disminuyo2();
        //Serial.println(power1);
      }

      if (counter2 >= GF)
      {
        ISRCounter1 = 0;
        ISRCounter2 = 0;
        power1 = 64;
        power2 = 191;
        estado = ESIETE;
        Serial.println("Estado: ESIETE");
        tini0 = millis();
        tini1 = millis();
        tini2 = millis();
        tini3 = millis();
      }
      if (digitalRead(btne) == LOW)
      {
        estado = EALARMA;
        Serial.println("Estado: EALARMA");
      }
      Serial1.write(power1);
      Serial1.write(power2);
      break;
    // ------------------------------------------------------------------------------------------------------
    case ESIETE:
      digitalWrite(rel1, LOW);
      digitalWrite(rel2, LOW);
      digitalWrite(relg, HIGH);
      //Serial.println(estado);
      //Serial.print(counter1);
      //Serial.println("EUNO");
      //Serial.println(power1);
      //Serial.print(" / ");
      //Serial.println(power2);
      //Serial.println(counter2);

      //Neopixel-----------------------------------------------------------------------------------------------
      tact0 = millis();
      trel0 = tact0 - tini0;
      ant = i - 1;
      pixels.setPixelColor(i, pixels.Color(R, G, B));
      pixels.setPixelColor(i + 1, pixels.Color(R, G, B));
      pixels.setPixelColor(i + 2, pixels.Color(R, G, B));
      if (ant > -1)
      {
        pixels.setPixelColor(ant, pixels.Color(0, 0, 0));
      }
      if (i == 10)
      {
        pixels.setPixelColor(11, pixels.Color(R, G, B));
        pixels.setPixelColor(0, pixels.Color(R, G, B));
      }
      if (i == 11)
      {
        pixels.setPixelColor(0, pixels.Color(R, G, B));
        pixels.setPixelColor(1, pixels.Color(R, G, B));
      }
      if (i == 0)
      {
        pixels.setPixelColor(11, pixels.Color(0, 0, 0));
      }
      if (trel0 >= intneo)
      {
        i++;
        tini0 = millis();
      }
      if (i >= 12)
      {
        i = 0;
        tini0 = millis();
      }
      pixels.show();
      //Neopixel-----------------------------------------------------------------------------------------------

      //Valvula------------------------------------------------------------------------------------------------
//      tact3 = millis();
//      trel3 = tact3 - tini3;
//      if (trel3 <= intvali)
//      {
//        digitalWrite(rel2, LOW);
//      }
//      if (trel3 > intvali)
//      {
//        digitalWrite(rel2, HIGH);
//      }
//      if (trel3 >= intvalf)
//      {
//        tini3 = millis();
//      }
      //Valvula------------------------------------------------------------------------------------------------
      if (counter1 < (counter2 + rango) && counter1 > (counter2 - rango))
      {
        power1 = 64 + m1;
        power2 = 191 - m2;
      }
      if (counter1 >= (counter2 + rango) && power2 < 191 - m2 + interm)
      {
        aumento2();
        //Serial.println(power1);
      }
      if (counter1 <= (counter2 - rango) && power2 > 191 - m2 - interm)
      {
        disminuyo2();
        //Serial.println(power1);
      }

      if ( counter2 >= D7 )
      {
        ISRCounter1 = 0;
        ISRCounter2 = 0;
        power1 = 64;
        power2 = 191;
        estado = EGIROG;
        Serial.println("Estado: EGIROG");
        tini0 = millis();
        tini1 = millis();
        tini2 = millis();
        tini3 = millis();
      }
      if (digitalRead(btne) == LOW)
      {
        estado = EALARMA;
        Serial.println("Estado: EALARMA");
      }
      Serial1.write(power1);
      Serial1.write(power2);
      break;
    // ------------------------------------------------------------------------------------------------------
    case EGIROG:
      digitalWrite(rel1, LOW);
      digitalWrite(relg, HIGH);
      //Serial.println(estado);
      //Serial.println(counter1);
      //Serial.println(counter2);

      //Neopixel-----------------------------------------------------------------------------------------------
      tact0 = millis();
      trel0 = tact0 - tini0;
      ant = i - 1;
      pixels.setPixelColor(i, pixels.Color(R, G, B));
      pixels.setPixelColor(i + 1, pixels.Color(R, G, B));
      pixels.setPixelColor(i + 2, pixels.Color(R, G, B));
      if (ant > -1)
      {
        pixels.setPixelColor(ant, pixels.Color(0, 0, 0));
      }
      if (i == 10)
      {
        pixels.setPixelColor(11, pixels.Color(R, G, B));
        pixels.setPixelColor(0, pixels.Color(R, G, B));
      }
      if (i == 11)
      {
        pixels.setPixelColor(0, pixels.Color(R, G, B));
        pixels.setPixelColor(1, pixels.Color(R, G, B));
      }
      if (i == 0)
      {
        pixels.setPixelColor(11, pixels.Color(0, 0, 0));
      }
      if (trel0 >= intneo)
      {
        i++;
        tini0 = millis();
      }
      if (i >= 12)
      {
        i = 0;
        tini0 = millis();
      }
      pixels.show();
      //Neopixel-----------------------------------------------------------------------------------------------

      //Valvula------------------------------------------------------------------------------------------------
      digitalWrite(rel2, HIGH);
      //Valvula------------------------------------------------------------------------------------------------
      //Serial.println(power1);
      //Serial.print(" / ");
      //Serial.println(power2);
      if (counter1 < (counter2 + rango) && counter1 > (counter2 - rango))
      {
        power1 = 64 + m4;
        power2 = 191 + m5;
      }
      if (counter1 >= (counter2 + rango) && power2 < 191 + m2 + interm)
      {
        aumento2();
        //Serial.println(power1);
      }
      if (counter1 <= (counter2 - rango) && power2 > 191 + m2 - interm)
      {
        disminuyo2();
        //Serial.println(power1);
      }

      if (counter2 >= GG)
      {
        ISRCounter1 = 0;
        ISRCounter2 = 0;
        power1 = 64;
        power2 = 191;
        estado = EFIN;
        Serial.println("Estado: EFIN");
        tini0 = millis();
        tini1 = millis();
        tini2 = millis();
        tini3 = millis();
      }
      if (digitalRead(btne) == LOW)
      {
        estado = EALARMA;
        Serial.println("Estado: EALARMA");
      }
      Serial1.write(power1);
      Serial1.write(power2);
      break;
    // ------------------------------------------------------------------------------------------------------
    case EALARMA:
      trel0 = tact0 - tini0;
      digitalWrite(rel1, HIGH);
      digitalWrite(rel2, HIGH);
      digitalWrite(relg, LOW);
      pixels.setPixelColor(0, pixels.Color(0, 0, 0));
      if (trel0 <= intneoi)
      {
        pixels.setPixelColor(0, pixels.Color(255, 0, 0));
        pixels.setPixelColor(1, pixels.Color(255, 0, 0));
        pixels.setPixelColor(2, pixels.Color(255, 0, 0));
        pixels.setPixelColor(3, pixels.Color(255, 0, 0));
        pixels.setPixelColor(4, pixels.Color(255, 0, 0));
        pixels.setPixelColor(5, pixels.Color(255, 0, 0));
        pixels.setPixelColor(6, pixels.Color(255, 0, 0));
        pixels.setPixelColor(7, pixels.Color(255, 0, 0));
        pixels.setPixelColor(8, pixels.Color(255, 0, 0));
        pixels.setPixelColor(9, pixels.Color(255, 0, 0));
        pixels.setPixelColor(10, pixels.Color(255, 0, 0));
        pixels.setPixelColor(11, pixels.Color(255, 0, 0));
      }
      if (trel0 > intneoi)
      {
        pixels.setPixelColor(0, pixels.Color(0, 0, 0));
        pixels.setPixelColor(1, pixels.Color(0, 0, 0));
        pixels.setPixelColor(2, pixels.Color(0, 0, 0));
        pixels.setPixelColor(3, pixels.Color(0, 0, 0));
        pixels.setPixelColor(4, pixels.Color(0, 0, 0));
        pixels.setPixelColor(5, pixels.Color(0, 0, 0));
        pixels.setPixelColor(6, pixels.Color(0, 0, 0));
        pixels.setPixelColor(7, pixels.Color(0, 0, 0));
        pixels.setPixelColor(8, pixels.Color(0, 0, 0));
        pixels.setPixelColor(9, pixels.Color(0, 0, 0));
        pixels.setPixelColor(10, pixels.Color(0, 0, 0));
        pixels.setPixelColor(11, pixels.Color(0, 0, 0));
      }
      if (trel0 == intneof)
      {
        tini0 = millis();
        Serial.println("Estado: EALARMA");
      }
      if (digitalRead(btne) == HIGH)
      {
        ISRCounter1 = 0;
        ISRCounter2 = 0;
        power1 = 64;
        power2 = 191;
        estado = EINI;
        Serial.println("Estado: EINI");
        tini0 = millis();
        tini1 = millis();
        tini2 = millis();
        tini3 = millis();
      }
      pixels.show();   // Send the updated pixel colors to the hardware.
      break;

    // ------------------------------------------------------------------------------------------------------
    case EFIN:
      trel0 = tact0 - tini0;
      digitalWrite(rel1, HIGH);
      digitalWrite(rel2, HIGH);
      digitalWrite(relg, LOW);
      pixels.setPixelColor(0, pixels.Color(0, 0, 0));
      if (trel0 <= intneoi)
      {
        pixels.setPixelColor(0, pixels.Color(0, 255, 0));
        pixels.setPixelColor(1, pixels.Color(0, 255, 0));
        pixels.setPixelColor(2, pixels.Color(0, 255, 0));
        pixels.setPixelColor(3, pixels.Color(0, 255, 0));
        pixels.setPixelColor(4, pixels.Color(0, 255, 0));
        pixels.setPixelColor(5, pixels.Color(0, 255, 0));
        pixels.setPixelColor(6, pixels.Color(0, 255, 0));
        pixels.setPixelColor(7, pixels.Color(0, 255, 0));
        pixels.setPixelColor(8, pixels.Color(0, 255, 0));
        pixels.setPixelColor(9, pixels.Color(0, 255, 0));
        pixels.setPixelColor(10, pixels.Color(0, 255, 0));
        pixels.setPixelColor(11, pixels.Color(0, 255, 0));
      }
      if (trel0 > intneoi)
      {
        pixels.setPixelColor(0, pixels.Color(0, 0, 0));
        pixels.setPixelColor(1, pixels.Color(0, 0, 0));
        pixels.setPixelColor(2, pixels.Color(0, 0, 0));
        pixels.setPixelColor(3, pixels.Color(0, 0, 0));
        pixels.setPixelColor(4, pixels.Color(0, 0, 0));
        pixels.setPixelColor(5, pixels.Color(0, 0, 0));
        pixels.setPixelColor(6, pixels.Color(0, 0, 0));
        pixels.setPixelColor(7, pixels.Color(0, 0, 0));
        pixels.setPixelColor(8, pixels.Color(0, 0, 0));
        pixels.setPixelColor(9, pixels.Color(0, 0, 0));
        pixels.setPixelColor(10, pixels.Color(0, 0, 0));
        pixels.setPixelColor(11, pixels.Color(0, 0, 0));
      }
      if (trel0 == intneof)
      {
        tini0 = millis();
        Serial.println("Estado: EALARMA");
      }
      if (digitalRead(btne) == LOW)
      {
        ISRCounter1 = 0;
        ISRCounter2 = 0;
        power1 = 64;
        power2 = 191;
        estado = EALARMA;
        Serial.println("Estado: EALARMA");
        tini0 = millis();
        tini1 = millis();
        tini2 = millis();
        tini3 = millis();
      }
      pixels.show();   // Send the updated pixel colors to the hardware.
      break;
  }
}
void interruptCount1()
{
  ISRCounter1++;
}
void interruptCount2()
{
  ISRCounter2++;
}
