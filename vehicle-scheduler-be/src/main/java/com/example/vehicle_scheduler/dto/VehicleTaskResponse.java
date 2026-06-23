package com.example.vehicle_scheduler.dto;
import lombok.Data;
import java.util.List;

@Data
public class VehicleTaskResponse {
    private List<VehicleTask> vehicles;
}
