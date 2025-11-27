package com.happydog.api.service.impl;

import com.happydog.api.dto.PetResponse;
import com.happydog.api.dto.PetRequest;
import com.happydog.api.entity.Pet;
import com.happydog.api.exception.ResourceNotFoundException;
import com.happydog.api.repository.PetRepository;
import com.happydog.api.service.PetService;
import com.happydog.api.util.PetMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {

    private final Logger logger = LoggerFactory.getLogger(PetServiceImpl.class);
    
    private final PetRepository petRepository;

    private final PetMapper petMapper;

    @Override
    public List<PetResponse> getAllPets() {
        logger.info("Getting all pets");
        return petRepository.findAll().stream()
                .map(petMapper::toPetResponse)
                .toList();
    }

    @Override
    public PetResponse getPetById(Long id) {
        logger.info("Getting pet by ID: {}", id);
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pet not found with id: " + id));
    
        return petMapper.toPetResponse(pet);
    }

    @Override
    public PetResponse createPet(PetRequest petRequest) {
        logger.info("Creating pet: {}", petRequest);
        Pet pet = petRepository.save(petMapper.toPet(petRequest));
        return petMapper.toPetResponse(pet);
    }

    @Override
    public PetResponse updatePet(Long id, PetRequest petRequest) {
        logger.info("Updating pet: {}", petRequest);
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pet not found with id: " + id));
        
        pet.setName(petRequest.name());
        pet.setAge(petRequest.age());
        pet.setWeight(petRequest.weight());
        pet.setBreed(petRequest.breed());
        pet.setGender(petRequest.gender());
        pet.setColor(petRequest.color());
        
        return petMapper.toPetResponse(petRepository.save(pet));
    }

    @Override
    public void deletePet(Long id) {
        logger.info("Deleting pet by ID: {}", id);
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pet not found with id: " + id));
        petRepository.delete(pet);
    }
}