package com.happydog.api.service.impl;

import com.happydog.api.entity.Pet;
import com.happydog.api.exception.ResourceNotFoundException;
import com.happydog.api.repository.PetRepository;
import com.happydog.api.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;

    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public Pet getPetById(Long id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pet not found with id: " + id));
    }

    @Override
    public Pet createPet(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public Pet updatePet(Long id, Pet pet) {
        Pet existingPet = petRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pet not found with id: " + id));
        
        existingPet.setName(pet.getName());
        existingPet.setAge(pet.getAge());
        existingPet.setWeight(pet.getWeight());
        existingPet.setBreed(pet.getBreed());
        existingPet.setGender(pet.getGender());
        existingPet.setColor(pet.getColor());
        
        return petRepository.save(existingPet);
    }

    @Override
    public void deletePet(Long id) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pet not found with id: " + id));
        petRepository.delete(pet);
    }
}