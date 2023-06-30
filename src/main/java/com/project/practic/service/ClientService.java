package com.project.practic.service;

import com.project.practic.dto.ClientDto;
import com.project.practic.dto.MenuDto;
import com.project.practic.entity.Client;
import com.project.practic.entity.Ingredient;
import com.project.practic.entity.Menu;
import com.project.practic.exception.IngredientException;
import com.project.practic.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientService {

    private final ClientRepository clientRepository;

    @Transactional
    public List<ClientDto> findAll() {
        List<Client> list = clientRepository.findAll();
        return list.stream()
                .map(Client::toClientDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public Set<ClientDto> findClientFetched() {
        Set<Client> menuSet = clientRepository.findClientFetched();
        return menuSet.stream()
                .map(Client::toClientDto)
                .collect(Collectors.toSet());
    }

    @Transactional
    public Client saveClient(ClientDto clientDto) {
        var client = ClientDto.toClient(clientDto);
        clientRepository.save(client);
        return client;
    }

    @Transactional
    public Client getClient(Long id){
        return clientRepository.findById(id).orElseThrow(() ->
                new RuntimeException(MessageFormat.format("Could not find ingredient with id: {0}", id)));

    }
}