package com.pe.exceptionhandler.service;

import com.pe.exceptionhandler.domain.User;

public interface UserService {
  Iterable<User> lists();
  
  User getById(String _id);
  
  User create(User user);
}
