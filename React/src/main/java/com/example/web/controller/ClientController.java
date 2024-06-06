package com.example.web.controller;
import com.example.web.model.Client;
import com.example.web.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/clients/")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/client")
    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }
   @GetMapping("/client/{id}")
    public Client getClientById(@PathVariable String id){
        if (clientRepository.getClientById(id) != null) {
            return clientRepository.getClientById(id);
        }
        else {
            return null;
        }
    }

    @PostMapping("/client")
    public Client createClient(@RequestBody Client newClient){
        newClient.setId(UUID.randomUUID().toString());
        clientRepository.save(newClient);
        return newClient;
    }

    @PutMapping(value = "/client/{id}", produces="application/json")
    public Client updateClient(@RequestBody Client updatedClient){
        Client client = clientRepository.getClientById(updatedClient.getId());
        client.setFirstName(updatedClient.getFirstName());
        client.setMiddleName(updatedClient.getMiddleName());
        client.setLastName(updatedClient.getLastName());
        client.setAge(updatedClient.getAge());
        //Update values
        clientRepository.save(client);
        return client;
    }

    @DeleteMapping("/client/{id}")
    public Client deleteClient(@PathVariable String id) {
        Client client = clientRepository.getClientById(id);
        if (client != null) {
            clientRepository.deleteById(id);
            return client;
        }
        else {
            return null;
        }
    }
}
