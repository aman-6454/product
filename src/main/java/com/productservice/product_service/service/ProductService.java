package com.productservice.product_service.service;

import com.productservice.product_service.exception.ProductNotFoundException;
import com.productservice.product_service.model.Product;
import com.productservice.product_service.model.ProductDTO;
import com.productservice.product_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public Product create(ProductDTO productDTO) {
        Product product = new Product();
        product.setProductName(productDTO.getProductName());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        product.setDescription(productDTO.getDescription());
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Map<String,Object> getByProductId(Integer productId) {
        Map<String,Object> map = new LinkedHashMap<>();

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with product Id-" + productId + ". Please try with another product Id."));

        map.put("Id",product.getId());
        map.put("Product name",product.getProductName());
        map.put("Price",product.getPrice());
        map.put("Quantity",product.getQuantity());
        map.put("Description",product.getDescription());
        return map;
    }
}
