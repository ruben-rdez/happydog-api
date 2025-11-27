package com.happydog.api.util;

import org.springframework.stereotype.Component;
import com.happydog.api.entity.Pet;
import com.happydog.api.dto.PetResponse;

import com.happydog.api.dto.PetRequest;

@Component
public class PetMapper {

    public PetResponse toPetResponse(Pet pet) {
        return new PetResponse(pet.getId(), pet.getName(), pet.getAge(), pet.getWeight(), pet.getBreed(), pet.getGender(), pet.getColor());
    }

    public Pet toPet(PetRequest petRequest) {
        return new Pet(petRequest.name(), petRequest.age(), petRequest.weight(), petRequest.breed(), petRequest.gender(), petRequest.color());
    }

}
