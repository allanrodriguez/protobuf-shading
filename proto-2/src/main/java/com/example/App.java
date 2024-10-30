package com.example;

import com.example.proto2.Person2;

public final class App {

  public static void main(String[] args) {
    Person2 y = Person2.newBuilder().setId(2).build();
    System.out.println(y);
  }

  private App() {}
}
