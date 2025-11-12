package com.happydog.api.service;

import com.happydog.api.entity.Pet;

import java.util.List;

public interface PetService {
    
    List<Pet> getAllPets();
    
    Pet getPetById(Long id);
    
    Pet createPet(Pet pet);
    
    Pet updatePet(Long id, Pet pet);
    
    void deletePet(Long id);
}