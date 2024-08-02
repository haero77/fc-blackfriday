package org.example.blackfriday.kafka.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaExampleService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaExampleService(final KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish() {
        kafkaTemplate.send("topic1", "message sent (topic1)");
    }

    @KafkaListener(topics = "topic1", groupId = "testgroup")
    public void consume(String message) {
        log.info("consumed {}", message);
    }
}
