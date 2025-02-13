import json
from kafka import KafkaProducer

def fibonacci_sequence(n):
    sequence = []
    a, b = 0, 1
    while a <= n:
        sequence.append(a)
        a, b = b, a + b
    return sequence

def produce_message(producer,topic_name,sequence):
    nMec = 112733
    for i in sequence:
        message = {
            'nMec': nMec,
            'generatedNumber': i,
            'type': 'fibonacci'
        }
        message_json = json.dumps(message)
        future = producer.send(topic_name, value=message_json.encode('utf-8'))
        record_metadata = future.get(timeout=10)
        print(f"Message sent to partition {record_metadata.partition} with offset {record_metadata.offset}")


producer = KafkaProducer(
    bootstrap_servers=['localhost:29092'],
     api_version=(2, 0, 0)  
)
topic_name='lab05_112733'
sequence=fibonacci_sequence(112733)
produce_message(producer,topic_name,sequence)