package pl.dawydiuk.ConversionOfMass.builder

import models.Clay
import models.Kaolinite
import models.Quartz
import pl.dawydiuk.ConversionOfMass.rest.RawMeterialsConsumer
import spock.lang.Specification

/**
 * Created by Judith on 02.02.2019.
 */
class MassBuilderTest extends Specification {

    private RawMeterialsConsumer rawMeterialsConsumer = Stub()
    private MassBuilder builder = new MassBuilder(rawMeterialsConsumer)

    def "should create mass with success"() {
        given:
        rawMeterialsConsumer.getClay() >> Clay.builder().build()
        rawMeterialsConsumer.getKaolinite() >> Kaolinite.builder().build()
        rawMeterialsConsumer.getQuartz() >> Quartz.builder().build()

        when:
        def mass = builder.createMass()

        then:
        mass != null
        mass.getId() == 1
        mass.getWeight() == 100.5d
    }

    def "should throw exception if raw materials is unavailable"() {
        given:

        when:
        def mass = builder.createMass()
        then:
        mass == null
    }
}
