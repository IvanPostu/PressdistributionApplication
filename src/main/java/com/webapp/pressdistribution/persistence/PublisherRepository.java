package com.webapp.pressdistribution.persistence;

import java.util.List;

import com.webapp.pressdistribution.domain.entity.PublisherEntity;

import org.springframework.data.repository.Repository;


public interface PublisherRepository extends Repository<PublisherEntity, Long> {
  
  void save(PublisherEntity publisherEntity);
  
  List<PublisherEntity> findAll();
}
