package com.pet.pricing.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class PricingDto implements Serializable {

    private Long id;

    private BigDecimal price;

    private Long petId;

    private String remarks;

}
