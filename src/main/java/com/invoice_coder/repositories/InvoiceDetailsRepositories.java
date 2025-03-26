package com.invoice_coder.repositories;

import com.invoice_coder.entities.InvoiceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InvoiceDetailsRepositories extends JpaRepository<InvoiceDetails, Long> {
}
