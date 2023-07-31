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

    #rest_url = 'https://v2api.coinflex.com'
    #rest_path = 'v2api.coinflex.com'
    #api_key = 'gxxqKt3hEOdm2ZWcudH/Do4bMcR8RocASMY9O0IifsE='
    #api_secret = 'MngQ1htgZLBrj15npyOTD1Ief+aZNzL89KT7Yq1+TZA='

    rest_url = 'https://v2ppapi.coinflex.com'
    rest_path = 'v2ppapi.coinflex.com'
    api_key = 'w+y/bjHA9SahkEg6Yb5RpLJgauVRcClYbdagVOpJfbw='
    api_secret = 'LbNNt8IojS5XdXuEZ+iSkbVOyGrxx3lf8iZ+k8L1R40='

    path='/v2/balances/FLEX'
    body={}
    request_type = 'GET'

    path2 = '/v2/orders/place'
    request_type2 = 'POST'


    nonce = 123  #自己定义的随机数，可以不改
    
    @staticmethod
    def header():
        ts = str(datetime.datetime.utcnow().isoformat())[:19]  # 当前时间，不用管
        if FlexAssets.request_type == 'POST':
            msg_string = '{}\n{}\n{}\n{}\n{}\n{}'.format(ts, FlexAssets.nonce, 'POST', FlexAssets.rest_path, FlexAssets.path, FlexAssets.body)
            result = base64.b64encode(hmac.new(FlexAssets.api_secret.encode('utf-8'), msg_string.encode('utf-8'), hashlib.sha256).digest()).decode('utf-8')
            header = {'Content-Type': 'application/json', 'AccessKey': FlexAssets.api_key, 'Timestamp': ts,'Signature': result,'Nonce': str(FlexAssets.nonce)}
        elif FlexAssets.request_type == 'GET':
            if FlexAssets.body:
                msg_string = '{}\n{}\n{}\n{}\n{}\n{}'.format(ts, FlexAssets.nonce, 'GET',FlexAssets.rest_path, FlexAssets.path,FlexAssets.body)

            else:
                msg_string = '{}\n{}\n{}\n{}\n{}\n'.format(ts, FlexAssets.nonce, 'GET', FlexAssets.rest_path, FlexAssets.path)
            result = base64.b64encode(hmac.new(FlexAssets.api_secret.encode('utf-8'), msg_string.encode('utf-8'), hashlib.sha256).digest()).decode('utf-8')
            header = {'Content-Type': 'application/json', 'AccessKey': FlexAssets.api_key, 'Timestamp': ts,'Signature': result,'Nonce': str(FlexAssets.nonce)}
        else:
            print('你的request_type好像有些不对')
        return header

    @staticmethod
    def header2(body2):
        ts = str(datetime.datetime.utcnow().isoformat())[:19]  # 当前时间，不用管
        if FlexAssets.request_type2 == 'POST':
            msg_string = '{}\n{}\n{}\n{}\n{}\n{}'.format(ts, FlexAssets.nonce, 'POST', FlexAssets.rest_path,
                                                         FlexAssets.path2, body2)
            result = base64.b64encode(hmac.new(FlexAssets.api_secret.encode('utf-8'), msg_string.encode('utf-8'),
                                               hashlib.sha256).digest()).decode('utf-8')
            header = {'Content-Type': 'application/json', 'AccessKey': FlexAssets.api_key, 'Timestamp': ts,
                      'Signature': result, 'Nonce': str(FlexAssets.nonce)}
        elif FlexAssets.request_type2 == 'GET':
            if body2:
                msg_string = '{}\n{}\n{}\n{}\n{}\n{}'.format(ts, FlexAssets.nonce, 'GET', FlexAssets.rest_path,
                                                             FlexAssets.path2, body2)

            else:
                msg_string = '{}\n{}\n{}\n{}\n{}\n'.format(ts, FlexAssets.nonce, 'GET', FlexAssets.rest_path,
                                                           FlexAssets.path2)
            result = base64.b64encode(hmac.new(FlexAssets.api_secret.encode('utf-8'), msg_string.encode('utf-8'),
                                               hashlib.sha256).digest()).decode('utf-8')
            header = {'Content-Type': 'application/json', 'AccessKey': FlexAssets.api_key, 'Timestamp': ts,
                      'Signature': result, 'Nonce': str(FlexAssets.nonce)}
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

            # print(resp.url)
            # print(resp.request.headers)
            # print(resp.request.body)
            print(json.dumps(resp.json(), sort_keys=True, indent=4, separators=(', ', ': ')))
            print(resp.json())

            result = json.loads(json.dumps(resp.json(), sort_keys=True, indent=4, separators=(', ', ': ')))
            print(result.get("data"))
            data = json.loads(json.dumps(result.get("data"), sort_keys=True, indent=4, separators=(', ', ': ')))
            print(data.get("available"))
            available = data.get("available")
# --------------------------------------------------------------------------------------------------------------------------------
            ts = datetime.datetime.utcnow().time()
            body2 = {"recvWindow": 3000, "timestamp": 1737100050453, "responseType": "FULL", "orders": [
                {"clientOrderId": 1612249737434, "marketCode": "FLEX-USD", "side": "SELL", "quantity": "1",
                 "timeInForce": "GTC", "orderType": "MARKET", "price": "4.3"}]}

            if FlexAssets.request_type2 == 'POST':
                resp = requests.post(FlexAssets.rest_url + FlexAssets.path2, headers=FlexAssets.header2(body2),data=body2)
            elif FlexAssets.request_type2 == 'GET':
                if body2:
                    resp = requests.get(FlexAssets.rest_url + FlexAssets.path2+'?'+body2, headers=FlexAssets.header2(body2))
                else:
                    resp = requests.get(FlexAssets.rest_url + FlexAssets.path2, headers=FlexAssets.header2(body2))

            print("=======================")
            print(body2)
            print(resp)
            print(json.dumps(resp.json(), sort_keys=True, indent=4, separators=(', ', ': ')))
            print(resp.json())

            result = json.loads(json.dumps(resp.json(), sort_keys=True, indent=4, separators=(', ', ': ')))
            print(result.get("data"))
            data = json.loads(json.dumps(result.get("data"), sort_keys=True, indent=4, separators=(', ', ': ')))
            print(data.get("available"))


            # print('执行成功')
        except AttributeError:
            print('属性错误')

        finally:
            print('结束')





if __name__=='__main__':
    test=FlexAssets()
    test.main()

