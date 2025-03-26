package com.invoice_coder.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor



public class Products {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    private  String name;
    private String description;
    private String code;
    private int stock;
    private  double price;

//    public Products(String name, String description, String code, int stock, double price ){
//        this.name = name;
//        this.description = description;
//        this.code = code;
//        this.stock = stock;
//        this.price = price;
//    }
//
//    public Long getId() {return id;}
//    public void setId(Long id) {this.id = id;}
//
//    public String getName() {return name;}
//    public void setName(String name) {this.name = name;}
//
//    public String getDescription() {return description;}
//    public void setDescription(String description) {this.description= description;}
//
//    public String getCode() {return code;}
//    public void setCode(String code) {this.code = code;}
//
//    public int getStock() {return stock;}
//    public void setStock(int stock) {this.stock = stock;}
//
//    public double getPrice() {return price;}
//    public void setPrice(double price) {this.price = price;}
}
