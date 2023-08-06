package com.igc.productinventorymanager.service.impl;

import com.igc.productinventorymanager.entity.ProductEntity;
import com.igc.productinventorymanager.exception.ProductNotFoundException;
import com.igc.productinventorymanager.model.ProductModel;
import com.igc.productinventorymanager.repo.ProductRepo;
import com.igc.productinventorymanager.service.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ProductModel addProduct(ProductModel productModel) {
        ProductEntity productEntity = new ProductEntity(productModel);
        ProductModel productModel2 = modelMapper.map(productEntity, ProductModel.class);
        productRepo.save(productEntity);
        return productModel2;
    }

    @Override
    public List<ProductEntity> getAllProduct() {
        return productRepo.findAll();
    }

    @Override
    public String updateProduct(Integer id, ProductModel productModel) {
        ProductEntity productEntity = productRepo.findById(id).get();
        if(productEntity != null) {
                productEntity.setName(productModel.getName());
                productEntity.setDescription(productModel.getDescription());
                productEntity.setPrice(productModel.getPrice());
                productEntity.setQuantity(productModel.getQuantity());
                productEntity.setStatus(productModel.getStatus());
                productRepo.save(productEntity);
                return "Product is updated.";
        }   else {
            return "Product is not available.";
        }
    }

    @Override
    public String deleteProduct(Integer id) {
        ProductEntity productEntity = productRepo.findById(id).get();
        if (productEntity != null) {
            productRepo.delete(productEntity);
            return "Product is deleted.";
        } else {
            return "Product is deleted.";
        }

    }

    @Override
    public ProductModel getProduct(Integer id){
        Optional<ProductEntity> productEntity = productRepo.findById(id);
        if(productEntity.isPresent()) {
            ProductModel productModel = modelMapper.map(productEntity, ProductModel.class);
            return productModel;
        }
        throw new ProductNotFoundException("Product not found.");


    }
}
