package com.petfoster.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.petfoster.model.Pet;
import com.petfoster.modelDTO.PetDTO;
/**
 * Configuration class for ModelMapper. This class provides a bean for ModelMapper
 * with custom configuration.
 */
@Configuration
public class ModelMapperConfig {

    /**
     * Creates a bean of ModelMapper with custom configuration.
     * The matching strategy is set to STRICT.
     * 
     * @return a configured ModelMapper instance
     */
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
