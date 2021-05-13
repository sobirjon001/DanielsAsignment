package com.daniel.app;

import java.util.ArrayList;
import java.util.List;

public class Sergey {

  public static void main(String[] args) {
//    int a = 241426227;
//    int b = 5873;
//    System.out.println(test2(a));
    System.out.println(test3(6));
  }

  public static boolean test(int n) {
    String num = n + "";
    if(num.length() < 3) return false;
    for (int i = 0; i < num.length()-2; i++) {
      if(
              Integer.parseInt(num.charAt(i) + "") +
              Integer.parseInt(num.charAt(i+1) + "") ==
              Integer.parseInt(num.charAt(i+2) + "")
      ) return true;
    }
    return false;
  }

  public static boolean test2(int n) {
    String num = n + "";
    if(num.length() < 3) return false;
    for (int i = 0; i < num.length()-1; i++) {
      int curNum = Integer.parseInt(num.charAt(i) + "") +
              Integer.parseInt(num.charAt(i+1) + "");
      if(num.substring(0, i).contains(curNum + "")) return true;
    }
    return false;
  }

  public static boolean test3(int n) {
    List<Integer> numList = new ArrayList<>();
    for (int i = 1; i < n; i++) {
      if (n % i == 0) numList.add(i);
    }
    return numList.stream().mapToInt(Integer::intValue).sum() == n;
  }
}
