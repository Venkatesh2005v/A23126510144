package com.example.vehicle_scheduler.service;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import com.example.vehicle_scheduler.dto.VehicleTask;
import com.example.vehicle_scheduler.dto.ScheduleResponse;
import java.util.List;
import java.util.ArrayList;

@Service
public class KnapsackService {
    public ScheduleResponse optimize(List<VehicleTask> vehicles, int mechanicHours){

        int n = vehicles.size();
        int[][] dp = new int[n + 1][mechanicHours + 1];
        for(int i = 1; i<=n; i++){
            VehicleTask task = vehicles.get(i-1);
            for(int j = 0; j<=mechanicHours; j++){
                if(task.getDuration() > j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], task.getImpact() + dp[i-1][j - task.getDuration()]);
                }
                }
            }
            List<VehicleTask> selectedTasks = new ArrayList<>();
            int j = mechanicHours;
            for(int i = n; i>0; i--){
                if(dp[i][j] != dp[i-1][j]){
                    VehicleTask task = vehicles.get(i-1);
                    selectedTasks.add(task);
                    j -= task.getDuration();
                }
            }

            int totalDuration = 0;
            int totalImpact = 0;
            for(VehicleTask task : selectedTasks){
                totalDuration += task.getDuration();
                totalImpact += task.getImpact();
            }
            return new ScheduleResponse(selectedTasks, totalDuration, totalImpact);
        }


    }

