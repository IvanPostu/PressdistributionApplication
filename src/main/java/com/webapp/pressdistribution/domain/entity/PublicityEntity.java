package com.webapp.pressdistribution.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "publicity")
@Setter
@Getter
public class PublicityEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="publisher_id")
  private PublisherEntity publisherEntity;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="author_id")
  private UserEntity userEntity;

  private String title;
  
  private String content;

  @Column(name="image_data")
  private byte[] image;
  
  @Column(name="image_filename")
  private String filename;
}
