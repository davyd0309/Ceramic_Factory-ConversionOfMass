package pl.dawydiuk.ConversionOfMass;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pl.dawydiuk.ConversionOfMass.kafka.Producer;

@SpringBootApplication
public class ConversionOfMassApplication implements CommandLineRunner {

    private final Producer producer;

    @Autowired
    public ConversionOfMassApplication(Producer producer) {
        this.producer = producer;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConversionOfMassApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
            producer.send("Message from ConversionOfMassApplication");
    }
}
