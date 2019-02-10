package pl.edu.wszib.springtalkingwithworld.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class UserConfig {

    @Bean
    public ArrayList list(){
        return new ArrayList();
    }
}
