package pl.dawydiuk.ConversionOfMass.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import pl.dawydiuk.ConversionOfMass.rest.RawMeterialsRestConsumer;
import pl.dawydiuk.ConversionOfMass.rest.RawMeterialsRestConsumerImpl;
import pl.dawydiuk.ConversionOfMass.rest.RestTemplateResponseErrorHandler;
import pl.dawydiuk.ConversionOfMass.rest.RestTryConsumer;

/**
 * Created by Konrad on 16.02.2019.
 */
@Configuration
public class RestBeanConfig {

    @Bean
    public RestTemplateResponseErrorHandler restTemplateResponseErrorHandler() {
        return new RestTemplateResponseErrorHandler();
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateResponseErrorHandler restTemplateResponseErrorHandler) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(restTemplateResponseErrorHandler);
        return restTemplate;
    }

    @Bean
    public RestTryConsumer restTryConsumer(RawMeterialsRestConsumer rawMeterialsRestConsumer) {
        return new RestTryConsumer(rawMeterialsRestConsumer);
    }

    @Bean
    public RawMeterialsRestConsumer rawMeterialsRestConsumer(RestTemplate restTemplate){
        return new RawMeterialsRestConsumerImpl(restTemplate);
    }
}
