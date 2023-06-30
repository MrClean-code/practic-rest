package com.project.practic.controller;

import com.project.practic.dto.ClientDto;
import com.project.practic.dto.MenuDto;
import com.project.practic.entity.Client;
import com.project.practic.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("")
    public ResponseEntity<List<ClientDto>> getClientDto() {
        return new ResponseEntity<>(clientService.findAll(),
                HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<Client> addClientDto(@RequestBody ClientDto clientDto) {
        return new ResponseEntity(clientService.saveClient(clientDto),
                HttpStatus.CREATED);
    }
}