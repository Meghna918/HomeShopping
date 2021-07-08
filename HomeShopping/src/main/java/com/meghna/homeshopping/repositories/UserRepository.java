package com.meghna.homeshopping.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.meghna.homeshopping.entity.UserEntity;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {
	UserEntity findByPhoneNumber(String phoneNumber);
	UserEntity findByUserId(String userId);

}
