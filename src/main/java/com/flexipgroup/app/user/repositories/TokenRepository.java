package com.flexipgroup.app.user.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flexipgroup.app.entity.TokenEntity;

@Repository
public interface TokenRepository extends CrudRepository<TokenEntity, Long> {

}
