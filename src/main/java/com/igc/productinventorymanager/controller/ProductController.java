package com.igc.productinventorymanager.controller;


import com.igc.productinventorymanager.entity.ProductEntity;
import com.igc.productinventorymanager.model.ProductModel;
import com.igc.productinventorymanager.response.Response;
import com.igc.productinventorymanager.service.IProductService;
import com.igc.productinventorymanager.service.impl.ProductServiceImpl;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import org.apache.catalina.LifecycleState;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/product/api")
public class ProductController {

    @Autowired
    ProductServiceImpl productService;

    @PostMapping("/addproduct")
    public ResponseEntity<?> addProduct(@RequestBody @Valid ProductModel productModel) {
        return new ResponseEntity<>(new Response("Product Added", HttpStatus.CREATED, productService.addProduct(productModel)),HttpStatus.CREATED) ;
    }
    /*2} @PostMapping("/addproduct")
    public ResponseEntity<?> addProduct(@RequestBody ProductModel productModel) {
        return new ResponseEntity<?>(productService.addProduct(productModel), HttpStatus.CREATED);
    }*/



    @GetMapping("/getAllProduct")
    public ResponseEntity<?> getAllProduct() {
        return new ResponseEntity<>(new Response("All Product Listed", HttpStatus.FOUND, productService.getAllProduct()), HttpStatus.FOUND) ;
    }


    @GetMapping("/getProduct/{id}")
    public ResponseEntity<?> getProduct(@PathVariable ("id") Integer id) {
        return new ResponseEntity<>(new Response("Product find", HttpStatus.FOUND,productService.getProduct(id)), HttpStatus.FOUND);
    }


    @GetMapping("/updateProduct/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable ("id") Integer id, @RequestBody ProductModel productModel) {
        return  new ResponseEntity<>(new Response("Product updated", HttpStatus.CREATED,productService.updateProduct(id, productModel)), HttpStatus.ACCEPTED) ;
    }


    @GetMapping("/deleteProduct/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable ("id") Integer id) {
        return new ResponseEntity<>(new Response("Product deleted", HttpStatus.ACCEPTED, productService.deleteProduct(id)), HttpStatus.ACCEPTED) ;
    }
}