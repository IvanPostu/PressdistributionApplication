package com.webapp.pressdistribution.persistence;

import java.util.List;

import com.webapp.pressdistribution.domain.entity.PublicityEntity;

import org.springframework.data.repository.Repository;

public interface PublicityRepository extends Repository<PublicityEntity, Long> {
  
  void save(PublicityEntity publicityEntity);

  List<PublicityEntity> findAll();

  PublicityEntity findById(Long id);

}
