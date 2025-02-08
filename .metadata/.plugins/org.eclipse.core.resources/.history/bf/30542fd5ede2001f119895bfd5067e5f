package com.petfoster.universal_pet_foster.configs;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.petfoster.universal_pet_foster.PetDTO;
import com.petfoster.universal_pet_foster.model.Pet;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Custom mapping configuration
        modelMapper.addMappings(new PropertyMap<Pet, PetDTO>() {
            protected void configure() {
                map(source.getDescription(), destination.getDescription());
            }
        });

        return modelMapper;
    }
}
