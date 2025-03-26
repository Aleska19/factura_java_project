package com.invoice_coder.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "invoice")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @JoinColumn(name = "client_id", nullable = false)
    @ManyToOne
    private Clients client;




    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "invoice_date")
    private Date invoiceDate;

//    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<InvoiceDetails> details;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<InvoiceDetails> details = new ArrayList<>();

    @Column(name = "total")
    private Double total;

    @PrePersist
    @PreUpdate
    public void calculateTotal() {
        this.total = details.stream()
                .mapToDouble(detail -> detail.getPrice() * detail.getQuantity())
                .sum();
    }
}




//    public void invoice(Clients clients, Date invoiceDate, Double total){
//        this.clients = clients;
//        this.invoiceDate = invoiceDate;
//        this.total= total;
//    }


