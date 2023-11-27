package com.kekcoe.springbootkafkatutorial.controller;

import com.kekcoe.springbootkafkatutorial.kafka.ClientCardKafkaProducer;
import com.kekcoe.springbootkafkatutorial.model.User;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class ClientCardMessageController {

    private final ClientCardKafkaProducer clientCardKafkaProducer;

    @Autowired
    public ClientCardMessageController(ClientCardKafkaProducer clientCardKafkaProducer) {
        this.clientCardKafkaProducer = clientCardKafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish (@RequestBody User user){
        clientCardKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Message sent to the topic");
    }

}
