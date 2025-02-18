package com.invoice_coder;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor



public class Products {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false, length = 150)
    private String description;

    @Column(nullable = false, length = 50)
    private String code;

    @Column( nullable = false)
    private int stock;

    @Column( nullable = false)
    private  double price;
}
