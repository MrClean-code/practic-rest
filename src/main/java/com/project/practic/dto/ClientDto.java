package com.project.practic.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.practic.entity.Client;
import lombok.Data;

@Data
public class ClientDto {

    private Long id;
    private String name;
    private String surname;
    private AddressDto address = new AddressDto();

    public static Client toClient(ClientDto clientDto) {
        if (clientDto == null) {
            return null;
        }

        Client client = new Client();

        client.setId(clientDto.getId());
        client.setName(clientDto.getName());
        client.setSurname(clientDto.getSurname());
        client.setAddress(AddressDto.toAdress(clientDto.getAddress()));

        return client;
    }
}
