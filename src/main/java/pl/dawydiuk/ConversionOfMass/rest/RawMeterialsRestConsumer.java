package pl.dawydiuk.ConversionOfMass.rest;

import models.Clay;
import models.Kaolinite;
import models.Quartz;

/**
 * Created by Konrad on 16.02.2019.
 */
public interface RawMeterialsRestConsumer {
    Clay getClay();
    Quartz getQuartz();
    Kaolinite getKaolinite();
}
