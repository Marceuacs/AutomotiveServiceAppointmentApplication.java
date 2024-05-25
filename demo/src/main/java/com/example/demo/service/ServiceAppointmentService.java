package com.example.demo.service;

import com.example.demo.dao.ServiceAppointment;
import com.example.demo.dao.ServiceAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ServiceAppointmentService {

    @Autowired
    private ServiceAppointmentRepository serviceAppointmentRepository;

    public List<ServiceAppointment> findAll(){
        return serviceAppointmentRepository.findAll();
    }

    public ServiceAppointment saveAppointment(ServiceAppointment serviceAppointment){
        return serviceAppointmentRepository.save(serviceAppointment);
    }

    public ServiceAppointment updateAppointment(ServiceAppointment appointment){
        ServiceAppointment serviceAppointment = serviceAppointmentRepository.findById(appointment.getId()).get();
        serviceAppointment.setAppointmentFrom(appointment.getAppointmentFrom());
        serviceAppointment.setAppointmentTo(appointment.getAppointmentTo());
        serviceAppointment.setServiceId(appointment.getServiceId());
        serviceAppointment.setGarage(appointment.getGarage());
        serviceAppointment.setVehicleId(appointment.getVehicleId());

        return serviceAppointmentRepository.save(serviceAppointment);
    }

    public void deleteAppointment(Long id){
        ServiceAppointment serviceAppointment = serviceAppointmentRepository.findById(id).get();
        serviceAppointmentRepository.delete(serviceAppointment);
    }
}
