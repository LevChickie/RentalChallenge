package com.example.web.repository;

import com.example.web.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClientRepository extends MongoRepository<Client, String> {
    List<Client> findAll();
    Client getClientById(String id);
    Client save(Client client);
    void deleteById(String id);
}
