package com.kekcoe.springbootkafkatutorial.kafka;

import com.kekcoe.springbootkafkatutorial.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
public class ClientCardKafkaProducer {

    private  static final Logger log = LoggerFactory.getLogger(ClientCardKafkaProducer.class);

    private final KafkaTemplate<String, User> kafkaTemplate;

    @Autowired
    public ClientCardKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User userData) {
        log.info(String.format("User data sent -> %s ", userData));
        Message<User> message = MessageBuilder.withPayload(userData)
                .setHeader(KafkaHeaders.TOPIC,"clientCardTopic")
                .build();

        kafkaTemplate.send(message);
    }
}
