package com.daniel.app;

import io.cucumber.java.sl.In;

import java.util.*;

public class Mai {

  public static void main(String[] args) {
    int[] stock = new int[]{10, 12, 15, 49, 10, 30, 50, 30, 5};



//    System.out.println("profit = " + getProfitAgainstAll(stock));
//    System.out.println("stringPeriods(\"abcdabcdabcd\") = " + stringPeriods("abcdabcdabcd"));
//
//    List<String> list = Arrays.asList("a", "b", "c", "d");
//
//    list.stream().forEach(System.out::println);

    Map<String, String> map = new HashMap<>();
    System.out.println("map.get(\"hello\") = " + map.get("hello"));
  }

  public static int getProfit1(int[] stock) {
    int min = stock[0];
    int max = stock[0];
    for (int j : stock) {
      if (min > j) min = j;
      if (max < j) max = j;
    }
    return max - min;
  }

  public static int getProfit2(int[] stock) {
    Arrays.sort(stock);
    return stock[stock.length - 1] - stock[0];
  }

  public static int getProfitInSeries(int[] stock) {
    int r = 0;
    for (int i = 0; i < stock.length - 1; i++) {
      int n = stock[i + 1] - stock[i];
      if (n > r) r = n;
    }
    return r;
  }

  public static int getProfitAgainstAll(int[] stock) {
    int r = 0;
    for (int i = 0; i < stock.length-1; i++) {
      for (int j = i+1; j < stock.length; j++) {
        int n = stock[j] - stock[i];
        if(n > r) r = n;
      }
    }
    return r;
  }

  public static Object stringPeriods(String s) {
    String r = null;
    for (int i = (s.length() / 2); i >=1; i--) {
      if(s.split(s.substring(0, i)).length == 0) return s.substring(0, i);
    }
    return -1;
  }
}
