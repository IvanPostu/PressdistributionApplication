package com.webapp.pressdistribution.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "publisher")
@Setter
@Getter
public class PublisherEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  private Long id;

  @Column(name="email")
  private String email;

  @Column(name="phone")
  private String phone;

  @Column(name="name")
  private String name;

  @Column(name="address")
  private String address;
  
}
