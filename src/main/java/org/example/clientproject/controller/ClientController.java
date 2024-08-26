package org.example.clientproject.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.clientproject.service.ClientService;
import org.example.reproject.entity.Companies;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/external")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/get-companies")
    public ResponseEntity<Companies> getCompany(@RequestParam int id) {
        Companies company = clientService.getCompany(id);
        return ResponseEntity.ok(company);
    }

    @GetMapping("/get-json")
    public ResponseEntity<String> getCompaniesAsJson(@RequestParam int id) throws JsonProcessingException {
        Companies companies = clientService.getCompany(id);
        String jsonResponse = new ObjectMapper().writeValueAsString(companies);
        return ResponseEntity.ok(jsonResponse);
    }

}

