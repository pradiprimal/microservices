package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PetDetailsDto {

    private Long petId;

    private String petType;

    private String petName;

    private String remarks;

    private PricingDto pricingDto;
}
