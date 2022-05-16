import sqlite3 as lite_sql

import requests

from threading import Timer

from Active_Logger import Active_logger


# Create connection

def update_db(data_0, data_1, data_2, data_3, data_4, data_5, data_6, data_7, data_8, data_9):

    connection = lite_sql.connect('weather.db')

    print("Connection Done...")

    sql = "UPDATE Report SET City_ID = {}, Temperature = {}, Min_Temp = {}, Max_Temp = {}, Humidity = {}, Pressure = {}, Wind_Speed = {}, Feel_Like = {}, Weather = '{}', Weather_description = '{}' WHERE Record_ID = 413"

    statement = sql.format(data_0, data_1, data_2, data_3, data_4, data_5, data_6, data_7, data_8, data_9)

    print(statement)

    connection.execute(statement)

    connection.commit()

    print("DB Update Date Done")


# Function for read files

def info_reader(path: str):

    file = open(path, "r")

    return file.read()


# Function for data extract




def get_weather():
    # API base URL

    BASE_URL = "https://api.openweathermap.org/data/2.5/weather?"

    # City Name
    CITY = info_reader('City.dat')

    # Your API key
    API_KEY = info_reader('API.key')

    # Updating the URL
    URL = BASE_URL + "q=" + CITY + "&appid=" + API_KEY

    # Sending HTTP request
    response = requests.get(URL)

    if response.status_code == 200:  # checking the status code of the request

        data = response.json()  # retrieving data in the json format

        # take the main dict block
        main = data['main']

        city_id = data['id']

        temperature = main['temp']

        temperature_min = main['temp_min']

        temperature_max = main['temp_max']

        temp_feel_like = main['feels_like']

        humidity = main['humidity']

        pressure = main['pressure']

        weather_report = data['weather']

        wind_report = data['wind']

        wind_speed = wind_report['speed']

        main_weather = weather_report[0]['main']

        weather_description = weather_report[0]['description']

        update_db(city_id, temperature, temperature_min, temperature_max, humidity, pressure, wind_speed, temp_feel_like, main_weather, weather_description)

        date_record = Active_logger()

    else:

        print("Problem With HTTP Request")

    Timer(15, get_weather).start()


get_weather()
