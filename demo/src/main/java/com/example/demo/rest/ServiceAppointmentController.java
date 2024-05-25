package com.example.demo.rest;

import com.example.demo.dao.ServiceAppointment;
import com.example.demo.service.ServiceAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("appointments")
public class ServiceAppointmentController {

    @Autowired
    ServiceAppointmentService serviceAppointmentService;

    @GetMapping("")
    List<ServiceAppointment> findAll() {
        return serviceAppointmentService.findAll();
    }

    @PostMapping("/create")
    ServiceAppointment createAppointment(@RequestBody ServiceAppointment serviceAppointment) {
        return serviceAppointmentService.saveAppointment(serviceAppointment);
    }

    @PutMapping("/update")
    ServiceAppointment updateAppointment(@RequestBody ServiceAppointment serviceAppointment) {
        return serviceAppointmentService.updateAppointment(serviceAppointment);
    }

    @DeleteMapping("/delete/{id}")
    String deleteAppointment(@PathVariable Long id){
        serviceAppointmentService.deleteAppointment(id);
        return "Successfully deleted!";
    }
}
