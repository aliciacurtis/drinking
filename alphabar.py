#!/usr/bin/env python3

import csv
import json
from urllib import request

alpha_url = 'https://docs.google.com/spreadsheets/d/e/2PACX-1vTRD54FIR4GMQ7JH5cNwJrBZ3LA23Q1mqppti074hJOTCPTK89Xi8ZCAusB4dz5euM-QN_gI8Q61W5G/pub?gid=0&single=true&output=csv'
#https://docs.google.com/spreadsheets/d/e/2PACX-1vTRD54FIR4GMQ7JH5cNwJrBZ3LA23Q1mqppti074hJOTCPTK89Xi8ZCAusB4dz5euM-QN_gI8Q61W5G/pub?gid=0&single=true&output=csv
api_url = 'https://maps.googleapis.com/maps/api/directions/json?origin={origin}&destination={dest}'

def encode_param(s) :
  return s.replace(' ','+')

origin = encode_param('1298 Cambridge St, Cambridge MA, 02139')

def get_distance(dest) :
  url = api_url.format(origin=origin,dest=encode_param(dest))
  with request.urlopen(url) as r :
    dir_json = json.loads(r.read().decode())
    try :
      dist = dir_json.get('routes',[{}])[0].get('legs',[{}])[0].get('distance',{}).get('value',-1)
    except IndexError:
      dist = -2
    return dist

if __name__ == '__main__' :

  with request.urlopen(alpha_url) as r :
    for r in csv.reader(r.read().decode().split('\n')) :
      print('letter',r[0])
      for place in r[1:] :
        if place != '' :
          dist = get_distance(place)
          if dist < 0 :
            print(place,'could not be easily found by the googz from here')
          else :
            print(place,':','{:.2f}'.format(dist/1609),'mi')
