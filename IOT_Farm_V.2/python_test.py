import requests

BASE_URL = "https://api.openweathermap.org/data/2.5/weather?"

CITY = "Rathnapura"

API_KEY = "ab46492c5e954d033a7e4a6afe58ccde"


def weather_function():

        URL = BASE_URL + "q=" + CITY + "&appid=" + API_KEY

        response = requests.get(URL)

        if response.status_code == 200:

            data = response.json()

            main = data['main']

            temperature = main['temp']

            temp_feel_like = main['feels_like']

            humidity = main['humidity']

            pressure = main['pressure']

            weather_report = data['weather']

            wind_report = data['wind']

            print('Here Today Weather Report In '+CITY)

            print(f" Today Weather Like {weather_report[0]['description']}")

            print(f"Temperature: {temperature} in Kelvin")

            print(f"Feel Like: {temp_feel_like} in Kelvin")

            print(f"Humidity: {humidity} Parentage")

            print(f"Pressure: {pressure} in pascal")

            print(f"Wind Speed: {wind_report['speed']} kilometre per hour")

        else:

           print("Error in the HTTP request")

weather_function()
        
