import requests
import json

url = "https://bsc.streamingfast.io/subgraphs/name/pancakeswap/exchange-v2"

payload="{\"query\":\"{\\n pairs(first: 1000, orderBy: reserveUSD, orderDirection: desc) {\\n   id,\\n  token0 {\\n    id,\\n    symbol\\n  },\\n  token1 {\\n    id,\\n    symbol\\n  }\\n }\\n}\",\"variables\":{}}"
headers = {
  'authority': 'api.thegraph.com',
  'accept': '*/*',
  'accept-language': 'zh-CN,zh;q=0.9',
  'cache-control': 'no-cache',
  'content-type': 'application/json',
  'origin': 'https://thegraph.com',
  'pragma': 'no-cache',
  'referer': 'https://thegraph.com/',
  'sec-ch-ua': '".Not/A)Brand";v="99", "Google Chrome";v="103", "Chromium";v="103"',
  'sec-ch-ua-mobile': '?0',
  'sec-ch-ua-platform': '"macOS"',
  'sec-fetch-dest': 'empty',
  'sec-fetch-mode': 'cors',
  'sec-fetch-site': 'same-site',
  'user-agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.0.0 Safari/537.36'
}

response = requests.request("POST", url, headers=headers, data=payload)

print(response.text)
