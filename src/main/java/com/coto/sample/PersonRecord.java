package com.myco.sample;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;
import java.time.Year;

public class PersonRecord {
  public String name;
  public int age;
  public int birthYear;

  public void computeBirthYear() {
    int year = Year.now().getValue();
    this.birthYear = year - this.age;
  }
}

