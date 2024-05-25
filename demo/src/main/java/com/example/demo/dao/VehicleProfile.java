package com.example.demo.dao;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class VehicleProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<VehicleInformation> vehicles;

    public VehicleProfile() {
    }

    public VehicleProfile(Long id, Customer customer, List<VehicleInformation> vehicles) {
        this.id = id;
        this.customer = customer;
        this.vehicles = vehicles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<VehicleInformation> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleInformation> vehicles) {
        this.vehicles = vehicles;
    }
}
