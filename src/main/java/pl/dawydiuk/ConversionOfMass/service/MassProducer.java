package pl.dawydiuk.ConversionOfMass.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import pl.dawydiuk.ConversionOfMass.model.Clay;
import pl.dawydiuk.ConversionOfMass.model.Mass;
import pl.dawydiuk.ConversionOfMass.rest.RawMeterialsConsumer;

@Service
@Slf4j
public class MassProducer {

    private final KafkaTemplate<String, Mass> kafkaTemplate;
    private final RawMeterialsConsumer rawMeterialsConsumer;

    @Autowired
    public MassProducer(KafkaTemplate<String, Mass> kafkaTemplate, RawMeterialsConsumer rawMeterialsConsumer) {
        this.kafkaTemplate = kafkaTemplate;
        this.rawMeterialsConsumer = rawMeterialsConsumer;
    }


    @Value("${app.topic.mass-to-foundry}")
    private String topic;

    public void sendMass() {
        log.info("sending mass to topic='{}'", topic);
        Clay clay = rawMeterialsConsumer.getClay();
        Mass build = Mass.builder().id(1).weight(100.5).clay(clay).build();
        kafkaTemplate.send(topic, build);
    }

}
