package com.pe.exceptionhandler.controller;

import com.pe.exceptionhandler.exception.ErrorDTO;
import com.pe.exceptionhandler.domain.User;
import com.pe.exceptionhandler.exception.handlercontroller.NotFoundException;
import com.pe.exceptionhandler.service.UserService;
import jakarta.validation.Valid;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
  private final UserService userService;
  private final MessageSource messageSource;
  
  public UserController(UserService userService, MessageSource messageSource) {
    this.userService = userService;
    this.messageSource = messageSource;
  }
  
  @GetMapping
  public ResponseEntity<Iterable<User>> lists() {
    return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.lists());
  }
  
  @GetMapping("/{_id}")
  public ResponseEntity<User> getById(@PathVariable("_id") String _id) {
    User user = this.userService.getById(_id);
    if (user == null) {
      throw new NotFoundException("P-400", "User not found.");
    }
    
    return ResponseEntity.ok().body(this.userService.getById(_id));
  }
  
  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<ErrorDTO> ControllerNotFoundException(NotFoundException exc) {
    ErrorDTO errorDTO = new ErrorDTO(exc.getCode(), exc.getMessage());
    
    return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
  }
  
  @PostMapping
  public ResponseEntity<User> create(@RequestBody @Valid User user) {
    return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.create(user));
  }
}
