package com.webapp.pressdistribution.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.webapp.pressdistribution.application.dto.RegisterUserDTO;
import com.webapp.pressdistribution.domain.entity.UserEntity;
import com.webapp.pressdistribution.domain.entity.UserRoleEntity;
import com.webapp.pressdistribution.persistence.UserRepository;
import com.webapp.pressdistribution.persistence.UserRoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserRoleRepository userRoleRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserEntity user = userRepository.findByEmail(username);
    return user;
  }

  @Transactional
  @Override
  public void addUser(RegisterUserDTO userDTO) {
    UserEntity userEntity = new UserEntity();
    List<UserRoleEntity> roles = new ArrayList<>();

    if(userDTO.isReader()) roles.add(new UserRoleEntity("READER"));
    if(userDTO.isWriter()) roles.add(new UserRoleEntity("WRITER"));

    userEntity.setEmail(userDTO.getEmail());
    userEntity.setPassword(userDTO.getPassword());
    userEntity.setActive(true);
    userEntity.setRoles(roles);
    userRepository.save(userEntity);

    roles.forEach(a -> a.setId(userEntity.getId()));

    userRoleRepository.saveAll(roles);

    char c = 'a';
  }

  @Override
  public Optional<UserEntity> getUserById(Long id) {
    Optional<UserEntity> userEntity = userRepository.findById(id);
    return userEntity;
  }


}