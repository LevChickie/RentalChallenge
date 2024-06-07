package com.example.web.repository;
import com.example.web.model.Rental;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RentalRepository extends MongoRepository<Rental, String> {
    List<Rental> findAll();
    Rental getRentalById(String id);
    Rental save(Rental rental);
    void deleteById(String id);
}
