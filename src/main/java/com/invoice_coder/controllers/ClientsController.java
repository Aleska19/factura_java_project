package com.invoice_coder.controllers;

import com.invoice_coder.entities.Clients;
import com.invoice_coder.services.ClientsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")

public class ClientsController {

    private final ClientsService clientsService;


    public ClientsController(ClientsService clientsService) {

        this.clientsService = clientsService;
    }

    //endpoint to get all clients

    @GetMapping
    public ResponseEntity<List<Clients>> getClients() {
        return ResponseEntity.ok(this.clientsService.getClients());
    }

    //endpoint to save a client

    @PostMapping
    public ResponseEntity<String> saveClient(@RequestBody Clients client) {
        try {
            this.clientsService.saveClient(client);
            return ResponseEntity.ok("Cliente guardado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al guardar cliente: " + e.getMessage());
        }
    }
}