package com.igc.productinventorymanager.repo;

import com.igc.productinventorymanager.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {

}
