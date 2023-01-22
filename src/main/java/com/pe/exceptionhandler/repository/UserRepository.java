package com.pe.exceptionhandler.repository;

import com.pe.exceptionhandler.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
}
