package com.muddworks.exception;

/**
 * Exception that is thrown when a constraint in the domain is violated.
 * <p>
 * Created by eweinberg
 */
public class DomainConstraintViolation extends RuntimeException {
  public DomainConstraintViolation(String message) {
    super(message);
  }
}
