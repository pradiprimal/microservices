package com.pet.details.controller;

import dto.PetDetailsDto;
import dto.PetDto;
import dto.PricingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("pet")
public class PetDetailsController {

    private final RestTemplate restTemplate;

    @Autowired
    public PetDetailsController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public PetDto getPets() {
        return new PetDto(getPetDetailsDtos()
                .stream()
                .map(petDetailsDto -> {
                    petDetailsDto.setPricingDto(restTemplate.getForObject(
                            "http://pet-pricing/pricing/{id}",
                            PricingDto.class,petDetailsDto.getPetId()));
                    return petDetailsDto;
                }).collect(Collectors.toList()));
    }

    private List<PetDetailsDto> getPetDetailsDtos() {
        return Arrays.asList(new PetDetailsDto(20L, "Small Pets", "Kitty", "This is good", null),
                new PetDetailsDto(20L, "Small Pets", "Kitty", "This is good", null),
                new PetDetailsDto(30L, "Small Pets", "Kitty", "This is good", null),
                new PetDetailsDto(20L, "Small Pets", "Kitty", "This is good", null),
                new PetDetailsDto(10L, "Small Pets", "Kitty", "This is good", null));
    }


}
