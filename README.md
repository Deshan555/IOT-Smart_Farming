# IOT Smart Farming System 🌱🌾🚜

Welcome to the IOT Smart Farming System! This innovative solution is built on IoT technologies, empowering growers and farmers to enhance productivity and reduce waste. The system efficiently monitors crop fields using various sensors such as light, humidity, temperature, soil moisture, crop health, etc. It also automates the irrigation process, ensuring that crops receive optimal care and attention.

![alt-text](https://github.com/Deshan555/IOT-Smart_Farming/blob/main/Application%20Screenshots/Untitled%20Diagram.drawio.png)

## Installation Procedure 📥

1. **Download the Project Files**
   - Download the project source files as a zip file or clone the project using the git clone command.

2. **Prepare the Database**
   - Install a MySQL client on your computer and import the 'data store.sql' file into your MySQL client. You can also use an online MySQL service for this purpose.

3. **Install JDK (Java Development Kit)**
   - The entire project is written in Java, so you need to install JDK before using it.

4. **Optionally Use the .exe Installer**
   - If you prefer a simpler installation process, you can use the .exe installer. It will automatically install Java along with the application.

5. **Sensor and Application Configuration**
   - The 'devices' folder contains all Arduino source files related to the system.
   - The 'Python Core' folder contains the application that acts as a bridge between sensors and the database server. Execute run.bat in this folder.
   - Run the Iceburg Application and update the database settings according to your environment.

## Sensor Box - 1 📦

Sensor Box one includes two sensors:
- DHT11 or DHT22 for Temperature and Humidity readings.
- MQ135 Gas Sensor for Gas Level measurements (P.P.M - Parts Per Million).

Data collected using these sensors includes:
- Temperature
- Humidity
- Heat Index (also known as "feels-like" temperature)
- Gas Level (P.P.M)

![alt text](https://github.com/Deshan555/IOT-Smart_Farming/blob/main/Application%20Screenshots/sensor%20box%201.jpg)

## Sensor Box - 2 📦

Sensor Box two includes two sensors:
- Water Level Sensor for measuring water level in the hydroponic system.
- Soil Moisture Sensor for measuring soil moisture.

Data collected using these sensors includes:
- Water Level in hydroponic system
- Soil Moisture

![alt text](https://github.com/Deshan555/IOT-Smart_Farming/blob/main/Application%20Screenshots/sensor%20box%202.jpg)

## Automation Box 📦

Sensor box three includes one component:
- Low-level trigger and NodeMCU for automation purposes.

![alt text](https://github.com/Deshan555/IOT-Smart_Farming/blob/main/Application%20Screenshots/Automation-box.jpg)

## Application Screenshots 🖥️

![alt text](https://github.com/Deshan555/IOT-Smart_Farming/blob/main/Application%20Screenshots/Screenshot_1.png)

![alt text](https://github.com/Deshan555/IOT-Smart_Farming/blob/main/Application%20Screenshots/Screenshot_2.png)

![alt text](https://github.com/Deshan555/IOT-Smart_Farming/blob/main/Application%20Screenshots/Screenshot_3.png)

![alt text](https://github.com/Deshan555/IOT-Smart_Farming/blob/main/Application%20Screenshots/Screenshot_4.png)

![alt text](https://github.com/Deshan555/IOT-Smart_Farming/blob/main/Application%20Screenshots/Screenshot_5.png)

![alt text](https://github.com/Deshan555/IOT-Smart_Farming/blob/main/Application%20Screenshots/Screenshot_6.png)

Our IOT Smart Farming System provides farmers with the data and automation they need to make informed decisions and optimize their farming operations. Feel free to explore, contribute, and customize the system to suit your specific requirements. Happy farming and coding! 🌾🚜😊
