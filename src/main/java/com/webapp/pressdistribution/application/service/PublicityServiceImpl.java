package com.webapp.pressdistribution.application.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.webapp.pressdistribution.domain.entity.PublicityEntity;
import com.webapp.pressdistribution.persistence.PublicityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicityServiceImpl implements PublicityService {

  @Autowired
  private PublicityRepository publicityRepository;

  @Transactional
  @Override
  public void savePublicity(PublicityEntity publicityEntity) {
    publicityRepository.save(publicityEntity);

  }

  @Override
  public List<PublicityEntity> allPublicities() {
    List<PublicityEntity> publicities = new ArrayList<>();
    Iterable<PublicityEntity> publicitiesIterable = publicityRepository.findAll();

    publicitiesIterable.forEach(a -> {
      publicities.add(a);
    });

    return publicities;
  }

  @Override
  public PublicityEntity getById(Long id) {
    PublicityEntity publicityEntity = publicityRepository.findById(id);
    return publicityEntity;
  }
  


}
