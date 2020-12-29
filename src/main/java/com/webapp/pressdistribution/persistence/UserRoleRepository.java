package com.webapp.pressdistribution.persistence;

import com.webapp.pressdistribution.domain.entity.UserRoleEntity;

import org.springframework.data.repository.Repository;

public interface UserRoleRepository extends Repository<UserRoleEntity, Long> {
  
  void save(UserRoleEntity userRoleEntity);

  void deleteAll();

}