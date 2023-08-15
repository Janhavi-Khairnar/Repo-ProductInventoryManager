package com.igc.productinventorymanager;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductInventoryManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductInventoryManagerApplication.class, args);
    }

    @Bean
    public ModelMapper getModelMapper() {

        return  new ModelMapper();
    }


}
