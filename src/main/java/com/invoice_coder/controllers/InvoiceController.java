package com.invoice_coder.controllers;

import com.invoice_coder.entities.Invoice;
import com.invoice_coder.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

//    @PostMapping
//    public ResponseEntity  <Invoice> createInvoice( @RequestBody Invoice invoice) {
//        Invoice newInvoice =  invoiceService.createdInvoice(invoice.getDetails());
//        return ResponseEntity.status(HttpStatus.CREATED).body(newInvoice);
////        return invoiceService.createdInvoice(invoice.getClients(), invoice.getDetails());
//    }


@PostMapping
public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice) {
    Invoice newInvoice = invoiceService.createdInvoice(invoice);
    return ResponseEntity.status(HttpStatus.CREATED).body(newInvoice);
}
//    @GetMapping
//    public List<Invoice> getAllInvoices() {
//        return invoiceService.getAllInvoices();
//    }


    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable Long id){
    return ResponseEntity.ok(invoiceService.getInvoiceById(id));
    }
}
