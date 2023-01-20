package com.javatechie.crud.example.service;

import com.javatechie.crud.example.entity.Product;
import com.javatechie.crud.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    //POST
    //for Post Method for one product
    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    //for Post Method for Many products
    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);
    }
    //GET
    //get method for fetching All the products from database
    public List<Product> getProducts(){
        return repository.findAll();
    }
    //get method for fetching product from database BY ID
    public Product getProductById(int id){
        return repository.findById(id).orElse(null);
    }
    //get method for fetching product from database BY NAME
    public Product getProductByName(String name) {
        return repository.findByName(name);
    }
    //FOR DELETE
    public String deleteProduct (int id){
        repository.deleteById(id);
        return "product Removed!!" +id;
    }

    //FOR UPDATE
    public Product updateProduct(Product product){
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }


}
