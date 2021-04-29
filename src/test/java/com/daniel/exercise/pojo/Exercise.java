package com.daniel.exercise.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Exercise {
  private String input;
  private String inputUnit;
  private String targetUnit;
  private String response;

  public static Exercise exercise;
}
