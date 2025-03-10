package com.invoice_coder.repositories;

import com.invoice_coder.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository



public interface ClientsRepositories extends JpaRepository<Clients, Long> {



}
