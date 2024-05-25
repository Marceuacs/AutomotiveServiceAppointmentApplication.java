package com.example.demo.dao;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class ServiceAppointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime appointmentFrom;

    private LocalDateTime appointmentTo;

    private Long garage;

    @OneToOne
    private VehicleInformation vehicle;

    private Long serviceId;

    public ServiceAppointment() {
    }

    public ServiceAppointment(Long id, LocalDateTime appointmentFrom, LocalDateTime appointmentTo, Long garage, VehicleInformation vehicle, Long serviceId) {
        this.id = id;
        this.appointmentFrom = appointmentFrom;
        this.appointmentTo = appointmentTo;
        this.garage = garage;
        this.vehicle = vehicle;
        this.serviceId = serviceId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getAppointmentFrom() {
        return appointmentFrom;
    }

    public void setAppointmentFrom(LocalDateTime appointmentFrom) {
        this.appointmentFrom = appointmentFrom;
    }

    public LocalDateTime getAppointmentTo() {
        return appointmentTo;
    }

    public void setAppointmentTo(LocalDateTime appointmentTo) {
        this.appointmentTo = appointmentTo;
    }

    public Long getGarage() {
        return garage;
    }

    public void setGarage(Long garage) {
        this.garage = garage;
    }

    public VehicleInformation getVehicleId() {
        return vehicle;
    }

    public void setVehicleId(VehicleInformation vehicle) {
        this.vehicle = vehicle;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }
}
