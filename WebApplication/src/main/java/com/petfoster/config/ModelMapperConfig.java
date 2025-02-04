package com.petfoster.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.petfoster.model.Foster;
import com.petfoster.model.Pet;
import com.petfoster.model.PetApplication;
import com.petfoster.modelDTO.FosterDTO;
import com.petfoster.modelDTO.PetApplicationDTO;
import com.petfoster.modelDTO.PetDTO;

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

        modelMapper.addMappings(new PropertyMap<Foster, FosterDTO>(){
        	protected void configure() {
        		map(source.getName(), destination.getName());
        		map(source.getContactDetails(), destination.getContactDetails());
        	}
        });
        
        modelMapper.addMappings(new PropertyMap<PetApplication, PetApplicationDTO>(){
        	protected void configure() {
        		map(source.getPetId(), destination.getPetId());
        		map(source.getFosterId(), destination.getFosterId());
        		map(source.getStatus(), destination.getStatus());
        		map(source.getApplicantDetails(), destination.getApplicantDetails());
        	}
        });
        
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        
        return modelMapper;
    }
}
