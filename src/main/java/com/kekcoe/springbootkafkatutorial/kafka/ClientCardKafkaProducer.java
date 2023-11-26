package com.kekcoe.springbootkafkatutorial.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
public class ClientCardKafkaProducer {

    private  static final Logger log = LoggerFactory.getLogger(ClientCardKafkaProducer.class);

    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public ClientCardKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        log.info(String.format("Message sent %s ", message));
        kafkaTemplate.send("clientCardTopic", message);
    }
}
