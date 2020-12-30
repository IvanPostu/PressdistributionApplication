package com.webapp.pressdistribution.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.webapp.pressdistribution.domain.entity.PublicityEntity;

public class PublicityRepositoryImpl implements PublicityRepository {
  @PersistenceContext
  private EntityManager entityManager;

  @Transactional
  @Override
  public void save(PublicityEntity publicityEntity) {
    entityManager.persist(publicityEntity);
  }

  @Override
  public List<PublicityEntity> findAll() {
    final String hibernateQuery = " SELECT new "+
    " com.webapp.pressdistribution.domain.entity.PublicityEntity "+
    " (p.id, p.title, p.content, p.filename) FROM PublicityEntity p "
      + " ORDER BY p.id DESC ";

    List<PublicityEntity> piblicities = entityManager
      .createQuery(hibernateQuery, PublicityEntity.class)
      .getResultList();


    return piblicities;
  }

  @Override
  public PublicityEntity findById(Long id) {
    PublicityEntity publicityEntity = entityManager.find(PublicityEntity.class, id);
    return publicityEntity;
  }
  
}
