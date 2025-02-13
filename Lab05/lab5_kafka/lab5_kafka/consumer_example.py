from kafka import KafkaConsumer
import json
# To consume latest messages and auto-commit offsets
consumer = KafkaConsumer('lab05_112733',
                         group_id='my-group',
                         bootstrap_servers=['localhost:29092'],
                        api_version=(2, 0, 0),
                        )
for message in consumer:
        print(f"Mensagem recebida: {message.value}")

# consume earliest available messages, don't commit offsets
KafkaConsumer(value_deserializer=lambda m: json.loads(m.decode('ascii')))