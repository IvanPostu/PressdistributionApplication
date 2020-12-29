package com.webapp.pressdistribution.persistence;

import com.webapp.pressdistribution.domain.entity.UserEntity;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

  UserEntity findByEmail(String email);

}
