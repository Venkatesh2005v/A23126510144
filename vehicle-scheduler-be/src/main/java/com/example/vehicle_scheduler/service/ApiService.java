package com.example.vehicle_scheduler.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import com.example.vehicle_scheduler.dto.Depot;
import com.example.vehicle_scheduler.dto.DepotResponse;
import com.example.vehicle_scheduler.dto.VehicleTask;
import com.example.vehicle_scheduler.dto.VehicleTaskResponse;

@Service
public class ApiService {
    private final RestTemplate restTemplate;

    @Autowired
    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${api.base.url}")
    private String baseUrl;
    @Value("${api.depots.endpoint}")
    private String depotsEndpoint;
    @Value("${api.vehicles.endpoint}")
    private String vehiclesEndpoint;
    @Value("${logging.bearer.token}")
    private String bearerToken;

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(bearerToken);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    public List<Depot> getDepots(){
        HttpEntity<Void> entity = new HttpEntity<>(createHeaders());
        ResponseEntity<DepotResponse> response = restTemplate.exchange(
                baseUrl + depotsEndpoint,
                HttpMethod.GET,
                entity,
                DepotResponse.class
        );
        return response.getBody().getDepots();
    }

    public List<VehicleTask> getVehicles(){
        HttpEntity<Void> entity = new HttpEntity<>(createHeaders());
        ResponseEntity<VehicleTaskResponse> response = restTemplate.exchange(
                baseUrl + vehiclesEndpoint,
                HttpMethod.GET,
                entity,
                VehicleTaskResponse.class
        );
        return response.getBody().getVehicles();
    }
}
