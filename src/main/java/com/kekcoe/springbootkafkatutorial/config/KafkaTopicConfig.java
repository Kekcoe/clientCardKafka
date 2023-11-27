package com.kekcoe.springbootkafkatutorial.config;

import com.kekcoe.springbootkafkatutorial.model.User;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic clietncardTopic(){
        return TopicBuilder.name("clientCardTopic")
                .build();
    }

}
