package pl.dawydiuk.ConversionOfMass.rest;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.dawydiuk.ConversionOfMass.model.Clay;

/**
 * Created by Judith on 29.12.2018.
 */

@Service
public class RawMeterialsConsumer {

    private final RestTemplate restTemplate = new RestTemplate();


    public Clay getClay() {
        final String url = "http://localhost:8082/rawmaterials/clay";
        return restTemplate.getForObject(url, Clay.class);
    }
}
