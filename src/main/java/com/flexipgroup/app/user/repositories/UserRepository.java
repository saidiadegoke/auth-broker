package com.flexipgroup.app.user.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flexipgroup.app.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
	UserEntity findByUserId(String userId);

	UserEntity findByEmail(String email);
}
