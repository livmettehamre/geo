package com.example.demo;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@Service
public class CountyService {
    private final RestTemplate restTemplate;

    public CountyService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public String getCountyNameByNumber(String countyNumber) {
        String url = "https://api.kartverket.no/kommuneinfo/v1/fylker/" + countyNumber;
        try {
            ResponseEntity<Map<String, Object>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
            });
            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                return (String) response.getBody().get("fylkesnavn");
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fylke ikke funnet");
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fylke ikke funnet");
    }
}

