package com.mounish.memo.service;


import com.mounish.memo.exception.ResourceNotFoundException;
import com.mounish.memo.model.Product;
import com.mounish.memo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public  class ProductServiceImpl {

    @Autowired
     ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }


    public Product updateProduct(Product product) {
        Optional<Product> productDb = this.productRepository.findById(product.getId());

        if(productDb.isPresent()) {
            Product productUpdate = productDb.get();
            productUpdate.setId(product.getId());
            productUpdate.setName(product.getName());
            productUpdate.setDescription(product.getDescription());
            productRepository.save(productUpdate);
            return productUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + product.getId());
        }
    }



    public Product getProductById(Long productId) {
        Optional<Product> productDb = this.productRepository.findById(productId);

        if(productDb.isPresent()) {
            return productDb.get();
        }else {
            throw new ResourceNotFoundException("Record not found with id : " + productId);
        }
    }


    public String deleteProduct(Long id) {
        Optional<Product> productDb = this.productRepository.findById(id);

        if(productDb.isPresent()) {
             this.productRepository.deleteById(id);
           return "Success";
        }else {
            return new ResourceNotFoundException("Record not found with id : " + id).toString();
        }

    }

    public List<Product> getProductList(){

        return this.productRepository.findAll();
    }


}
