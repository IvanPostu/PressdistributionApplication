package com.webapp.pressdistribution.persistence;

import java.util.Optional;

import com.webapp.pressdistribution.domain.entity.UserEntity;

import org.springframework.data.repository.Repository;



public interface UserRepository extends Repository<UserEntity, Long> {

  UserEntity findByEmail(String email);

  void deleteAll();

  void save(UserEntity userEntity);

  Optional<UserEntity> findById(Long id);

}
