package com.webapp.pressdistribution.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.webapp.pressdistribution.domain.entity.UserRoleEntity;

public class UserRoleRepositoryImpl implements UserRoleRepository {


  @PersistenceContext
  private EntityManager entityManager;

  @Transactional
  @Override
  public void save(UserRoleEntity userRoleEntity) {
    entityManager.persist(userRoleEntity);
  }

  @Transactional
  @Override
  public void deleteAll() {
    entityManager.createQuery("DELETE FROM UserRoleEntity")
      .executeUpdate();
  }
  
}