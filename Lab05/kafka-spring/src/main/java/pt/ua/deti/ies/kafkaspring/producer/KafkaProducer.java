package pt.ua.deti.ies.kafkaspring.producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    private static final String TOPIC = "lab05_112733";

    public void sendMessage(Object message) {
        kafkaTemplate.send(TOPIC, message);
    }
}
