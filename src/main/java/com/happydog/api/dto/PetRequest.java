package com.happydog.api.dto;

import jakarta.validation.constraints.NotNull;

public record PetRequest(
    @NotNull(message = "Name is required")
    String name,
    @NotNull(message = "Age is required")
    Integer age,
    @NotNull(message = "Weight is required")
    Double weight,
    @NotNull(message = "Breed is required")
    String breed,
    @NotNull(message = "Gender is required")
    String gender,
    String color
) {

}
