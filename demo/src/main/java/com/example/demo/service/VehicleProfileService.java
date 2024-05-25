package com.example.demo.service;

import com.example.demo.dao.VehicleInformation;
import com.example.demo.dao.VehicleInformationRepository;
import com.example.demo.dao.VehicleProfile;
import com.example.demo.dao.VehicleProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VehicleProfileService {

    @Autowired
    private VehicleProfileRepository vehicleProfileRepository;

    @Autowired
    private VehicleInformationRepository vehicleInformationRepository;


    public VehicleProfile saveVehicleProfile(VehicleProfile vehicleProfile){
        return vehicleProfileRepository.save(vehicleProfile);
    }

    public void deleteVehicleFromProfile(Long profileId, Long vehicleId){
        VehicleProfile vehicleProfile = vehicleProfileRepository.findById(profileId).get();
        VehicleInformation vehicleInformation = vehicleInformationRepository.findById(vehicleId).get();
        if(vehicleProfile.getVehicles().remove(vehicleInformation)){
            vehicleProfileRepository.save(vehicleProfile);
        }
    }
}
