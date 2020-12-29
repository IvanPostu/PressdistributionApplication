package com.webapp.pressdistribution.application.service;

import java.util.Optional;

import com.webapp.pressdistribution.application.dto.RegisterUserDTO;
import com.webapp.pressdistribution.domain.entity.UserEntity;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

  void addUser(RegisterUserDTO userDTO);

  Optional<UserEntity> getUserById(Long id);
}