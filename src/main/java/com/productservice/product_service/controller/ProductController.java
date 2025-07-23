package com.productservice.product_service.controller;

import com.productservice.product_service.model.Product;
import com.productservice.product_service.model.ProductDTO;
import com.productservice.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/")
    public ResponseEntity<Product> create(@RequestBody ProductDTO productDTO){
        Product productCreated =productService.create(productDTO);
        return new ResponseEntity<>(productCreated, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Map<String,Object>> getByProductId(@PathVariable Integer productId){
        Map<String, Object> getByProductId = productService.getByProductId(productId);
        return new ResponseEntity<>(getByProductId,HttpStatus.OK);
    }
}
