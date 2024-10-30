package com.example;

import com.example.proto3.Person3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;

/**
 * Just a normal library.
 */
public class Lib {

  public Person3 getMessage() {
    var person = Person3.newBuilder().setId(3).build();
    try {
      System.out.println(JsonFormat.printer().omittingInsignificantWhitespace().print(person));
    } catch (InvalidProtocolBufferException e) {
      e.printStackTrace();
    }
    return person;
  }
}
