package pl.dawydiuk.ConversionOfMass.rest;

import lombok.extern.slf4j.Slf4j;
import models.Clay;
import models.Kaolinite;
import models.Quartz;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



/**
 * Created by Judith on 29.12.2018.
 */

@Service
@Slf4j
public class RawMeterialsConsumer {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String CLAY_URL = "http://localhost:8082/rawmaterials/clay";
    private static final String QUARTZ_URL = "http://localhost:8082/rawmaterials/quartz";
    private static final String KAOLINITE_URL = "http://localhost:8082/rawmaterials/kaolinite";

    public Clay getClay() {
        return restTemplate.getForObject(CLAY_URL, Clay.class);
    }

    public Quartz getQuartz() {
        return restTemplate.getForObject(QUARTZ_URL, Quartz.class);
    }

    public Kaolinite getKaolinite() {
        return restTemplate.getForObject(KAOLINITE_URL, Kaolinite.class);
    }
}
