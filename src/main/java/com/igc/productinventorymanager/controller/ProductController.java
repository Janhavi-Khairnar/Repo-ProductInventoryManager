package com.igc.productinventorymanager.controller;


import com.igc.productinventorymanager.entity.ProductEntity;
import com.igc.productinventorymanager.model.ProductModel;
import com.igc.productinventorymanager.service.IProductService;
import com.igc.productinventorymanager.service.impl.ProductServiceImpl;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.apache.catalina.LifecycleState;
import org.apache.coyote.Response;
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

   /*1} @PostMapping("/addproduct")
    public ProductEntity addProduct(@RequestBody ProductModel productModel) {
        return productService.addProduct(productModel);
    }*/
    //2}
    @PostMapping("/addproduct")
    public ResponseEntity<ProductEntity> addProduct(@RequestBody ProductModel productModel) {
        return new ResponseEntity<ProductEntity>(productService.addProduct(productModel), HttpStatus.CREATED);
    }
   /*3} @PostMapping("/addproduct")
    public ResponseEntity<?> addProduct(@RequestBody ProductModel productModel) {
        return new ResponseEntity<?>(productService.addProduct(productModel), HttpStatus.CREATED);
    }*/
    /*3} @PostMapping("/addproduct")
    public ResponseEntity<?> addProduct(@RequestBody ProductModel productModel) {
        return new ResponseEntity<>(productService.addProduct(productModel), HttpStatus.CREATED);
    }*/


    @GetMapping("/getAllProduct")
    public List<ProductEntity> getAllProduct() {
        return productService.getAllProduct();
    }
   /* @GetMapping("/getAllProduct")
    public ResponseEntity<?> getAllProduct() {
        return new ResponseEntity<> (productService.getAllProduct(), HttpStatus.FOUND);
    }*/




    @GetMapping("/getProduct/{id}")
    public ProductEntity getProduct(@PathVariable ("id") Integer id) {
        return productService.getProduct(id);
    }
   /*  @GetMapping("/getProduct/{id}")
    public ResponseEntity<?> getProduct(@PathVariable ("id") Integer id) {
        return new ResponseEntity<>(productService.getProduct(id), HttpStatus.FOUND);
    }  */



    @GetMapping("/updateProduct/{id}")
    public String updateProduct(@PathVariable ("id") Integer id, @RequestBody ProductModel productModel) {
        return  productService.updateProduct(id, productModel);
    }
    /* @GetMapping("/updateProduct/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable ("id") Integer id, @RequestBody ProductModel productModel) {
        return new ResponseEntity<>(productService.updateProduct(id, productModel), HttpStatus.ACCEPTED;
    } */







    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable ("id") Integer id) {
        return productService.deleteProduct(id);
    }

    /* @GetMapping("/deleteProduct/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable ("id") Integer id) {
        return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.ACCEPTED);
    } */
}
