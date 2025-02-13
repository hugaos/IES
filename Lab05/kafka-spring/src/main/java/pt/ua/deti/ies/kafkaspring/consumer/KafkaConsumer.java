package pt.ua.deti.ies.kafkaspring.consumer;

import pt.ua.deti.ies.kafkaspring.entities.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "lab05_112733", groupId = "lab5-group", containerFactory = "messageKafkaListenerContainerFactory")
    public void listen(Message message) {
        System.out.println("Received Message: " + message);
    }
}
