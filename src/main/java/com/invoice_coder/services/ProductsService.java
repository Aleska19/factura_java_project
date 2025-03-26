package com.invoice_coder.services;

import com.invoice_coder.entities.Products;
import com.invoice_coder.repositories.ProductsRepositories;
import org.springframework.stereotype.Service;
import java.util.List;



@Service


public class ProductsService {
    private final ProductsRepositories productsRepositories;
    public ProductsService(ProductsRepositories productsRepositories1, ProductsRepositories productsRepositories){
        this.productsRepositories = productsRepositories;
    }

    public  List<Products> getAllProducts(){
        return productsRepositories.findAll();
    }

    public  Products saveProducts(Products product){

        return productsRepositories.save(product);
    }
}
