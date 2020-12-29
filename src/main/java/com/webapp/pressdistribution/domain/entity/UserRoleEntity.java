package com.webapp.pressdistribution.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="user_role")
public class UserRoleEntity implements GrantedAuthority {

  private static final long serialVersionUID = 3857804786772325341L;

  public UserRoleEntity(String name){
    this.name=name;
  }

  @Id
  @Column(name="user_id")
  private Long id;
  
  @Column(name = "name")
  private String name;


  @Override
  public String getAuthority() {
    return "ROLE_" + getName();
  }
}