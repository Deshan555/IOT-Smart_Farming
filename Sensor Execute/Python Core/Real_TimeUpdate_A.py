# SQL Syncing Script By Jayashanka Deshan

import serial

import time

from datetime import datetime

from datetime import date

import mysql.connector

import Config


# function for get current date

def dates():

    return date.today()


# function for get current time

def now_time():

    now = datetime.now()

    return now.strftime("%H:%M:%S")


# function for sync data to database

def sql_sync(data_1: str, data_2: str, data_3: str, date_4: str):

    connect = mysql.connector.connect(host=Config.HOST_NAME, user=Config.USER_NAME, passwd=Config.PASSWORD, database=Config.DATABASE_NAME)

    my_cursor = connect.cursor()

    sql = "UPDATE Real_Time_Box_1 SET Record_Date = %s, Record_Time = %s, Temperature = %s, Humidity = %s, Heat_Index = %s, Gas_Value = %s WHERE Record_ID = 409"

    val = (dates(), now_time(), data_1, data_2, data_3, date_4)

    my_cursor.execute(sql, val)

    print("Waiting ......\n")

    connect.commit()

    print(my_cursor.rowcount, "record inserted.")


# make sure the 'COM#' is set according the Windows Device Manager

ser = serial.Serial(Config.SENSOR_BOX_1, 9600, timeout=1)

time.sleep(2)

number = 1

Humidity: str

Temperature: str

Windchill: str

Gas: str

while number <= 10:

    line = ser.readline()

    if line:
        string = line.decode()

        text = string.split("\t")

        text = string.split("\t")

        text[3] = text[3].replace('\n', '')

        text[3] = text[3].replace('\r', '')

        text[0] = text[0].replace('.00', '')

        Humidity = text[0]

        Temperature = text[1]

        Windchill = text[2]

        Gas = text[3]

        sql_sync(Temperature, Humidity, Windchill, Gas)

        data = Temperature + "\t" + Humidity + "\t" + Windchill + "\t" + Gas

        file = open("Sensor_BoxA.dat", "w")

        file.write(data)

        file.close()

        print(data)

        print(text)

ser.close()
