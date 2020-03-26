package edu.microserviceslab.vehiclemicroservice.controller;

import edu.microserviceslab.vehiclemicroservice.entity.Vehicle;
import edu.microserviceslab.vehiclemicroservice.service.interfaces.VehicleService;
import org.springframework.web.bind.annotation.*;
import edu.microserviceslab.vehiclemicroservice.entity.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @ResponseBody
    @RequestMapping("/list")
    public List<Vehicle> listAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @ResponseBody
    @RequestMapping("/licensePlate/{vehicleId}")
    public String getVehicleLicensePlate(@PathVariable("vehicleId") Long vehicleId) {
        return vehicleService.getVehicleLicensePlate(vehicleId);
    }

    @ResponseBody
    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public Vehicle addVehicleToDatabase(@RequestBody Vehicle vehicle){
        if (vehicle == null) {
            throw new IllegalStateException("Please submit a vehicle to add.");
        }
//        System.out.println(vehicle.getRegistration());
        return vehicleService.addVehicle(vehicle);
                //vehicle.getRegistration();
//                vehicleService.addVehicle(vehicle);
    }
}
