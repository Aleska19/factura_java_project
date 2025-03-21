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


    private String name;


    private String lastname;


    private  String docnumber;



    public Clients(String name, String lastname,String docnumber){
        this.name = name;
        this.lastname = lastname;
        this.docnumber = docnumber;
    }

    //getter and setter
    public Long getId(){return id;}
    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getLastname() {return lastname;}
    public void setLastname(String lastname){this.lastname = lastname;}

    public String getDocnumber() {return docnumber;}
    public void setDocnumber(String docnumber){this.docnumber = docnumber;}





}
