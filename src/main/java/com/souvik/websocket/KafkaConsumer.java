package com.souvik.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @Autowired
    SimpMessagingTemplate template;

    @KafkaListener(topics="${kafka.topic}",groupId="${kafka.group.id}")
    public void consume(@Payload String message) {
        template.convertAndSend("/topic/sample", message);
    }
}