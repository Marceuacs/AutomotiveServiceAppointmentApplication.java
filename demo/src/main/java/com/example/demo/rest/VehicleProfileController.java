package com.example.demo.rest;

import com.example.demo.dao.VehicleProfile;
import com.example.demo.service.VehicleProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("vehicle-profile")
public class VehicleProfileController {

    @Autowired
    private VehicleProfileService vehicleProfileService;

    @PostMapping("/create")
    public VehicleProfile createVehicleProfile(@RequestBody VehicleProfile vehicleProfile){
        return vehicleProfileService.saveVehicleProfile(vehicleProfile);
    }

    @DeleteMapping("/delete/{profileId}/{vehicleId}")
    public String deleteVehicleFromProfile(@PathVariable Long profileId, @PathVariable Long vehicleId){
        vehicleProfileService.deleteVehicleFromProfile(profileId, vehicleId);
        return "Success";
    }
}
