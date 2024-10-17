package org.example;

public class MyArraySizeException extends RuntimeException {
  public MyArraySizeException(String message)
  {
    super("Массив не 4*4.");
  }
}