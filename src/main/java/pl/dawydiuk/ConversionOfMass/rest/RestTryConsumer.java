package pl.dawydiuk.ConversionOfMass.rest;

import io.vavr.control.Try;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import models.Clay;
import models.Kaolinite;
import models.Quartz;

/**
 * Created by Judith on 16.02.2019.
 */
@AllArgsConstructor
@Slf4j
public class RestTryConsumer {

    private RawMeterialsRestConsumer rawMeterialsRestConsumer;

    public Try<Clay> getClay() {
        return Try.of(rawMeterialsRestConsumer::getClay);
    }

    public Try<Kaolinite> getKaolinite() {
        return Try.of(rawMeterialsRestConsumer::getKaolinite);
    }

    public Try<Quartz> getQuartz() {
        return Try.of(rawMeterialsRestConsumer::getQuartz);
    }
}
