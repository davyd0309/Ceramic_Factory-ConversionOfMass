package pl.dawydiuk.ConversionOfMass.builder;

import models.Mass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dawydiuk.ConversionOfMass.rest.RawMeterialsConsumer;

/**
 * Created by Judith on 02.02.2019.
 */
@Component
public class MassBuilder {

    private final RawMeterialsConsumer rawMeterialsConsumer;

    @Autowired
    public MassBuilder(RawMeterialsConsumer rawMeterialsConsumer) {
        this.rawMeterialsConsumer = rawMeterialsConsumer;
    }

    public Mass createMass() {
        return Mass.builder()
                .id(1)
                .weight(100.5)
                .clay(rawMeterialsConsumer.getClay())//Celowo uderzam trzy razy żeby więcej się w apce działo :)
                .kaolinite(rawMeterialsConsumer.getKaolinite())
                .quartz(rawMeterialsConsumer.getQuartz())
                .build();
    }

}
