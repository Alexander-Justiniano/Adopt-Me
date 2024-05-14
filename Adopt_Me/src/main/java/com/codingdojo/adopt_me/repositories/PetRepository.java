package com.codingdojo.adopt_me.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.adopt_me.models.Pet;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {

	List<Pet> findAll();
	
	Optional<Pet> findById(Long id);
}
