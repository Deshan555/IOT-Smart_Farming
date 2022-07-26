// Sensor pins
#define sensorPower 7

#define sensorPin A5

int Anlog_read = 0;

int prev=0;

int pres=0;

// Value for storing water level
int val = 0;

void setup() 
{
  // Set D7 as an OUTPUT
  pinMode(sensorPower, OUTPUT);
  
  // Set to LOW so no power flows through the sensor
  digitalWrite(sensorPower, LOW);
  
  Serial.begin(9600);
}

void loop() {
  //get the reading from the function below and print it
  int level = readSensor();
  
  Serial.print(level);

  Serial.print("\t");

  Anlog_read = analogRead(A0);
  
  Anlog_read = map(Anlog_read,0,982,148,0);
  
  pres = Anlog_read;
  
  if(Anlog_read>100)
  {
    Anlog_read = 100;
  }
  else if(Anlog_read<0)
  {
    Anlog_read = 0;
  }
  
  Serial.print(Anlog_read);

  Serial.print("\n");
  
  prev = Anlog_read;
  
  delay(30000);
}

//This is a function used to get the reading

int readSensor() {
  
  digitalWrite(sensorPower, HIGH);  // Turn the sensor ON
  
  delay(10);              // wait 10 milliseconds
  
  val = analogRead(sensorPin);    // Read the analog value form sensor
  
  digitalWrite(sensorPower, LOW);   // Turn the sensor OFF
  
  return val;             // send current reading
}
