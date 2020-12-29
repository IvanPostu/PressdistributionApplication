package com.webapp.pressdistribution.application.service;

import java.util.List;

import com.webapp.pressdistribution.application.dto.RegisterPublisherDto;
import com.webapp.pressdistribution.domain.entity.PublisherEntity;

public interface PublisherService {
  
  void savePublisher(RegisterPublisherDto publisherDto);

  List<RegisterPublisherDto> getPublishers();

  List<PublisherEntity> getPublishersEntities();

}
