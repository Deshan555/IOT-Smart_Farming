
from datetime import datetime


class Active_logger:

    def __init__(self):
        now = datetime.now()

        print("now =", now)

        dt_string = now.strftime("%d/%m/%Y %H:%M:%S")

        file = open("time.dat", "w")

        file.write(dt_string)

        file.close()
