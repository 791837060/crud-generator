# -*- coding: utf-8 -*-
"""
funding.api
auth: Jim zhou
"""
from urllib.parse import urlencode
import requests
import hmac
import base64
import hashlib
import datetime
import json
class FlexAssets:
    #kiwi
    # rest_url = 'https://api-kiwi.cfdev.pro'
    # rest_path = 'api-kiwi.cfdev.pro'
    #
    # #304570249
    rest_url = 'https://v2ppapi.coinflex.com'
    rest_path = 'v2ppapi.coinflex.com'
    #api_key = 'QWZ9d5WcXNi4ZM9g/y0K8ai/nF/V/xI08Xs23AKiBak='  # 3045
    #api_secret = 'mr8C6SrfxndQ6vYNmYICG9+8CafXJrzPZp6rf6828js='
    # api_key = 'prsYJR2I7YSkh2QpDDsSWjFFfD6/SZBEzuZ2EB91jSw='  # 20
    # api_secret = 'BSw5glYr3nPS1E11Jn4DSDCG6N5JOeLHjPGqGP3yIjI='


    # pp

    api_key = 'w+y/bjHA9SahkEg6Yb5RpLJgauVRcClYbdagVOpJfbw='
    api_secret = 'LbNNt8IojS5XdXuEZ+iSkbVOyGrxx3lf8iZ+k8L1R40='


    path='/v3/orders/status'
    #body={}
   # body = urlencode({"orderId":"1000071530601"})#1000071561763
  #  body = urlencode({"orderId":"1000071580002"})
  #  body = urlencode({"orderId":"1000071585001"})
   # body = urlencode({"orderId":"1000071580002"})
   # body = urlencode({"orderId":"1000071585011"})
 #   body = urlencode({"orderId":"1000071575008"})
   # body = urlencode({"orderId":"1000071585012"})
   # body = urlencode({"orderId":"1000071580033"})
 #   body = urlencode({"orderId":"1000071585618"})
  #  body = urlencode({"orderId":"1000071575857"})
    body = urlencode({"orderId":"1000085890225"})

    #1000071585729
    #1000071585729
   # body = urlencode({"orderId":"1000071632458","clientOrderId":"1655349904174"})
    #body = urlencode({"limit": "1000000"})
    #body = urlencode({"limit": "qwe"})
  #  body = urlencode({"startTime": "1640170643000","limit":"1"})
    #body = urlencode({"startTime": "1633851091000","endTime":"1633851090000"})
    #body = urlencode({"startTime": "qwe", "endTime": "1633851091000"})
    #body = urlencode({"startTime": "1633851091000", "endTime": "qwe"})
    #body = urlencode({"startTime":"12q3","endTime":"1633851090000"})
    #BTC-USD-SWAP-LIN

    request_type = 'GET'

    nonce = 123  #自己定义的随机数，可以不改
    ts = str(datetime.datetime.utcnow().isoformat())[:19]  # 当前时间，不用管
    @staticmethod
    def header():
        if FlexAssets.request_type == 'POST':
            msg_string = '{}\n{}\n{}\n{}\n{}\n{}'.format(FlexAssets.ts, FlexAssets.nonce, 'POST', FlexAssets.rest_path, FlexAssets.path, FlexAssets.body)
            result = base64.b64encode(hmac.new(FlexAssets.api_secret.encode('utf-8'), msg_string.encode('utf-8'), hashlib.sha256).digest()).decode('utf-8')
            header = {'Content-Type': 'application/json', 'AccessKey': FlexAssets.api_key, 'Timestamp': FlexAssets.ts,'Signature': result,'Nonce': str(FlexAssets.nonce)}
        elif FlexAssets.request_type == 'GET':
            if FlexAssets.body:
                msg_string = '{}\n{}\n{}\n{}\n{}\n{}'.format(FlexAssets.ts, FlexAssets.nonce, 'GET',FlexAssets.rest_path, FlexAssets.path,FlexAssets.body)

            else:
                msg_string = '{}\n{}\n{}\n{}\n{}\n'.format(FlexAssets.ts, FlexAssets.nonce, 'GET', FlexAssets.rest_path, FlexAssets.path)
            result = base64.b64encode(hmac.new(FlexAssets.api_secret.encode('utf-8'), msg_string.encode('utf-8'), hashlib.sha256).digest()).decode('utf-8')
            header = {'Content-Type': 'application/json', 'AccessKey': FlexAssets.api_key, 'Timestamp': FlexAssets.ts,'Signature': result,'Nonce': str(FlexAssets.nonce)}
        else:
            print('你的request_type好像有些不对')
        return header
    def main(self):
        try:
            if FlexAssets.request_type == 'POST':
                resp = requests.post(FlexAssets.rest_url + FlexAssets.path, headers=FlexAssets.header(),data=FlexAssets.body)
            elif FlexAssets.request_type == 'GET':
                if FlexAssets.body:
                    resp = requests.get(FlexAssets.rest_url + FlexAssets.path+'?'+FlexAssets.body, headers=FlexAssets.header())
                else:
                    resp = requests.get(FlexAssets.rest_url + FlexAssets.path, headers=FlexAssets.header())
            print(resp.url)
            print(json.dumps(resp.json(),indent=4, separators=(', ', ': ')))
        except AttributeError:
            print('属性错误')
        except:
            print('其他错误，请检查自己的改动内容；或者去掉这一个except，查看报错具体内容')
        finally:
            print('结束')
if __name__=='__main__':
    test=FlexAssets()
    test.main()