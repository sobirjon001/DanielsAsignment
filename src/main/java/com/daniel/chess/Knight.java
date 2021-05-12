package com.daniel.chess;

import java.util.*;

public class Knight {

//  private static final List<String> vowels = Arrays.asList("A", "E", "I", "O", "U", "Y");
//  private static List<String> usedVowels = new ArrayList<>();
//  private static final Random r = new Random();
//  private static final String[][] board = new String[][]{
//          {"A", "B", "C", null, "E"},
//          {null, "G", "H", "I", "J"},
//          {"K", "L", "M", "N", "O"},
//          {"P", "Q", "R", "S", "T"},
//          {"U", "V", null, null, "Y"}
//  };
//
//  public static void main(String[] args) {
//
//    Map<String, Integer> history = new LinkedHashMap<>();
//    List<String> consequenceHistory = new  ArrayList<>();
//    int combinations = 0;
//
//    int[] position = getRandomPosition();
//    consequenceHistory.add("start");
//    ArrayList<int[]> possiblePositions;
//
//    while (true) {
//      String currentLetter = board[position[0]][position[1]];
//      possiblePositions = getPossiblePositions(position);
//      System.out.println("possiblePositions.size() = " + possiblePositions.size());
//      possiblePositions.forEach(p -> System.out.println(Arrays.toString(p)));
//
//      for (Iterator<int[]> it = possiblePositions.iterator(); it.hasNext(); ) {
//        int[] possiblePosition = it.next();
//        String possibleLetter = board[possiblePosition[0]][possiblePosition[1]];
//        String possibleMove = currentLetter + "->" + possibleLetter;
//        if(history.containsKey(possibleMove)) {
//          if (history.get(possibleMove) > 7) it.remove();
//        }
//      }
//
//      System.out.println("+++++++++++++++++++++++++++");
//      possiblePositions.forEach(p -> System.out.println(Arrays.toString(p)));
//
//      String currentMove = consequenceHistory.get(consequenceHistory.size()-1) +
//              "->" + currentLetter;
//      if(history.containsKey(currentMove))
//        history.put(currentMove, history.get(currentMove) + 1);
//      else history.put(currentMove, 1);
//      consequenceHistory.add(currentLetter);
//
//      if(possiblePositions.size() == 0) break;
//      int index = r.nextInt(possiblePositions.size());
//      position = new int[]{possiblePositions.get(index)[0], possiblePositions.get(index)[1]};
//      combinations++;
//
//    }
//    System.out.println("combinations = " + combinations);
//    System.out.println("history move/times used:\n" + history);
//    System.out.print("Here are all moves: \n");
//    for (String s : consequenceHistory) {
//      System.out.print("->" + s);
//    }
//    System.out.println("\nVowels used: " + usedVowels);
//  }
//
//  private static boolean isOkVowel(String letter) {
//    if (letter == null) return false;
//    if (!vowels.contains(letter)) return true;
//    if (usedVowels.contains(letter)) return true;
//    if (usedVowels.size() == 2) return false;
//    else usedVowels.add(letter);
//    return true;
//  }
//
//  private static ArrayList<int[]> getPossiblePositions(int[] givenPosition) {
//    int[] Y = {1, -1, 1, -1, 2, -2, 2, -2};
//    int[] X = {2, 2, -2, -2, 1, 1, -1, -1};
//    ArrayList<int[]> result = new ArrayList<>();
//
//    for (int i = 0; i < 8; i++) {
//      int y = givenPosition[0] + Y[i];
//      int x = givenPosition[1] + X[i];
//      if (
//              y >= 0 && y <= 4 &&
//              x >= 0 && x <= 4 &&
//              isOkVowel(board[y][x])
//      ) result.add(new int[]{y, x});
//    }
//    return result;
//  }
//
//  private static int[] getRandomPosition() {
//    int[] result = new int[2];
//    while (true) {
//      int y = r.nextInt(4);
//      int x = r.nextInt(4);
//      result[0] = y;
//      result[1] = x;
//      if(board[y][x] != null) break;
//    }
//    return result;
//  }
}
