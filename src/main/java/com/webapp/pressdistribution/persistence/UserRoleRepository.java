package com.webapp.pressdistribution.persistence;

import com.webapp.pressdistribution.domain.entity.UserRoleEntity;

import org.springframework.data.repository.CrudRepository;

public interface UserRoleRepository extends CrudRepository<UserRoleEntity, Long> {

}
