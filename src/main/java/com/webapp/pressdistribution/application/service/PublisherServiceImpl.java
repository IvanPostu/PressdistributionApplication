package com.webapp.pressdistribution.application.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.webapp.pressdistribution.application.dto.RegisterPublisherDto;
import com.webapp.pressdistribution.domain.entity.PublisherEntity;
import com.webapp.pressdistribution.persistence.PublisherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherServiceImpl implements PublisherService {

  @Autowired
  private PublisherRepository publisherRepository;

  @Transactional
  @Override
  public void savePublisher(RegisterPublisherDto publisherDto) {
    PublisherEntity publisherEntity = new PublisherEntity();
    publisherEntity.setEmail(publisherDto.getEmail());
    publisherEntity.setPhone(publisherDto.getPhone());
    publisherEntity.setName(publisherDto.getName());
    publisherEntity.setAddress(publisherDto.getAddress());

    publisherRepository.save(publisherEntity);
  }

  @Transactional
  @Override
  public List<RegisterPublisherDto> getPublishers() {
    List<RegisterPublisherDto> publishers = new ArrayList<>();
    Iterable<PublisherEntity> pIterable = publisherRepository.findAll();

    pIterable.forEach(a -> {
      RegisterPublisherDto registerPublisherDto = new RegisterPublisherDto();
      registerPublisherDto.setEmail(a.getEmail());
      registerPublisherDto.setPhone(a.getPhone());
      registerPublisherDto.setName(a.getName());
      registerPublisherDto.setAddress(a.getAddress());
      publishers.add(registerPublisherDto);
    });

    return publishers;
  }

  @Transactional
  @Override
  public List<PublisherEntity> getPublishersEntities() {
    return publisherRepository.findAll();
  }
  
}
