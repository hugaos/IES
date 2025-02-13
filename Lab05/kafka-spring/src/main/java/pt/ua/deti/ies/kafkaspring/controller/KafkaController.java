package pt.ua.deti.ies.kafkaspring.controller;

import pt.ua.deti.ies.kafkaspring.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/kafka")
public class KafkaController {
    @Autowired
    private KafkaProducer producer;

    @PostMapping("/send")
    public String sendMessage(@RequestBody Object message) {
        producer.sendMessage(message);
        return "Message sent successfully!";
    }
}
