package com.example.vehicle_scheduler.dto;
import lombok.Data;

import java.beans.JavaBean;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class VehicleTask {

    @JsonProperty("TaskID")
    private String taskId;

    @JsonProperty("Duration")
    private int duration;

    @JsonProperty("Impact")
    private int impact;
}
