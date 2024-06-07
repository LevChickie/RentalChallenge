package com.example.web.controller;

import com.example.web.model.Rental;
import com.example.web.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {
    @Autowired
    private RentalRepository rentalRepository;

    @GetMapping("/rental")
    public List<Rental> getAllRentals(){
        return rentalRepository.findAll();
    }
    @GetMapping("/rental/{id}")
    public Rental getRentalById(@PathVariable String id){
        if (rentalRepository.getRentalById(id) != null) {
            return rentalRepository.getRentalById(id);
        }
        else {
            return null;
        }
    }

    @PostMapping("/rental")
    public Rental createRental(@RequestBody Rental newRental){
        newRental.setId(UUID.randomUUID().toString());
        rentalRepository.save(newRental);
        return newRental;
    }

    @PutMapping("/rental")
    public Rental updateRental(@RequestBody Rental updatedRental){
        Rental rental = rentalRepository.getRentalById(updatedRental.getId());
        //Update values
        rentalRepository.save(rental);
        return rental;
    }

    @DeleteMapping("/rental/{id}")
    public Rental deleteRental(@PathVariable String id) {
        Rental rental = rentalRepository.getRentalById(id);
        if (rental != null) {
            rentalRepository.deleteById(id);
            return rental;
        }
        else {
            return null;
        }
    }


}
