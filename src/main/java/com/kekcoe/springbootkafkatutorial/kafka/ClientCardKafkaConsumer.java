package com.kekcoe.springbootkafkatutorial.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ClientCardKafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(ClientCardKafkaConsumer.class);

    @KafkaListener(topics = "clientCardTopic", groupId = "myGroup")
    public void consume(String message){
        log.info(String.format("Message received -> %s", message));
    }
}
