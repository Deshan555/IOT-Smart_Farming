
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

def sql_sync(data_1: str, data_2: str):

    connect = mysql.connector.connect(host=Config.HOST_NAME, user=Config.USER_NAME, passwd=Config.PASSWORD, database=Config.DATABASE_NAME)

    my_cursor = connect.cursor()

    sql = "UPDATE Real_Time_Box_2 SET Record_Date = %s, Record_Time = %s, Water_Level = %s, Soil_Moisture = %s WHERE Record_ID = 1689"

    print(sql)

    val = (dates(), now_time(), data_1, data_2)

    my_cursor.execute(sql, val)

    print("Waiting ......\n")

    connect.commit()

    print(my_cursor.rowcount, "record inserted.")


# make sure the 'COM#' is set according the Windows Device Manager

ser = serial.Serial(Config.SENSOR_BOX_2, 9600, timeout=1)

time.sleep(2)

number = 1

Water_Level: str

Soil_Moisture : str

while number <= 10:

    line = ser.readline()

    if line:
        string = line.decode()

        text = string.split("\t")

        text[1] = text[1].replace('\n', '')

        Water_Level = text[0]

        Soil_Moisture = text[1]

        sql_sync(Water_Level, Soil_Moisture)

        file = open("Sensor_BoxB.dat", "w")

        written_data: str = Water_Level+"\t"+Soil_Moisture

        file.write(written_data)

        file.close()

ser.close()
