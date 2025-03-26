package com.invoice_coder.repositories;

import com.invoice_coder.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface InvoiceRepositories extends JpaRepository<Invoice, Long> {
}
