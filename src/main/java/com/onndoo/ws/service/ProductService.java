package com.onndoo.ws.service;

import java.util.List;

import com.onndoo.ws.model.Product;

public interface ProductService {

	Product save(Product p);
    Product update(Product p);
    List<Product> listAll();
    Product findById(Integer id);
    void delete(Integer id);
    
}
