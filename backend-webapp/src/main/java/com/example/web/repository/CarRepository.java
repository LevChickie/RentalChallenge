package com.example.web.repository;

import com.example.web.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {
    List<Car> findAll();
    Car getCarById(String id);
    Car save(Car car);
    void deleteById(String id);
}