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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "publicity")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
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

  public PublicityEntity (Long id, String title,String content, String filename){
    this.id = id;
    this.title = title;
    this.content = content;
    this.filename = filename;
  }
  
}
