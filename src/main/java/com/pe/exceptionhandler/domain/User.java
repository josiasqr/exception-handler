package com.pe.exceptionhandler.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class User {
  @Id
  private String _id;
  @NotBlank
  @NotNull
  private String name;
  @NotBlank
  @NotNull
  @Email
  private String email;
}
