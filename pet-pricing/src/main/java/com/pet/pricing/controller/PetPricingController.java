package com.pet.pricing.controller;

import com.pet.pricing.dto.PricingDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("pricing/")
public class PetPricingController {

    @GetMapping("{id}")
    public PricingDto pricingById(@PathVariable Long id) {
        return getPricingDtos(id).orElseThrow();
    }

    private Optional<PricingDto> getPricingDtos(Long id) {
        List<PricingDto> pricingDtos = Arrays.asList(new PricingDto(1L, new BigDecimal(300), 30L, "test"),
                new PricingDto(2L, new BigDecimal(4000), 20L, "test"),
                new PricingDto(3L, new BigDecimal(5000), 10L, "test"));
        return pricingDtos.stream().filter(pricingDto -> pricingDto.getPetId().equals(id)).findFirst();
    }
}
