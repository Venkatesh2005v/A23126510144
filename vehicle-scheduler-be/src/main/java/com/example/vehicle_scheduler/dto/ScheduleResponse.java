package main.java.com.example.vehicle_scheduler.dto;
import lombok.Data;
import lombok.AllArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
public class ScheduleResponse {
    private List<VehicleTask> selectedVehicles;
    private int totalDuration;
    private int totalImpact;
    
}
