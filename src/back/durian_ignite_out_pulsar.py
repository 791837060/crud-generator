import json

import pulsar


# pp 172.42.13.79:6650
# kiwi 172.21.31.251:6651
# lemon 172.21.31.250:6651
# stage pulsar://172.43.13.159:6651

def me_pulsar(topic):
    client = pulsar.Client('pulsar://172.21.31.252:6651')
    consumer = client.subscribe(topic, 'test_ul')
    # while True:
    for i in range(1, 10):
        try:
            msg = consumer.receive()
            data = ("Received message '%s' id='%s'", msg.data().decode('utf-8'), msg.message_id())
            data = json.loads(data[1])
            print(data)
            # if data['marketCode']=='BTC-USD':
            #     print(data)
            consumer.acknowledge(msg)
        except:
            consumer.negative_acknowledge(msg)
    consumer.unsubscribe()
    # consumer.close()
    client.close()
    return data


# data=me_pulsar('persistent://OPNX-V1/RE-LE/ACCOUNT-VAR')  # re-le消息
# data=me_pulsar('persistent://OPNX-V1/FLINK-JOB/ORDERTICK-MARKPRICE-IN') #
# data=me_pulsar('non-persistent://OPNX-V1/ME-WS/MD-BEST-2001000000000')

# persistent://OPNX-V1/DATA-SYNC/NEW-LISTING-FORM
# data=me_pulsar('non-persistent://OPNX-V1/ME-WS/MD-SNAPSHOT-5148101011000000')
data = me_pulsar('persistent://OPNX-V1/PRETRADE-WS/ORDER-OUT-XIO-USD-SWAP-PER')

print(data)
