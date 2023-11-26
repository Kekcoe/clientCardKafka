package com.kekcoe.springbootkafkatutorial.controller;

import com.kekcoe.springbootkafkatutorial.kafka.ClientCardKafkaProducer;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class ClientCardMessageController {

    private ClientCardKafkaProducer clientCardKafkaProducer;

    @Autowired
    public ClientCardMessageController(ClientCardKafkaProducer clientCardKafkaProducer) {
        this.clientCardKafkaProducer = clientCardKafkaProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> publish (@RequestParam("message") String message){
        clientCardKafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the topic");
    }

}
