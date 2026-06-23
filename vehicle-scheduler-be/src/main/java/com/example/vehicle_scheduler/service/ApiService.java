package main.java.com.example.vehicle_scheduler.service;
import java.net.http.HttpHeaders;

import org.springframework.stereotype.Service;

@Service
public class ApiService {
    private final RestTemplate restTemplate;

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
        HttpEntity<Void> entity = new HttpEntity<>(getHeaders());
        ResponseEntity<DepotResponse> response = restTemplate.exchange(
                baseUrl + depotsEndpoint,
                HttpMethod.GET,
                entity,
                DepotResponse.class
        );
        return response.getBody().getDepots();
    }

    public List<VehicleTask> getVehicles(){
        HttpEntity<Void> entity = new HttpEntity<>(getHeaders());
        ResponseEntity<VehicleTaskResponse> response = restTemplate.exchange(
                baseUrl + vehiclesEndpoint,
                HttpMethod.GET,
                entity,
                VehicleTaskResponse.class
        );
        return response.getBody().getVehicles();
    }
}
