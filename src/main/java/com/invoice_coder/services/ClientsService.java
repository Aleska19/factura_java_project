package com.invoice_coder.services;

import com.invoice_coder.entities.Clients;
import com.invoice_coder.repositories.ClientsRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ClientsService {
    @Autowired
    private ClientsRepositories clientsRepositories;

    //Save Clients
    public void saveClient(Clients client) {
        clientsRepositories.save(client);
    }

    //Get all Clients
    public List<Clients> getClients(){
        return clientsRepositories.findAll();
    }
}
