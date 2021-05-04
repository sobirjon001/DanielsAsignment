package com.daniel.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import jdk.nashorn.internal.parser.JSONParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Map;

public class Json_tests {
  public static void main(String[] args) {
    try {
      ObjectMapper mapper = new ObjectMapper();
      Map<?, ?> map = mapper.readValue(Paths.get("src/main/resources/test.json").toFile(), Map.class);
      for (Map.Entry<?, ?> entry : map.entrySet()) {
        System.out.println("entry.getKey() = " + entry.getKey());
        System.out.println("entry.getValue() = " + entry.getValue());
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
