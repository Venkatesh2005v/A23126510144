package com.example.vehicle_scheduler.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.RequiredArgsConstructor;
import com.example.vehicle_scheduler.service.ScheduleService;
import com.example.vehicle_scheduler.dto.ScheduleResponse;
import java.util.List;

@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;
    @GetMapping
    public List<ScheduleResponse> generateSchedules(){
        return scheduleService.generateSchedules();
    }

}
