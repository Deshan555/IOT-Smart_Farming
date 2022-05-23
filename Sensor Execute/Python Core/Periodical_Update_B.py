import time

from datetime import datetime

from datetime import date

import mysql.connector

import random

from threading import Timer

import Config

def data_read():

    file = open("Sensor_BoxB.dat", "r")

    return file.read()

# function for get current date


def dates():

    return date.today()


# function for get current time

def now_time():

    now = datetime.now()

    return now.strftime("%H:%M:%S")


def data_sync():

    Primary_key = (random.randint(0, 100000000))

    data = data_read()

    text = data.split("\t")

    Water_Level = text[0]

    Soil_Moisture = text[1]

    print(text)

    connect = mysql.connector.connect(host=Config.HOST_NAME, user=Config.USER_NAME, passwd=Config.PASSWORD, database=Config.DATABASE_NAME)

    my_cursor = connect.cursor()

    sql = "INSERT INTO sensor_box_02 (Record_ID, Record_Date, Record_Time, Water_Level, Soil_Moisture) VALUES (%s, %s, %s, %s, %s)"

    val = (Primary_key, dates(), now_time(), Water_Level, Soil_Moisture)

    my_cursor.execute(sql, val)

    print("Waiting ......\n")

    connect.commit()

    print(my_cursor.rowcount, "record inserted.")

    Timer(900, data_sync).start()


data_sync()


