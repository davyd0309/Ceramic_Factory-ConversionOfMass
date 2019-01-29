package pl.dawydiuk.ConversionOfMass.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderFromFoundryConsumer {

    private MassProducer massProducer;

    @Autowired
    public OrderFromFoundryConsumer(MassProducer massProducer) {
        this.massProducer = massProducer;
    }

    @KafkaListener(topics = "${app.topic.orders-from-foundry}")
    public void getMessageFromFoundry(@Payload String message) {

        log.info("received message='{}' from foundry", message);
        if (message.equals("Mass please")) {
            massProducer.sendMass();
        }
    }

}
