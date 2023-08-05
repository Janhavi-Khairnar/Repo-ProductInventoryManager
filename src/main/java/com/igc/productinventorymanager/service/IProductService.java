package com.igc.productinventorymanager.service;

import com.igc.productinventorymanager.entity.ProductEntity;
import com.igc.productinventorymanager.model.ProductModel;

import java.util.List;

public interface IProductService {
    public ProductEntity addProduct(ProductModel productModel);

    public List<ProductEntity> getAllProduct();

    public String updateProduct(Integer id, ProductModel productModel);

    public String deleteProduct(Integer id);

    public ProductEntity getProduct(Integer id);


}
