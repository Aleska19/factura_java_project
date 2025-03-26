package com.invoice_coder.services;

import com.invoice_coder.entities.InvoiceDetails;
import com.invoice_coder.repositories.InvoiceDetailsRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.stereotype.Service;
import java.util.List;

@Service

public class InvoiceDetailsService {
    @Autowired
    private InvoiceDetailsRepositories invoiceDetailsRepositories;

    public  List<InvoiceDetails> getAllInvoiceDetails(){
        return invoiceDetailsRepositories.findAll();
    }

    public InvoiceDetails getInvoiceDetailsById(Long id){
        return invoiceDetailsRepositories.findById(id).orElseThrow(() -> new RuntimeException("Detalles de factura no encontrados"));
    }
}
