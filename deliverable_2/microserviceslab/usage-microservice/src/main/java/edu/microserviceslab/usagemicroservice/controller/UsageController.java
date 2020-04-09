package edu.microserviceslab.usagemicroservice.controller;

import edu.microserviceslab.usagemicroservice.entity.UsageStatistic;
import edu.microserviceslab.usagemicroservice.service.interfaces.UsageService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/usage")
public class UsageController {

    private UsageService usageService;

    public UsageController(UsageService usageService) {
        this.usageService = usageService;
    }

    @ResponseBody
    @RequestMapping("/list")
    public List<UsageStatistic> listAllUsageStatistics() {
        return usageService.getAllUsageStatistics();
    }

    @ResponseBody
    @RequestMapping("/driver/{driverId}")
    public List<UsageStatistic> listAllUsageStatisticsForDriver(@PathVariable("driverId") Long driverId) {
        return usageService.getUsageStatisticsPerDriver(driverId);
    }

    @ResponseBody
    @RequestMapping("/vehicle/{vehicleId}")
    public List<UsageStatistic> listAllUsageStatisticsForVehicle(@PathVariable("vehicleId") Long vehicleId) {
        return usageService.getUsageStatisticsPerVehicle(vehicleId);
    }

    @ResponseBody
    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public UsageStatistic AddUsageStatisticsForVehicle(@RequestBody UsageStatistic u) {
        if (u == null) {
            throw new IllegalStateException("Please submit a usage statistic to add.");
        }
        if (u.getCreatedDate() == null){
            throw new IllegalStateException("Please submit a created date statistic.");
        }
        if (u.getSpeed() == null){
            throw new IllegalStateException("Please submit a speed statistic.");
        }
        if (u.getFuelLevel() == null){
            throw new IllegalStateException("Please submit a fuel level statistic.");
        }
        if (u.getRotationsPerMinute() == null){
            throw new IllegalStateException("Please submit a rotations per minute statistic.");
        }
        if (u.getLatitude() == null){
            throw new IllegalStateException("Please submit a latitude statistic.");
        }
        if (u.getLongitude() ==  null){
            throw new IllegalStateException("Please submit a longitude statistic.");
        }
        if (u.getVehicleId() == null){
            throw new IllegalStateException("Please submit a vehicle id for the statistics.");
        }
        return usageService.addUsageStatistic(u);
    }
}
