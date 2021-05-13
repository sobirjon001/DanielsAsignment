package com.daniel.app;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stream_Practise {

  public static void main(String[] args) {
    List<Integer> numbers = getAscendingNumbers(50);
    System.out.println(numbers.stream().filter(p -> p % 2 ==0).map(p -> p*2).collect(Collectors.toList()));
  }


  private static List<Integer> getAscendingNumbers(int upto) {
    return IntStream.range(0, upto).boxed().collect(Collectors.toList());
  }
}
