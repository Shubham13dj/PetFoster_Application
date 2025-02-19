ccpackage com.petfoster.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petfoster.model.Shelter;
import com.petfoster.modelDTO.ShelterDTO;
import com.petfoster.repository.ShelterRepository;

import jakarta.transaction.Transactional;

@Service
public class ShelterServices {

	@Autowired
	private ShelterRepository shelterRepo;
	
	@Autowired 
	private ModelMapper modelMapper;
	
	@Transactional
	public ShelterDTO addShelter(ShelterDTO shelterDTO)
	{
		return modelMapper.map(shelterRepo.save(modelMapper.map(shelterDTO, Shelter.class)), ShelterDTO.class);
	}
	
	@Transactional
	public ShelterDTO updateShelter(Long id, ShelterDTO shelterDTO)
	{
		Shelter shelter = shelterRepo.findById(id).orElseThrow(()-> new RuntimeException("No shelter found"));
		shelter.setName(shelterDTO.getName());
		shelter.setLocation(shelterDTO.getLocation());
		shelter.setCapacity(shelterDTO.getCapacity());
		shelter.setAvailablePetsCount(shelterDTO.getAvailablePetsCount());
		shelter.setContactInfo(shelterDTO.getContactInfo());
		
		shelterRepo.save(shelter);
		
		return modelMapper.map(shelter, ShelterDTO.class);
	}
	
	public List<ShelterDTO> getAllShelters()
	{
		return shelterRepo.findAll().stream().map(shelter -> modelMapper.map(shelter, ShelterDTO.class))
				.collect(Collectors.toList());
	}
	
	public ShelterDTO getShelterById(Long id)
	{
		return modelMapper.map(shelterRepo.findById(id), ShelterDTO.class);
	}
	
	@Transactional
	public void deleteShelterById(Long id)
	{
		shelterRepo.deleteById(id);
	}
	
	public List<ShelterDTO> getShelterByLocation(String location)
	{
		return shelterRepo.findByLocation(location).stream().map(shelter-> modelMapper.map(shelter, ShelterDTO.class))
				.collect(Collectors.toList());
	}
	
	@Transactional
	public ShelterDTO updateAvailablePetsCount(Long id, Integer newCount)
	{
		Shelter shelter = shelterRepo.findById(id).orElseThrow(()->new RuntimeException("Shelter not found"));
		shelter.setCapacity(newCount);
		return modelMapper.map(shelterRepo.save(shelter), ShelterDTO.class);
		
	}
	
	
}
