package com.webapp.pressdistribution.persistence;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.webapp.pressdistribution.domain.entity.UserEntity;

public class UserRepositoryImpl implements UserRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public UserEntity findByEmail(String email) {

    final String hQuery = "FROM UserEntity u WHERE u.email=:paramEmail";

    TypedQuery<UserEntity> typedQuery = entityManager.createQuery(hQuery, UserEntity.class).setParameter("paramEmail",
        email);

    UserEntity user = typedQuery.getSingleResult();
    return user;
  }

  @Override
  public void deleteAll() {
    entityManager.createQuery("DELETE FROM UserEntity").executeUpdate();
  }

  @Transactional
  @Override
  public void save(UserEntity userEntity) {
    entityManager.persist(userEntity);
  }

  @Override
  public Optional<UserEntity> findById(Long id) {
    UserEntity userEntity = entityManager.find(UserEntity.class, id);
    return Optional.ofNullable(userEntity);
  }

}