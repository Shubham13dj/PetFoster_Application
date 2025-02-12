package com.petfoster.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.petfoster.model.Pet;
import com.petfoster.modelDTO.PetDTO;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Custom mapping configuration
//        modelMapper.addMappings(new PropertyMap<Pet, PetDTO>() {
//            protected void configure() {
//                map(source.getDescription(), destination.getDescription());
//            }
//        });
        
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        
        return modelMapper;
    }
}
