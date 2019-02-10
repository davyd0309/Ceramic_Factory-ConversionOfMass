package pl.dawydiuk.ConversionOfMass.service;

import lombok.extern.slf4j.Slf4j;
import models.Mass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import pl.dawydiuk.ConversionOfMass.builder.MassBuilder;
import pl.dawydiuk.ConversionOfMass.rest.RawMeterialsConsumer;

@Service
@Slf4j
public class MassProducer {

    @Value("${app.topic.mass-to-foundry}")
    private String topic;

    private final KafkaTemplate<String, Mass> kafkaTemplate;
    private final MassBuilder massBuilder;


    @Autowired
    public MassProducer(KafkaTemplate<String, Mass> kafkaTemplate, RawMeterialsConsumer rawMeterialsConsumer, MassBuilder massBuilder) {
        this.kafkaTemplate = kafkaTemplate;
        this.massBuilder = massBuilder;
    }


    void sendMass() {
        kafkaTemplate.send(topic, massBuilder.createMass());
        log.info("Sending mass to topic='{}'", topic);
    }


}
