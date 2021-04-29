package com.daniel.app;

import java.util.Arrays;
import java.util.List;



public class App {

  public static void main(String[] args) {
    String response = "111.222";
    System.out.println(response.matches("^\\d+\\.\\d?\\d?$"));
  }

  private static final List<String> units = Arrays.asList(
          "Fahrenheit", "Kelvin", "Rankine", "Celsius"
  );

  public static String assignment(
          String inputNum,
          String inputUnit,
          String targetUnit,
          String response
  ) {
    // Phase 1 getting rid of invalid inputs
    if (!(units.contains(inputUnit) && units.contains(targetUnit))) return "invalid";
    if(!(
            response.matches("^\\d+\\.\\d?\\d?$") &&
                    inputNum.matches("^\\d+\\.\\d?\\d?$")
    )) return "incorrect";

    // Phase 2 creating expected result
    Double input = Double.parseDouble(inputNum);
    Double expectedResult = 0.0;

    if(inputUnit.equals("Fahrenheit")){
      if(targetUnit.equals("Rankine")) expectedResult = input + 459.67;
      if(targetUnit.equals("Kelvin")) expectedResult = (input - 32) * 5 / 9 + 273.15;
      if(targetUnit.equals("Celsius")) expectedResult = (input - 32) * .5556;
    }
    if(inputUnit.equals("Kelvin")) {
      if(targetUnit.equals("Fahrenheit")) expectedResult = (input - 273.15) * 9/5 + 32;
      if(targetUnit.equals("Rankine")) expectedResult = input * 1.8;
      if(targetUnit.equals("Celsius")) expectedResult = input - 273.15;
    }
    if(inputUnit.equals("Rankine")) {
      if(targetUnit.equals("Fahrenheit")) expectedResult = input - 459.67;
      if(targetUnit.equals("Kelvin")) expectedResult = input * 5 / 9;
      if(targetUnit.equals("Celsius")) expectedResult = (input - 491.67) * 5 / 9;
    }
    if(inputUnit.equals("Celsius")) {
      if(targetUnit.equals("Fahrenheit")) expectedResult = (input * 1.8) + 32.0;
      if(targetUnit.equals("Rankine")) expectedResult = input * 9 / 5 + 491.67;
      if(targetUnit.equals("Kelvin")) expectedResult = input + 273.15;
    }

    // Phase 3 assertion actual result with expected result
    Double actualResult = Double.parseDouble(response);
    if(!expectedResult.equals(actualResult)) return "incorrect";
    return "correct";
  }
}
