package pl.dawydiuk.ConversionOfMass.builder

import io.vavr.control.Try
import models.Clay
import models.Kaolinite
import models.Quartz
import org.springframework.web.client.RestClientResponseException
import pl.dawydiuk.ConversionOfMass.rest.RestTryConsumer
import spock.lang.Specification

/**
 * Created by Judith on 02.02.2019.
 */
class MassBuilderTest extends Specification {

    private RestTryConsumer restTryConsumer = Stub()
    private MassBuilder builder = new MassBuilder(restTryConsumer);

    def "should create mass with success"() {
        given:
        restTryConsumer.getClay() >> Try.success(Clay.builder().build())
        restTryConsumer.getKaolinite() >> Try.success(Kaolinite.builder().build())
        restTryConsumer.getQuartz() >> Try.success(Quartz.builder().build())

        when:
        def mass = builder.createMass()

        then:
        mass != null
        mass.getId() == 1
        mass.getWeight() == 100.5d
        mass.quartz != null
        mass.kaolinite != null
        mass.clay != null
    }

    def "should dont set clay"() {
        given:
        restTryConsumer.getClay() >> Try.failure(new RestClientResponseException("", 503, "", null, null, null))
        when:
        def mass = builder.createMass()
        then:
        mass.clay == null
    }

    def "should dont set kaolinite"() {
        given:
        restTryConsumer.getKaolinite() >> Try.failure(new RestClientResponseException("", 503, "", null, null, null))
        when:
        def mass = builder.createMass()
        then:
        mass.kaolinite == null
    }

    def "should dont set quartz"() {
        given:
        restTryConsumer.getQuartz() >> Try.failure(new RestClientResponseException("", 503, "", null, null, null))
        when:
        def mass = builder.createMass()
        then:
        mass.quartz == null
    }
}
