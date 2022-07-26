
/*
 * Atmospheric CO2 Level..............400ppm
 * Average indoor co2.............350-450ppm
 * Maxiumum acceptable co2...........1000ppm
 * Dangerous co2 levels.............>2000ppm
 */

#include "DHT.h"        // including the library of DHT11 temperature and humidity sensor

#define DHTTYPE DHT11   // DHT 

#define dht_dpin D6

#define gas A0

#define LED D0 

DHT dht(dht_dpin, DHTTYPE);

const int buzzer =  4;

void setup(void)
{ 
  dht.begin();
  
  Serial.begin(9600);
  
  pinMode(gas, INPUT);

  pinMode(buzzer, OUTPUT);

  pinMode(LED, OUTPUT);
  
  delay(700);
}


void loop()
{
    float humidityC = dht.readHumidity();
    
    float temp = dht.readTemperature();
    
    float heatIndexC = dht.computeHeatIndex(temp, humidityC, false);

    // Serial Print Of Data

    Serial.print(humidityC);
    
    Serial.print("\t");
    
    Serial.print(temp); 
    
    Serial.print("\t");
    
    Serial.print(heatIndexC);
    
    Serial.print("\t");
    
    Serial.println(analogRead(gas));

    if(analogRead(gas)>1000)
    {
      digitalWrite(buzzer, HIGH);

      digitalWrite(LED, HIGH);
      
      delay(300);
      
      digitalWrite(buzzer, LOW);
      
      delay(100);
    }

    digitalWrite(buzzer, LOW);

    digitalWrite(LED, LOW);

    delay(30000);
}
      

