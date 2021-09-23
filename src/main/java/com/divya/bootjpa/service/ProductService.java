package com.divya.bootjpa.service;

import com.divya.bootjpa.Entity.Product;
import com.divya.bootjpa.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
    //needs repository,so autowired
    @Autowired
    private ProductRepository repository;
    public Product saveProduct(Product product){

        return repository.save(product);
    }
    public List<Product>  saveProducts(List<Product> products){
        List<Product> result = repository.saveAll(products);
        logger.debug("products are" + result);
        return result;
    }
    public List<Product> getProducts(){

        return repository.findAll();
    }
    public Optional<Product> getProductById(int id){
        return repository.findById(id);
    }
    public Optional<Product> getProductByname(String name){
        return repository.findByName(name);
    }
    public String deleteProduct(int id){
        repository.deleteById(id);
        return "product removed" + id;
    }
    public Product updateProduct(Product product){
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        return repository.save(existingProduct);
    }
}
