# -*- coding: utf-8 -*-
"""
v3/orders/working.api
auth: jack

curl 'https://api-kiwi.cfdev.pro/v2/account/admin/partnerSignKey/add' \
  -H 'authority: api-kiwi.cfdev.pro' \
  -H 'accept: application/json, text/plain, */*' \
  -H 'accept-language: zh-CN,zh;q=0.9' \
  -H 'authorization: bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJsb2dpbl9pZCI6IjM4MDIwNDIiLCJ0ZmFfdHlwZSI6bnVsbCwiYWNjb3VudF90eXBlIjpudWxsLCJhY2NvdW50X2lkIjpudWxsLCJ1c2VyX25hbWUiOnsiYXV0aG9yaXRpZXMiOlt7ImF1dGhvcml0eSI6IlJPTEVfRVZFUllPTkUifV0sImRldGFpbHMiOnsiZXh0X2F0dHIiOiIiLCJncmFudF90eXBlIjoicGFzc3dvcmQiLCJjbGllbnRfYXBwIjoiY2ZfYXBpIiwic2NvcGUiOiJjb2luZmxleGNsb3VkIiwiY2xpZW50X3NlY3JldCI6InNlY3JldCIsImNsaWVudF9pZCI6ImNvaW5mbGV4Y2xpZW50IiwidXNlcm5hbWUiOiJkZXZlbG9wIn0sImF1dGhlbnRpY2F0ZWQiOnRydWUsInByaW5jaXBhbCI6eyJpZCI6IjM4MDIwNDIiLCJwYXNzd29yZCI6IiQyYSQxMCRaaS85Y0JaQmo0eFhPRkpHZXZSYk11R1ZVdjlDS0NWZmdiT3Q2emFrYUcwN1lrTHJyWXdjLiIsImFjY291bnRUeXBlIjpudWxsLCJhY2NvdW50SWQiOm51bGwsInRmYVR5cGUiOm51bGwsInJvbGVJZHMiOltdLCJzdXBlckFkbWluIjp0cnVlLCJwZXJtaXNzaW9ucyI6bnVsbCwicm9sZXMiOm51bGwsImVuYWJsZWQiOnRydWUsInVzZXJuYW1lIjoiZGV2ZWxvcCIsImF1dGhvcml0aWVzIjpbeyJhdXRob3JpdHkiOiJST0xFX0VWRVJZT05FIn1dLCJhY2NvdW50Tm9uRXhwaXJlZCI6dHJ1ZSwiYWNjb3VudE5vbkxvY2tlZCI6dHJ1ZSwiY3JlZGVudGlhbHNOb25FeHBpcmVkIjp0cnVlfSwiY3JlZGVudGlhbHMiOm51bGwsIm5hbWUiOiJkZXZlbG9wIn0sInN1cGVyX2FkbWluIjp0cnVlLCJzY29wZSI6WyJjb2luZmxleGNsb3VkIl0sImV4cCI6MTY3NzY2NjU5MywiYXV0aG9yaXRpZXMiOlsiUk9MRV9FVkVSWU9ORSJdLCJqdGkiOiI0MjYxM2EzZS01NDI4LTQ2ZmItYTg1Zi0xOTMwNWRiYzg4YzQiLCJyb2xlX2lkcyI6W10sImNsaWVudF9pZCI6ImNvaW5mbGV4Y2xpZW50In0.fi9DqxpdTjPpc1K1Lvpk4abebLbm3PCsxmJ7ByWYXrepCV9aRssl6rynX05Zhp8Zv5q5hJTtQFBzfopdvmFsIZRFry-zhz9bqvpRFnbOM7vfLLiWBLHAnjSJImuHjEINd6di1OQqaP-YgnnP2rRjC3rhi4f0bwiqVWVgOCP_jWtJBb0agq-tqWtfNJiX7wVZdF7R6fpqZaq6fhdTn1xaIA2r9WL4RhMxMGEpQguANgxG_KfSJd6skEU8_mgaVtR6-hKxW-cFJTm51wy9-R1eTYnV0yMlJ-A9ZpcvIr2vCkedb4qhDh-9jAS8pcsJKuLrffDO90ZTRSbxEdVrmHUHYA' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json;charset=UTF-8' \
  -H 'origin: https://kiwicfa.cfdev.pro' \
  -H 'pragma: no-cache' \
  -H 'referer: https://kiwicfa.cfdev.pro/' \
  -H 'sec-ch-ua: "Not?A_Brand";v="8", "Chromium";v="108", "Google Chrome";v="108"' \
  -H 'sec-ch-ua-mobile: ?0' \
  -H 'sec-ch-ua-platform: "macOS"' \
  -H 'sec-fetch-dest: empty' \
  -H 'sec-fetch-mode: cors' \
  -H 'sec-fetch-site: same-site' \
  -H 'user-agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36' \
  --data-raw '{"partnerName":"p1"}' \
  --compressed

"""
from urllib.parse import urlencode
import requests
import hmac
import base64
import hashlib
import datetime
import json
class FlexAssets:

    rest_url = 'https://api-kiwi.cfdev.pro'
    rest_path = 'api-kiwi.cfdev.pro'

# API密钥: reg001@coinflex.com
   # api_key = 'kxfU51Xh6Cg1xm7Gx+7vO1pudhFWrsRN/NlYnEdj/hI='
   # api_secret = 'mzrOPJoRtzdNXvjz+uQjPTOJeSBnW1SbTFztPQBm0xw='




# p1 合作方 "apiSecret":"9lVepRxgPeJTDDP7coWLEgndarPLgNCZcxmaDVSaoPE=","apiKey":"u2UffUcHhOlKFGR1Sx3dX/UliP2URx94Sdsk2zv13SA="
    api_key = 'u2UffUcHhOlKFGR1Sx3dX/UliP2URx94Sdsk2zv13SA='
    api_secret = '9lVepRxgPeJTDDP7coWLEgndarPLgNCZcxmaDVSaoPE='

    #{"partnerName":"p12","accessibleUriPatterns":null,
    # "apiSecret":"fwmS0qNu1sx5Tl2EiaQt0ekkflHWh28m1Xrz8yQucS0=","apiKey":"U234YHYIFPgLPTMuAgvCQIDyRDQDMCNCE921wIgpSnc=","id":1664529642362527744}}
    api_key = 'U234YHYIFPgLPTMuAgvCQIDyRDQDMCNCE921wIgpSnc='
    api_secret = 'fwmS0qNu1sx5Tl2EiaQt0ekkflHWh28m1Xrz8yQucS0='

    path='/v2/integration/api/test'
    path='/v2/integration/api/claim/info/2000000105'
   # path='/v2/integration/public/allticker'
    body={}
    request_type = 'GET'


    nonce = 123  #自己定义的随机数，可以不改
    ts = str(datetime.datetime.utcnow().isoformat())[:19]  # 当前时间，不用管
    #print(ts)
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
            header = {'Content-Type': 'application/json', 'AccessKey': FlexAssets.api_key, 'Timestamp': FlexAssets.ts,'Signature': result,'Nonce': str(FlexAssets.nonce)}
        else:
            print('你的request_type好像有些不对')
        print(msg_string)
        print(result)
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