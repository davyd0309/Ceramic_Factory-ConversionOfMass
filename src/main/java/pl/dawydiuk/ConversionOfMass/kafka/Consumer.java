package pl.dawydiuk.ConversionOfMass.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Consumer {

    @KafkaListener(topics = "${app.topic.foundry}")
    public void listen(@Payload String message) {
        log.info("received message='{}'", message);
    }

}