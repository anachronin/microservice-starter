package com.myco.sample;

// import java.util.ArrayList;
// import java.util.Formatter;
import com.fasterxml.jackson.databind.ObjectMapper;
// import java.util.*;
import java.io.IOException;

public class SampleApp {
  private final long id;
  private final String category;

  public PersonRecord person;

  public SampleApp(String category, long id) {
      this.category = category;
      this.id = id;
  }

  // get methods
  public String getCategory() { return this.category; }
  public long getId() { return this.id; }
  public PersonRecord getPerson() { return this.person; }

  // request parsing
  public PersonRecord parseRequestJson(String json) {
    ObjectMapper objectMapper = new ObjectMapper();
    PersonRecord req = null;
    try {
      req = objectMapper.readValue(json, PersonRecord.class);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return req;
  }

  // run
  public void processPerson(String json) {
    this.person = parseRequestJson(json);
    this.person.computeBirthYear();
  }

}


