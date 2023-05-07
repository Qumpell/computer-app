package pl.matkan.computerapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ComputerRepository repository){

        return args -> {
            log.info("Preloading " + repository.save(new Computer(4,1500,1024)));
            log.info("Preloading " + repository.save(new Computer(3,1200,2048)));
        };
    }
}
