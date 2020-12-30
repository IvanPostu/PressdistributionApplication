package com.webapp.pressdistribution.application.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.webapp.pressdistribution.domain.entity.PublicityEntity;
import com.webapp.pressdistribution.persistence.PublicityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
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
      if(a.getContent().length()>100){
        a.setContent(a.getContent().substring(0, 100)+ " ...");
      }
    });

    return publicities;
  }

  @Transactional
  @Override
  public PublicityEntity getById(Long id) {
    PublicityEntity publicityEntity = publicityRepository.findById(id);
    String s1 = publicityEntity.getPublisherEntity().getAddress();
    String s2 = publicityEntity.getUserEntity().getEmail();

    if(s1 == s2){
      log.info(1);
    }

    return publicityEntity;
  }
  


}
