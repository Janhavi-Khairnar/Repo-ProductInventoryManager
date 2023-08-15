package com.igc.productinventorymanager.entity;

import com.igc.productinventorymanager.model.ProductModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotBlank(message = "Please enter the product name")
    private String name;
    @NotBlank(message = "Please enter the description")
    private String description;
    @NotNull(message = "Please enter the price")
    private Integer price;
    @NotNull(message = "Please enter the quantity")
    private Integer quantity;
    @NotNull(message = "Please enter the status")
    private String status;

    public ProductEntity(ProductModel productModel) {
        this.name= productModel.getName();
        this. description = productModel.getDescription();
        this.price = productModel.getPrice();
        this.quantity = productModel.getQuantity();
        this.status = productModel.getStatus();

    }
}
