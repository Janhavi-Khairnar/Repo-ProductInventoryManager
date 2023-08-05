package com.igc.productinventorymanager.entity;

import com.igc.productinventorymanager.model.ProductModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
  //  @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Integer id;
    private String name;
    private String description;
    private Integer price;
    private Integer quantity;
    private String status;

    public ProductEntity(ProductModel productModel) {
        this.name= productModel.getName();
        this. description = productModel.getDescription();
        this.price = productModel.getPrice();
        this.quantity = productModel.getQuantity();
        this.status = productModel.getStatus();

    }
}
