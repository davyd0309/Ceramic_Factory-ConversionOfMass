package pl.dawydiuk.ConversionOfMass.rest

import models.Clay
import spock.lang.Specification

/**
 * Created by Judith on 10.02.2019.
 */
class RawMeterialsConsumerTest extends Specification {

    private RawMeterialsConsumer rawMeterialsConsumer = new RawMeterialsConsumer()

    def "should throw exception if service Warehouse is unavailable"() {
        given:

        when:
        Clay clay = rawMeterialsConsumer.getClay()

        then:
        clay != null
    }
}
