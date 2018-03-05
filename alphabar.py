#!/usr/bin/env python3
'''
This script access our alphabar google spreadsheet and reads it in as a csv
file.

It then queries each location found for each letter using the google web
services api to find a distance to the destination.

Prints out the distance from Inman Square to each destination in miles if one
is found.

Can simply modify the document in google sheets to change the destination
names.
'''

import csv
import json
from urllib import request

alpha_url = 'https://docs.google.com/spreadsheets/d/e/2PACX-1vTRD54FIR4GMQ7JH5cNwJrBZ3LA23Q1mqppti074hJOTCPTK89Xi8ZCAusB4dz5euM-QN_gI8Q61W5G/pub?gid=0&single=true&output=csv'
api_url = 'https://maps.googleapis.com/maps/api/directions/json?origin={origin}&destination={dest}'

def encode_param(s) :
  '''
  Lazy, insecure URL encoding for adding values to google web services api URL.
  '''
  return s.replace(' ','+')

# lazy origin
origin = encode_param('1298 Cambridge St, Cambridge MA, 02139')

def get_distance(dest) :
  '''
  Accesses the google maps web service api to find the distance between the
  origin defined on the script level and a destination string.

  Lazily bails when the json doesn't conform to a successful result:
    - -1 == could not find the value field on a leg with a distance
    - -2 == could not find a route or a leg
  '''
  url = api_url.format(origin=origin,dest=encode_param(dest))
  with request.urlopen(url) as r :
    dir_json = json.loads(r.read().decode())
    try :
      # dirty dirty dirty dirty don't do this this way dirty dirty
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
            # distance is reported in meters (FEH)
            # 1609 meters ~= 1 mile
            print(place,':','{:.2f}'.format(dist/1609),'mi')
