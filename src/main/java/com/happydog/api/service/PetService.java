package com.happydog.api.service;

import com.happydog.api.dto.PetRequest;
import com.happydog.api.dto.PetResponse;

import java.util.List;

public interface PetService {
    
    List<PetResponse> getAllPets();
    
    PetResponse getPetById(Long id);
    
    PetResponse createPet(PetRequest pet);
    
    PetResponse updatePet(Long id, PetRequest pet);
    
    void deletePet(Long id);
}