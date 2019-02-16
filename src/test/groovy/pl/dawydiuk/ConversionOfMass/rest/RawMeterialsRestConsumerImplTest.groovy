package pl.dawydiuk.ConversionOfMass.rest

import models.Clay
import models.Kaolinite
import models.Quartz
import org.springframework.http.HttpStatus
import org.springframework.web.client.HttpServerErrorException
import org.springframework.web.client.RestClientResponseException
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

/**
 * Created by Judith on 10.02.2019.
 */
class RawMeterialsRestConsumerImplTest extends Specification {
    private RestTemplate restTemplate = Stub();
    private RawMeterialsRestConsumer rawMeterialsConsumer = new RawMeterialsRestConsumerImpl(restTemplate);


    def "getClay should throws exception"() {
        given:
        restTemplate.getForObject(_, Clay.class) >> {
            throw new HttpServerErrorException(HttpStatus.SERVICE_UNAVAILABLE)
        }
        when:
        rawMeterialsConsumer.getClay()
        then:
        thrown(RestClientResponseException)
    }

    def "getQuartz should throws exception"() {
        given:
        restTemplate.getForObject(_, Quartz.class) >> {
            throw new HttpServerErrorException(HttpStatus.SERVICE_UNAVAILABLE)
        }
        when:
        rawMeterialsConsumer.getQuartz()
        then:
        thrown(RestClientResponseException)
    }

    def "getKaolinite should throws exception"() {
        given:
        restTemplate.getForObject(_, Kaolinite.class) >> {
            throw new HttpServerErrorException(HttpStatus.SERVICE_UNAVAILABLE)
        }
        when:
        rawMeterialsConsumer.getKaolinite()
        then:
        thrown(RestClientResponseException)
    }

    def "getClay should return Clay"() {
        given:
        Clay expected = Clay.builder()
                .code("334222")
                .name("Clay")
                .build()
        restTemplate.getForObject(_, Clay.class) >> expected
        when:
        Clay actual = rawMeterialsConsumer.getClay()
        then:
        actual == expected
    }

    def "getQuartz should return Quartz"() {
        given:
        Quartz expected = Quartz.builder()
                .code("334222")
                .name("models.Quartz")
                .build()
        restTemplate.getForObject(_, Quartz.class) >> expected
        when:
        Quartz actual = rawMeterialsConsumer.getQuartz()
        then:
        actual == expected
    }

    def "getKaolinite should return Kaolinite"() {
        given:
        Kaolinite expected = Kaolinite.builder()
                .code("334222")
                .name("models.Kaolinite")
                .build()
        restTemplate.getForObject(_, Kaolinite.class) >> expected
        when:
        Kaolinite actual = rawMeterialsConsumer.getKaolinite()
        then:
        actual == expected
    }
}
