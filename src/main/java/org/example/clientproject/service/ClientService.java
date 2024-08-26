package org.example.clientproject.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.example.reproject.entity.Companies;

@Service
public class ClientService {

    private final RestTemplate restTemplate;

    public ClientService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Companies getCompany(int id) {
        String url = "http://localhost:8080/companies/get?id=" + id;
        return restTemplate.getForObject(url, Companies.class);
    }

    public String getCompanyAsJson(int id) {
        String url = "http://localhost:8080/companies/get?id=" + id;
        return restTemplate.getForObject(url, String.class);
    }
}

