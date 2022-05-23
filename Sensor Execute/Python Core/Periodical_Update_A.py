import time

from datetime import datetime

from datetime import date

import mysql.connector

import random

import Config

from threading import Timer


def data_read():

    file = open("Sensor_BoxA.dat", "r")

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

    Humidity = text[0]

    Temperature = text[1]

    Windchill = text[2]

    Gas = text[3]

    print(text)

    connect = mysql.connector.connect(host=Config.HOST_NAME, user=Config.USER_NAME, passwd=Config.PASSWORD, database=Config.DATABASE_NAME)

    my_cursor = connect.cursor()

    sql = "INSERT INTO sensor_box_01 (Record_ID, Record_Date, Record_Time, Temperature, Humidity, Heat_Index, Gas_Value) VALUES (%s, %s, %s, %s, %s, %s, %s)"

    val = (Primary_key, dates(), now_time(), Humidity, Temperature, Windchill, Gas)

    my_cursor.execute(sql, val)

    print("Waiting ......\n")

    connect.commit()

    print(my_cursor.rowcount, "record inserted.")

    Timer(900, data_sync).start()


data_sync()


