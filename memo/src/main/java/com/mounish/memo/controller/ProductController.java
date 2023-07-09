package com.mounish.memo.controller;


import com.mounish.memo.model.Product;
//import com.mounish.memo.service.ProductService;
import com.mounish.memo.service.ProductServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Tutorial", description = "Tutorial management APIs")
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductServiceImpl productService;
/*
    @Operation(
            summary = "Retrieve a Tutorial by Id",
            description = "Get a Tutorial object by specifying its id. The response is Tutorial object with id, title, description and published status.",
            tags = { "tutorials", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Product.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })*/
    @GetMapping("/productslist")
    public ResponseEntity<List<Product>> getAllProduct(){
        return ResponseEntity.ok().body(productService.getProductList());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id){
        return ResponseEntity.ok().body(productService.getProductById(id));
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
         return ResponseEntity.ok().body(this.productService.createProduct(product));
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody Product product){
        product.setId(id);
        return ResponseEntity.ok().body(this.productService.updateProduct(product));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable long id){

        return ResponseEntity.ok().body(this.productService.deleteProduct(id));
    }

}
