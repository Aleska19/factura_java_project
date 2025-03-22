package com.invoice_coder.controllers;

import com.invoice_coder.Products;

import com.invoice_coder.services.ProductsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductsController {
    private final ProductsService productsService;

     public ProductsController(ProductsService productsService){
         this.productsService = productsService;
     }

     @GetMapping
    public List<Products> getAllProducts(){
         return productsService.getAllProducts();
     }

     @PostMapping
    public ResponseEntity<String>   saveProducts(@RequestBody Products products){
         try {
             this.productsService.saveProducts(products);
             return ResponseEntity.ok("Producto guardado exitosamente");
         } catch (Exception e) {
             return ResponseEntity.badRequest().body("Error al guardar producto: " + e.getMessage());
         }
     }
}
