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

  Return value is a tuple with (STATUS, DIST, VALUE). STATUS is as follows:
    - 0 == found a destination, value is distance in meters
    - -1 == could not find the value field on a leg with a distance
    - -2 == could not find a route or a leg
    - -3 == legs found but no distance, dunno why this would happen

  DIST is 0 if STATUS != 0. VALUE is the end address if status == 0.
  '''
  url = api_url.format(origin=origin,dest=encode_param(dest))
  with request.urlopen(url) as r :
    dir_json = json.loads(r.read().decode())
    status, dist = 0, 0

    routes = dir_json.get('routes')
    if not routes :
      return -1,dist,'no routes found, not sure how to help you here'
    legs = routes[0].get('legs')
    if not legs :
      return -2,dist,'no legs for route, not sure how to help you here'
    distance = legs[0].get('distance')
    if not distance :
      return -3,dist,'legs found, but no distance, wtflolzers?'

    dist = distance.get('value')
    end_address = legs[0].get('end_address')

    return status,dist,end_address

if __name__ == '__main__' :

  print(__doc__)

  with request.urlopen(alpha_url) as r :
    for r in csv.reader(r.read().decode().split('\n')) :
      print('letter',r[0])
      for place in r[1:] :
        if place != '' :
          status, dist, msg = get_distance(place)

          # distance is reported in meters (FEH)
          # 1609 meters ~= 1 mile
          miles = dist/1609

          if status < 0 :
            print(place,'could not be easily found by the googz from here:',msg)
          elif miles > 20 :
            print(place,'is {:.2f} miles away,'.format(miles),'prolly not where we meant:',msg)
          else :
            print(place,':','{:.2f}'.format(miles),'mi')
