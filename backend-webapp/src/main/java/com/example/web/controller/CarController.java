package com.example.web.controller;

import com.example.web.exceptions.CarNotFoundException;
import com.example.web.model.Car;
import com.example.web.repository.CarRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    private static final Logger logger = LoggerFactory.getLogger(CarController.class);

    @Autowired
    private CarRepository carRepository;
    @GetMapping("/car")
    public List<Car> getAllCars(){
        logger.info("Get ALL CARS");
        return carRepository.findAll();
    }
    @GetMapping("/car/{id}")
    public Car getCarById(@PathVariable String id){
        if (carRepository.getCarById(id) != null) {
            logger.info("Get CAR by id: "+id);

            return carRepository.getCarById(id);
        }
        else {
            logger.info("ERROR CARS");

            throw new CarNotFoundException();
        }
    }

    @PostMapping("/car")
    public Car createCar(@RequestBody Car newCar){
        logger.info("New Car: CARS");

        newCar.setId(UUID.randomUUID().toString());
        carRepository.save(newCar);
        return newCar;
    }


    @PutMapping(value = "/car/{id}", produces="application/json")
    public Car updateCar(@PathVariable String id, @RequestBody Car updatedCar) {
        Car car = carRepository.getCarById(id);
        car.setBrand(updatedCar.getBrand());
        car.setTopSpeed(updatedCar.getTopSpeed());
        car.setFuelCapacity(updatedCar.getFuelCapacity());
        car.setFuelConsumptionIn100Kilometres(updatedCar.getFuelConsumptionIn100Kilometres());
        car.setKilometresTravelled(updatedCar.getKilometresTravelled());
        //Update values
        carRepository.save(car);
        return car;
    }

    @DeleteMapping("/car/{id}")
    public Car deleteCar(@PathVariable String id) {
        Car car = carRepository.getCarById(id);
        if (car != null) {
            carRepository.deleteById(id);
            return car;
        }
        else {
            throw new CarNotFoundException();
        }
    }
}
