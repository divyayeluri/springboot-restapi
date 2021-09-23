package com.divya.bootjpa.controller;

import com.divya.bootjpa.Entity.Product;
import com.divya.bootjpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//controller talks to service class
@RestController
public class ProductController {
    //controller talks to service class
    @Autowired
    private ProductService service;
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody  Product product){
        return  service.saveProduct(product);
    }
    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody  List<Product> products){

        return service.saveProducts(products);
    }
    @GetMapping("/products")
    public List<Product> findAllProducts() {

        return service.getProducts();
    }
    //Pathvariable to pass the id field in url
    @GetMapping("/productById/{id}")
    public Optional<Product> findProductById(@PathVariable int id){
        return service.getProductById(id);
    }
    //any input if you want to pass it as request parameter as part of url,use pathvarible
    @GetMapping("/product/{name}")
    public Optional<Product> findProductByName(@PathVariable String name){
        return service.getProductByname(name);
    }
    @PutMapping("/update")
    public Product updateProduct(@RequestBody  Product product){
        return  service.updateProduct(product);
    }
    @DeleteMapping
    public String deleteProduct(int id){
        return service.deleteProduct(id);
    }


}
