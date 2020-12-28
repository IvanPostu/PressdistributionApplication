package com.webapp.pressdistribution.persistence;

import com.webapp.pressdistribution.domain.entity.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
