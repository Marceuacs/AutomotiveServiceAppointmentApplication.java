package com.example.demo.service;

import com.example.demo.dao.ServiceAppointment;
import com.example.demo.dao.VehicleInformation;
import com.example.demo.dao.VehicleInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class VehicleInformationService {

    @Autowired
    private VehicleInformationRepository vehicleInformationRepository;

    public VehicleInformation getVehicleInformation(Long vehicleId) {
        Optional<VehicleInformation> vehicleInformation = vehicleInformationRepository.findById(vehicleId);
        return vehicleInformation.get();
    }

    public VehicleInformation updateVehicleInformation(VehicleInformation vehicle){
        VehicleInformation vehicleInformation = vehicleInformationRepository.findById(vehicle.getId()).get();
        vehicleInformation.setCarYear(vehicle.getCarYear());
        vehicleInformation.setModel(vehicle.getModel());

        return vehicleInformationRepository.save(vehicleInformation);
    }
}
