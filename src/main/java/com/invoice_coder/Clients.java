package com.invoice_coder;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Clients {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false, length = 75)
    private String name;

    @Column(nullable = false, length = 75)
    private String lastname;

    @Column( nullable = false, unique = true, length = 11)
    private  String docnumber;



}
