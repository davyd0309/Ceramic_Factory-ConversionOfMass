package pl.dawydiuk.ConversionOfMass.builder;

import models.Mass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dawydiuk.ConversionOfMass.rest.RestTryConsumer;

/**
 * Created by Judith on 02.02.2019.
 */
@Component
public class MassBuilder {

    private final RestTryConsumer restTryConsumer;

    @Autowired
    public MassBuilder(RestTryConsumer restTryConsumer) {
        this.restTryConsumer = restTryConsumer;
    }

    public Mass createMass() {
        Mass.MassBuilder mass = Mass.builder();
        mass.id(1).weight(100.5);
        restTryConsumer.getClay().onSuccess(mass::clay);//Celowo uderzam trzy razy żeby więcej się w apce działo :)
        restTryConsumer.getKaolinite().onSuccess(mass::kaolinite);
        restTryConsumer.getQuartz().onSuccess(mass::quartz);
        return mass.build();
    }

}
