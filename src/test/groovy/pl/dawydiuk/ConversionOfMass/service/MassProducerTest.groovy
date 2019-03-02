package pl.dawydiuk.ConversionOfMass.service

import models.Mass
import org.springframework.kafka.core.KafkaTemplate
import pl.dawydiuk.ConversionOfMass.builder.MassBuilder
import spock.lang.Specification

/**
 * Created by Judith on 16.02.2019.
 */
class MassProducerTest extends Specification {

    private final KafkaTemplate<String, Mass> kafkaTemplate = Mock();
    private final MassBuilder massBuilder = Mock();
    private final MassProducer massProducer = new MassProducer(kafkaTemplate, massBuilder);


    def "should send mass to correct topic"() {
        when:
        massProducer.sendMass();
        then:
        massProducer != null
    }

    def "should invoke send with two correct parameter"() {

    }

    def "should invoke send only once"() {

    }

    def "should .... if topic is incorrect"() {

    }

    def "should .... if kafka has problem ??"() {

    }
}
