package com.pe.exceptionhandler.service;

import com.pe.exceptionhandler.domain.User;
import com.pe.exceptionhandler.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class InUserService implements UserService {
  private final UserRepository userRepository;
  
  public InUserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
  
  @Override
  public Iterable<User> lists() {
    return this.userRepository.findAll();
  }
  
  @Override
  public User getById(String _id) {
    return this.userRepository.findById(_id).orElse(null);
  }
  
  @Override
  public User create(User user) {
    return this.userRepository.save(user);
  }
}
