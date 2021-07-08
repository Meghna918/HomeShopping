package com.meghna.homeshopping.repositories;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.meghna.homeshopping.entity.ProductEntity;



@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
	Optional<ProductEntity> findById(Long id);
}
