package com.pe.exceptionhandler.exception.controladvice;

public class NotFoundControlAdvice extends RuntimeException {
  private String code;
  
  public NotFoundControlAdvice(String code, String message) {
    super(message);
    this.code = code;
  }
  
  public String getCode() {
    return code;
  }
  
  public void setCode(String code) {
    this.code = code;
  }
}
