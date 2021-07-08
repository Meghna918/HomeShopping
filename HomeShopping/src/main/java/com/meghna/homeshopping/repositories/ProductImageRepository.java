package com.meghna.homeshopping.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.meghna.homeshopping.entity.ProductImageEntity;
@Repository
public interface ProductImageRepository extends JpaRepository<ProductImageEntity, Long>{
      Optional<ProductImageEntity> findById(Long id);
}
