package com.flexipgroup.app.user.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flexipgroup.app.entity.ServiceEntity;

@Repository
public interface ServiceRepository extends CrudRepository<ServiceEntity, Long> {

}
