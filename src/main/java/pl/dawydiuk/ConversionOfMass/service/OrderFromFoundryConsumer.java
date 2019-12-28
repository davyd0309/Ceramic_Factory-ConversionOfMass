package pl.dawydiuk.ConversionOfMass.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderFromFoundryConsumer {

    private final MassProducer massProducer;

    @Autowired
    public OrderFromFoundryConsumer(MassProducer massProducer) {
        this.massProducer = massProducer;
    }

    @KafkaListener(topics = "${app.topic.orders-from-foundry}", autoStartup = "${kafka.listen:true}")
    public void getInformationFromFoundry(@Payload String information) {
        log.info("Received information='{}' from foundry", information);
        if (information.equals("Not enough mass")) {
            massProducer.sendMass();
        }
        //powinno raz otrzymac wiadomosc
    }

}
