package org.example.meberservice.kafka.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaExampleController {

    private final KafkaExampleService kafkaExampleService;

    public KafkaExampleController(KafkaExampleService kafkaExampleService) {
        this.kafkaExampleService = kafkaExampleService;
    }

    @GetMapping("/kakfa-test")
    public void kafkaTest() {
        kafkaExampleService.publish();
    }
}
