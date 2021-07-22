import RPi.GPIO as GPIO
import time

GPIO.setmode(GPIO.BCM)

PIN = 2
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
    
while True :
    mode = input('Enter mode : ').lower()
    if 'off' in mode :
        GPIO.output(PIN,GPIO.HIGH)
        print('OFF')
    elif 'on' in mode :
        GPIO.output(PIN,GPIO.LOW)
        print('ON')
    else :
        exit()

