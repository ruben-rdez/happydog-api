package com.happydog.api.dto;

public record PetResponse(
    Long id,
    String name,
    Integer age,
    Double weight,
    String breed,
    String gender,
    String color
) {

}
