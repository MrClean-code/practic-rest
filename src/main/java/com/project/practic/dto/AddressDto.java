package com.project.practic.dto;

import com.project.practic.entity.Address;
import lombok.Data;

@Data
public class AddressDto {

    private Long id;
    private String home;
    private String street;

    public static Address toAdress(AddressDto addressDto) {
        if (addressDto == null) {
            return null;
        }

        Address address = new Address();

        address.setId(addressDto.getId());
        address.setStreet(addressDto.getStreet());
        address.setHome(addressDto.getHome());

        return address;
    }
}
