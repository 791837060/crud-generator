import websockets
import asyncio
import json
import requests
import hmac
import time
import base64
import hashlib
import datetime
from urllib.parse import urlencode
import zlib

'''websocket的请求'''

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
market='BTC-USD-SWAP-LIN'
#ETH-USD-220624-LIN  ETH-USD-SWAP-LIN
api_login=json.dumps({"op":"login","data":{"apiKey":args.api_key,"timestamp":timestamp,"signature":signature}})
api_order=json.dumps({"op": "subscribe", 'tag': 102, "args": ["order:" + market]})

async def hello():
    for i in range(1):
        async with websockets.connect(args.ws_url) as websocket:
                response = await websocket.recv()
                msg = json.loads(response)
                print('msg1',msg)
                await websocket.send(api_login)
                #time.sleep(1)
                response = await websocket.recv()
                msg = json.loads(response)
                print('msg2', msg)
                for i in range(100):
                    time.sleep(0.5)
                    for i in range(30):
                        price = 19985.6 + i/10
                        price = str(price)
                        #BTC-USD-SPR-220624P-LIN   BTC-USD-SPR-220930P-LIN    BTC-USD-220624-LIN  BTC-USD-220930-LIN   BTC-USD-SPR-201225P-LIN  BTC-USD-201225-LIN
                        api_orders_create = '{"op": "placeorder", "data": {"clientOrderId": 1, "marketCode": "' + market + '", "side": "BUY", "orderType": "LIMIT", "quantity": 0.001, "timeInForce": "MAKER_ONLY", "price":"' + price + '", "tag": 102}}'
                        await websocket.send(api_orders_create)
                        # response = await websocket.recv()
                        # msg = json.loads(response)
                        # print(msg)


asyncio.get_event_loop().run_until_complete(hello())