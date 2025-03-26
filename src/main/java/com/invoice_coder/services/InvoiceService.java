package com.invoice_coder.services;

import com.invoice_coder.entities.Invoice;
import com.invoice_coder.entities.InvoiceDetails;
import com.invoice_coder.entities.Products;
import com.invoice_coder.repositories.InvoiceDetailsRepositories;
import com.invoice_coder.repositories.InvoiceRepositories;
import com.invoice_coder.repositories.ProductsRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class InvoiceService {
    @Autowired
    private InvoiceRepositories invoiceRepositories;

    @Autowired
    private InvoiceDetailsRepositories invoiceDetailsRepositories;

    @Autowired
    private ProductsRepositories productsRepositories;

    @Transactional
//    public Invoice createdInvoice(List<InvoiceDetails> details) {
////        Invoice invoice = new Invoice();
////        invoice.setClients(client);
////        invoice.setInvoiceDate(new Date());
//
//        double total = 0.0;

        public Invoice createdInvoice(Invoice invoice) {

            if (invoice.getClient() == null) {
                throw new RuntimeException("El cliente no puede ser nulo");
            }

            double total = 0.0;
//        Invoice invoice = new Invoice();

        for (InvoiceDetails detail : invoice.getDetails()) {
            Products product = productsRepositories.findById(detail.getProduct().getId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

            detail.setInvoice(invoice);
            detail.setPrice(product.getPrice());
            detail.setSubTotal(detail.getPrice() * detail.getQuantity());
            total += detail.getSubTotal();
        }
        invoice.setTotal(total);
        return invoiceRepositories.save(invoice);
    }


    public Invoice getInvoiceById(Long id) {
            return invoiceRepositories.findById(id).orElseThrow(()-> new RuntimeException("Factura no encontrada"));
    }
}
