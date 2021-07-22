import RPi.GPIO as GPIO
import time
from firebase import firebase as fb

GPIO.setmode(GPIO.BOARD)

PIN = 5
GPIO.setup(PIN,GPIO.OUT)

"""
TIME_IN = 3
TIME_OUT = 1


try:
    while True:
        GPIO.output(PIN,GPIO.LOW)
        print(f'\r[*]Light ON  ',end="")
        time.sleep(TIME_IN)
        GPIO.output(PIN,GPIO.HIGH)
        print(f'\r[*]Light OFF ',end="")
        time.sleep(TIME_OUT)

finally:
    GPIO.cleanup()"""        
        
class Room_4 :
    def __init__ (self) :
        self.LINK = 'https://iot-home-cdf8e-default-rtdb.firebaseio.com/'
        self.mLightPath = 'Room_4/Light'
        self.mFanPath = 'Room_4/Fan'
        self.mFB = fb.FirebaseApplication(self.LINK,None)
        #self.PIN_Light = 2
        #self.PIN_Fan = 3
        #GPIO.setup(self.PIN_Light , GPIO.OUT)
        
    def getStatus(self) :
        self.LightStatus = self.mFB.get(self.mLightPath,None)
        self.FanStatus = self.mFB.get(self.mFanPath,None)
        return
    
    def setStatus(self,val) :
        pass
    
room = Room_4()

while True :
    room.getStatus()
    if room.LightStatus == 'ON' :
        GPIO.output(PIN,GPIO.LOW)
    else :
        GPIO.output(PIN,GPIO.HIGH)
        
GPIO.cleanup()