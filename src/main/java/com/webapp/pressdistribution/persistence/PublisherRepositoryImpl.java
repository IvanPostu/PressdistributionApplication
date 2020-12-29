package com.webapp.pressdistribution.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.webapp.pressdistribution.domain.entity.PublisherEntity;

public class PublisherRepositoryImpl implements PublisherRepository {
  @PersistenceContext
  private EntityManager entityManager;

  @Transactional
  @Override
  public void save(PublisherEntity publisherEntity) {
    entityManager.persist(publisherEntity);
  }

  @Override
  public List<PublisherEntity> findAll() {
    final String hibernateQuery = "SELECT p FROM PublisherEntity p "
      + " ORDER BY p.id DESC ";

    List<PublisherEntity> publishers = entityManager
      .createQuery(hibernateQuery, PublisherEntity.class)
      .getResultList();


    return publishers;
  }
  
}
