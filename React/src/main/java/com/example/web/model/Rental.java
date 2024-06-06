package com.example.web.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Rental")
public class Rental {
    @Id
    private String id;
    private Client rentedByClient;
    private Date rentStartDate;
    private Date rentEndDate;
    private float rentalCost;
    private Car rentedCar;
    private int rentedForKilometers;


    public Rental(String id, Object client, Date start, Date end, float rentalCost,Object rentedCar, int kilometers){
        super();
        this.id = id;
        this.rentedByClient = (Client)client;
        this.rentedCar = (Car)rentedCar;
        this.rentStartDate = start;
        this.rentEndDate = end;
        this.rentedForKilometers = kilometers;
        this.rentalCost= rentalCost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Client getRentedByClient() {
        return rentedByClient;
    }

    public void setRentedByClient(Client rentedByClient) {
        this.rentedByClient = rentedByClient;
    }

    public Car getRentedCar() {
        return rentedCar;
    }

    public void setRentedCar(Car rentedCar) {
        this.rentedCar = rentedCar;
    }

    public Date getRentStartDate() {
        return rentStartDate;
    }

    public void setRentStartDate(Date rentStartDate) {
        this.rentStartDate = rentStartDate;
    }

    public Date getRentEndDate() {
        return rentEndDate;
    }

    public void setRentEndDate(Date rentEndDate) {
        this.rentEndDate = rentEndDate;
    }

    public int getRentedForKilometers() {
        return rentedForKilometers;
    }

    public void setRentedForKilometers(int rentedForKilometers) {
        this.rentedForKilometers = rentedForKilometers;
    }

    public float getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(float rentalCost) {
        this.rentalCost = rentalCost;
    }
}
