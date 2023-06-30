package com.project.practic.entity;

import com.project.practic.dto.AddressDto;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address", schema = "practic")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "home")
    private String home;

    @Column(name = "street")
    private String street;

    public static AddressDto toAdressDto(Address address) {
        AddressDto addressDto = new AddressDto();

        addressDto.setId(address.getId());
        addressDto.setStreet(address.getStreet());
        addressDto.setHome(address.getHome());

        return addressDto;
    }
}