import RPi.GPIO as GPIO
import time
from firebase import firebase as fb

GPIO.setmode(GPIO.BOARD)

PIN = 5
GPIO.setup(PIN,GPIO.OUT)

LINK = 'https://iot-home-cdf8e-default-rtdb.firebaseio.com/' 
        
class Room_4 :
    def __init__ (self) :
        self.mLightPath = 'Room_4/Light'
        self.mFanPath = 'Room_4/Fan'
    
room = Room_4()

print('Server Started...')

while True :
    mFB = fb.FirebaseApplication(LINK,None)
    if mFB.get(room.mLightPath,None) == "ON" :
        print(f'\r Status : ON ',end="")
        GPIO.output(PIN,GPIO.LOW)
    else :
        print(f'\r Status : OFF',end="")
        GPIO.output(PIN,GPIO.HIGH)