package com.imedia;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiDigitalCmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiDigitalCmsApplication.class, args);
    }
    @Bean
    public MapperFacade mapperFacade() {
        DefaultMapperFactory defaultFactory = new DefaultMapperFactory.Builder().build();
        return defaultFactory.getMapperFacade();
    }

}

