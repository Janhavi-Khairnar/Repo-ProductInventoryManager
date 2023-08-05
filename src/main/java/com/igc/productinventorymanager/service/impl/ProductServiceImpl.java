package com.igc.productinventorymanager.service.impl;

import com.igc.productinventorymanager.entity.ProductEntity;
import com.igc.productinventorymanager.model.ProductModel;
import com.igc.productinventorymanager.repo.ProductRepo;
import com.igc.productinventorymanager.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    ProductRepo productRepo;



    @Override
    public ProductEntity addProduct(ProductModel productModel) {
        ProductEntity productEntity = new ProductEntity(productModel);
        return productRepo.save(productEntity);
    }

    @Override
    public List<ProductEntity> getAllProduct() {
        return productRepo.findAll();
    }

    @Override
    public String updateProduct(Integer id, ProductModel productModel) {
        ProductEntity productEntity = getProduct(id);
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
        ProductEntity productEntity = getProduct(id);
        if (productEntity != null) {
            productRepo.delete(productEntity);
            return "Product is deleted.";
        } else {
            return "Product is deleted.";
        }

    }

    @Override
    public ProductEntity getProduct(Integer id){
        return productRepo.findById(id).get();
    }
}
