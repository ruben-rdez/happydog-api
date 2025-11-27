package com.happydog.api.controller;

import com.happydog.api.dto.PetRequest;
import com.happydog.api.dto.PetResponse;
import com.happydog.api.entity.Pet;
import com.happydog.api.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pets")
@RequiredArgsConstructor
@Tag(name = "Pets", description = "Pets API")
public class PetController {

    private final PetService petService;

    /**
     * Get all pets
     * GET /api/pets
     */
    @GetMapping
    @Operation(summary = "Get all pets", description = "Get all pets from the database")
    public ResponseEntity<List<PetResponse>> getAllPets() {
        return ResponseEntity.ok(petService.getAllPets());
    }

    /**
     * Get pet by ID
     * GET /api/pets/{id}
     */
    @GetMapping("/{id}")
    @Operation(summary = "Get pet by ID", description = "Get a pet by its ID")
    public ResponseEntity<PetResponse> getPetById(@PathVariable Long id) {
        return ResponseEntity.ok(petService.getPetById(id));
    }

    /**
     * Create a new pet
     * POST /api/pets
     */
    @PostMapping
    @Operation(summary = "Create a new pet", description = "Create a new pet in the database")
    public ResponseEntity<PetResponse> createPet(@RequestBody PetRequest petRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(petService.createPet(petRequest));
    }

    /**
     * Update an existing pet
     * PUT /api/pets/{id}
     */
    @PutMapping("/{id}")
    @Operation(summary = "Update an existing pet", description = "Update an existing pet in the database")
    public ResponseEntity<PetResponse> updatePet(@PathVariable Long id, 
                                                 @RequestBody PetRequest petRequest) {
        return ResponseEntity.ok(petService.updatePet(id, petRequest));
    }

    /**
     * Delete a pet
     * DELETE /api/pets/{id}
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a pet", description = "Delete a pet from the database")
    public ResponseEntity<Void> deletePet(@PathVariable Long id) {
        petService.deletePet(id);
        return ResponseEntity.noContent().build();
    }
}