package pl.dawydiuk.ConversionOfMass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConversionOfMassApplication
//        implements CommandLineRunner
{

//    private final MassProducer massProducer;
//
//    @Autowired
//    public ConversionOfMassApplication(MassProducer massProducer) {
//        this.massProducer = massProducer;
//    }

    public static void main(String[] args) {
        SpringApplication.run(ConversionOfMassApplication.class, args);
    }

//    @Override
//    public void run(String... strings) throws Exception {
//        Scanner reader = new Scanner(System.in);
//        if(reader.next().equals("send")){
//            massProducer.sendMass();
//        }
//    }
}
