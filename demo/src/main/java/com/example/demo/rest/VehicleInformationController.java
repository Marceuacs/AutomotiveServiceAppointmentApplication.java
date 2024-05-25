package com.example.demo.rest;

import com.example.demo.dao.ServiceAppointment;
import com.example.demo.dao.VehicleInformation;
import com.example.demo.service.VehicleInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("vehicle-information")
public class VehicleInformationController {

    @Autowired
    VehicleInformationService vehicleInformationService;

    @GetMapping("/{id}")
    VehicleInformation findById(@PathVariable("id") Long id) {
        return vehicleInformationService.getVehicleInformation(id);
    }

    @PutMapping("/update")
    VehicleInformation updateVehicle(@RequestBody VehicleInformation vehicleInformation) {
        return vehicleInformationService.updateVehicleInformation(vehicleInformation);
    }
}
