package pl.edu.wszib.springtalkingwithworld.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.edu.wszib.springtalkingwithworld.Animals;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ShelterConfig {

    @Bean
    public List<Animals> listOfAnimals(){
      return new ArrayList();
    }


}

