# -*- coding: utf-8 -*-
"""
v3/orders/working.api
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



    ws_url = 'wss://v2api.coinflex.com/v2/websocket'
    rest_url = 'https://v2api.coinflex.com'
    rest_path = 'v2api.coinflex.com'
    #

    api_key = 'gxxqKt3hEOdm2ZWcudH/Do4bMcR8RocASMY9O0IifsE='
    api_secret = 'MngQ1htgZLBrj15npyOTD1Ief+aZNzL89KT7Yq1+TZA='

    path='/v2.1/orders'
    body={}
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
            print(resp.request.headers)
            print(resp.request.body)
            print(json.dumps(resp.json(), sort_keys=True, indent=4, separators=(', ', ': ')))
            print(resp.json())
            print('执行成功')
        except AttributeError:
            print('属性错误')
        except:
            print('其他错误，请检查自己的改动内容；或者去掉这一个except，查看报错具体内容')
        finally:
            print('结束')
if __name__=='__main__':
    test=FlexAssets()
    test.main()