package pl.dawydiuk.ConversionOfMass.rest;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import models.Clay;
import models.Kaolinite;
import models.Quartz;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;


/**
 * Created by Judith on 29.12.2018.
 */

@Service
@AllArgsConstructor
@Slf4j
public class RawMeterialsRestConsumerImpl implements RawMeterialsRestConsumer {

    private final RestTemplate restTemplate;
    private static final String CLAY_URL = "http://localhost:8082/rawmaterials/clay";
    private static final String QUARTZ_URL = "http://localhost:8082/rawmaterials/quartz";
    private static final String KAOLINITE_URL = "http://localhost:8082/rawmaterials/kaolinite";

    @Override
    public Clay getClay() throws RestClientResponseException {
        return restTemplate.getForObject(CLAY_URL, Clay.class);
    }

    @Override
    public Quartz getQuartz() throws RestClientResponseException {
        return restTemplate.getForObject(QUARTZ_URL, Quartz.class);
    }

    @Override
    public Kaolinite getKaolinite() throws RestClientResponseException {
        return restTemplate.getForObject(KAOLINITE_URL, Kaolinite.class);
    }
}
