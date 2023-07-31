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

import websockets
import time
import asyncio

ENV = 'pp'

class args:
    if ENV == 'lemon':
        ws_url = 'wss://api-lemon.cfdev.pro/v2/websocket'
        rest_url = 'https://api-lemon.cfdev.pro'
        rest_short = 'api-lemon.cfdev.pro'
        # api_key = '4haJdXKNKJvLsLZWdrSyJLaOdLboTtDJZntSpWERqSI=' #main
        # api_secret = '66otrcp1Ps/mmFYPzEF21fAkjbRS81OpKoM0IDcukxc='
        api_key = 'WyWc2DMWBquGLIF0urUQvFHUIRXiH205fa9FXIadHMA=' #test2
        api_secret = 'u2j9D5Ruskc96ZNzcl3k7kYUaXjH69A3WADNL0n2ALo='
    elif ENV=='durian':
        ws_url = 'wss://api-durian.cfdev.pro/v2/websocket'
        api_key = 'bVpjBZcn0pZU4f50NN/Do4FdasN5JUSXfozEX63XtiM='  # 3045
        api_secret = 'NJDLYupbv5jHklt0fy1Zpg+5pLKBws/3CVxTe1p8KYE='
    elif ENV == 'pp':
        ws_url = 'wss://v2ppapi.coinflex.com/v2/websocket'
        # api_key = 'yveNzUAEb+hNG8/Ihd64WXXREdOHDa4LLUFjP8HzpYI='  # 530
        # api_secret = 'Kv78GCJ68DlZTE95+6RmakR9wQTzhjTk9KnsLIAobho='

        api_key = 'w+y/bjHA9SahkEg6Yb5RpLJgauVRcClYbdagVOpJfbw='
        api_secret = 'LbNNt8IojS5XdXuEZ+iSkbVOyGrxx3lf8iZ+k8L1R40='

    elif ENV == 'STAGE':
        ws_url = 'wss://v2stgapi.coinflex.com/v2/websocket'
        rest_url = 'https://v2stgapi.coinflex.com'
        rest_short = 'v2stgapi.coinflex.com'
        #
        # api_key = 'wSvXWGG2nfiwQJ/8iI3lE4GkAppuoGwilv3UiKcdpHg='  # 623TEST
        # api_secret = '7ABHi8fpIycZv2xrhC0uSRP7mVsmuCADinnwfkwz2G8='
        api_key = 'bckvGGnwqqGiTK33u7hPqkmnMeBMTM0GX5AH95SaEZI='  # stage01
        api_secret = 'MBzv9aJK8qYBrB3rMPwn6rGSK/IAvOe8bBS8z2xrcSI='
        api_key = 'DeifPxwGKQUcTUZdQMxtZsqz6FoIMAbn/4fAAWc00Hc='  # stage10 test2
        api_secret = 'QZdVHd+mt/EJKz/KvsIDastappE5ho62deuEKwAo3k8='
        api_key = '/N250Iu5IARvGMkkcj0YfxboywnKOPUSitQCl7e0HhA='  # stage15 test2
        api_secret = 'KKvtPOiH8xYp4tRtORQmR9cUzR8IYnuuVVrCJ/xxoN4='



    # elif ENV == 'LIVE':
    #     ws_url = 'wss://v2api.coinflex.com/v2/websocket'
    #     api_key = '46NsWlXF6mjvLPw9u1i3A7f1BNHX8HBsYREXcW8i8pU='
    #     api_secret = 'gK8eUnCkK1ZE7FhHGeckHFKKjXuAz4kf76qX+LrCs2k='



the_time=time.time()
timestamp=str(round(the_time*1000))
#print(timestamp)
the_data=timestamp+'GET/auth/self/verify'
data=the_data.encode('utf-8')
signature=(base64.b64encode(hmac.new(args.api_secret.encode('utf-8'), data, digestmod=hashlib.sha256).digest())).decode('utf-8')
#print(signature)
market='FLEX-USD'
#ETH-USD-220624-LIN  ETH-USD-SWAP-LIN
api_login=json.dumps({"op":"login","data":{"apiKey":args.api_key,"timestamp":timestamp,"signature":signature}})
api_order=json.dumps({"op": "subscribe", 'tag': 102, "args": ["order:" + market]})


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




            # print('执行成功')
        except AttributeError:
            print('属性错误')

        finally:
            print('结束')


async def hello():
    for i in range(1):
        async with websockets.connect(args.ws_url) as websocket:
            response = await websocket.recv()
            msg = json.loads(response)
            print('msg1', msg)
            await websocket.send(api_login)
            # time.sleep(1)
            response = await websocket.recv()
            msg = json.loads(response)
            print('msg2', msg)
            price = 4.3

            #  上 {"data":{"clientOrderId":1657789032515,"marketCode":"FLEX-USD","side":"SELL","orderType":"MARKET","price":"","quantity":"1","timeInForce":"IOC"},"op":"placeorder","tag":1657789032515}
            #  下 {"event":"placeorder","submitted":true,"tag":"1657789032515","timestamp":"1657789032718","data":{"clientOrderId":"1657789032515","marketCode":"FLEX-USD","side":"SELL","orderType":"MARKET","quantity":"1.0","limitPrice":"5.434","orderId":"1000104876378","source":0}}

            api_orders_create = '{"op": "placeorder", "data": {"clientOrderId": 1657789032515, "marketCode": "' + market + \
                                '", "side": "SELL", "orderType": "MARKET", "price":"", "quantity": 1,   "timeInForce": "IOC"}, "tag": 1657789032515}}'

            api_orders_create = '{"op": "placeorder", "data": {"clientOrderId": 1657789032515, "marketCode": "' + market + \
                                '", "side": "SELL", "orderType": "MARKET", "quantity": 0.001, "timeInForce": "MAKER_ONLY", "price":"", "tag": 102}}'

            await websocket.send(api_orders_create)
            # response = await websocket.recv()
            # msg = json.loads(response)
            # print(msg)


if __name__=='__main__':
    test=FlexAssets()
    test.main()
    asyncio.get_event_loop().run_until_complete(hello())

