package com.deg.productservice.controller;

import com.deg.productservice.exception.ClientAlreadyExistsException;
import com.deg.productservice.model.Product;
import com.deg.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping(path = "/")
    public ResponseEntity<Product> create(@RequestBody Product product) throws ClientAlreadyExistsException {
        return new ResponseEntity<>(this.productService.create(product), HttpStatus.OK);
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<Product>> findAll() {
        return new ResponseEntity<>(this.productService.findAll(), HttpStatus.OK);
    }

}
