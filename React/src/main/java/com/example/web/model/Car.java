package com.example.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CarRental")
public class Car {
    @Id
    private String id;
    private String brand;
    private int topSpeed;
    private float fuelCapacity;
    private float fuelConsumptionIn100Kilometres;
    private int kilometresTravelled;

    public Car(String id, String brand, int topSpeed, float fuelCapacity, float fuelConsumptionIn100Kilometres, int kilometresTravelled) {
        super();
        this.id = id;
        this.brand = brand;
        this.topSpeed = topSpeed;
        this.fuelCapacity = fuelCapacity;
        this.fuelConsumptionIn100Kilometres = fuelConsumptionIn100Kilometres;
        this.kilometresTravelled = kilometresTravelled;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public float getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(float fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public float getFuelConsumptionIn100Kilometres() {
        return fuelConsumptionIn100Kilometres;
    }

    public void setFuelConsumptionIn100Kilometres(float fuelConsumptionIn100Kilometres) {
        this.fuelConsumptionIn100Kilometres = fuelConsumptionIn100Kilometres;
    }

    public int getKilometresTravelled() {
        return kilometresTravelled;
    }

    public void setKilometresTravelled(int kilometresTravelled) {
        this.kilometresTravelled = kilometresTravelled;
    }


}
