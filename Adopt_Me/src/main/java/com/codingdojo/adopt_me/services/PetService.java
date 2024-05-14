package com.codingdojo.adopt_me.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.adopt_me.models.Pet;
import com.codingdojo.adopt_me.repositories.PetRepository;

@Service
public class PetService {

	@Autowired
	private PetRepository petRepo;
	
	public List<Pet> all(){
		return petRepo.findAll();
	}

	public Pet create(Pet newPet, BindingResult result) {
		
		if(result.hasErrors()) {
	   		return null;
	   	}
		
		return petRepo.save(newPet);
	}
	
	public Pet update(Pet pet, BindingResult result) {
		if(result.hasErrors()) {
	   		return null;
	   	}
		
		return petRepo.save(pet);
	}
	
	public void delete(Long id) {
		petRepo.deleteById(id);
	}

	public Pet findPet(Long id) {
		Optional<Pet> optionalPet = petRepo.findById(id);
		if(optionalPet.isPresent()) {
			return optionalPet.get();
		}
		
		else {
			return null;
		}
	}
}