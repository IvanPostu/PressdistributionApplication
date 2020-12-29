package com.webapp.pressdistribution.application.service;

import java.util.List;

import com.webapp.pressdistribution.domain.entity.PublicityEntity;

public interface PublicityService {
  
  void savePublicity(PublicityEntity publicityEntity);

  List<PublicityEntity> allPublicities();

  PublicityEntity getById(Long id);

}
