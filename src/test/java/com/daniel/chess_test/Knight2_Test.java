package com.daniel.chess_test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class Knight2_Test {

  private static LinkedHashSet<String> actualResult;

  @BeforeClass
  public static void init() {
    actualResult = com.daniel.chess.Knight2.getAllPossibleMoves();
  }

  @Test
  public void test1() {
    boolean allAre8InLength = true;
    for (String s : actualResult) {
      if (s.length() != 8) {
        allAre8InLength = false;
        break;
      }
    }
    Assert.assertTrue(allAre8InLength);
  }

  @Test
  public void test2() {
    List<String> vowels = Arrays.asList("A", "E", "I", "O", "U", "Y");
    boolean noMoreThan2Vowels = true;
    for (String s : actualResult) {
      int count = 0;
      for (String s1 : s.split("")) {
        if (vowels.contains(s1)) count++;
      }
      if (count > 2) {
        noMoreThan2Vowels = false;
        break;
      }
    }
    Assert.assertTrue(noMoreThan2Vowels);
  }

  @Test
  public void test3() {
    boolean noNullValues = true;
    for (String s : actualResult) {
      if (s.contains(null)) {
        noNullValues = false;
        break;
      }
    }
    Assert.assertTrue(noNullValues);
  }

  @Test
  public void test4() {
    boolean allAreLetters = true;
    for (String s : actualResult) {
      for (char ch : s.toCharArray()) {
        if (!Character.isLetter(ch)) {
          allAreLetters = false;
          break;
        }
      }
      if (!allAreLetters) break;
    }
    Assert.assertTrue(allAreLetters);
  }
}
