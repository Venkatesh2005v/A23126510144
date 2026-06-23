package main.java.com.example.vehicle_scheduler.service;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ScheduleService {

    @Autowired
    private ApiService apiService;
    @Autowired
    private KnapsackService knapsackService;

    public List<ScheduleResponse> generateSchedules(){
        List<Depot> depots = apiService.getDepots();
        List<VehicleTask> vehicles = apiService.getVehicles();
        List<ScheduleResponse> schedules = new ArrayList<>();
        for(Depot depot : depots){
            ScheduleResponse response = knapsackService.optimize(vehicles, depot.getMechanicHours());
            schedules.add(response);
        }
        return schedules;
    }

}
