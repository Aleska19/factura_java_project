package com.invoice_coder.controllers;

import com.invoice_coder.Clients;
import com.invoice_coder.services.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientsController {

    private final ClientsService clientsService;

    @Autowired
    public ClientsController(ClientsService clientsService) {
        this.clientsService = clientsService;
    }

    @GetMapping
    public ResponseEntity<List<Clients>> getClients() {
        return ResponseEntity.ok(this.clientsService.getClients());
    }

    @PostMapping
    public ResponseEntity<String> saveClient(@RequestBody Clients clients) {
        try {
            this.clientsService.saveClient(clients);
            return ResponseEntity.ok("Cliente guardado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al guardar cliente: " + e.getMessage());
        }
    }
}