package com.daniel.chess;


import java.util.*;

public class Knight3 {

  private static final List<String> vowels = Arrays.asList("A", "E", "I", "O", "U", "Y");
  private static final Random r = new Random();
  private static final String[][] board = new String[][]{
          {"A", "B", "C", null, "E"},
          {null, "G", "H", "I", "J"},
          {"K", "L", "M", "N", "O"},
          {"P", "Q", "R", "S", "T"},
          {"U", "V", null, null, "Y"}
  };

  private static LinkedHashSet<String> result = new LinkedHashSet<>();

  public static void main(String[] args) {
    getAllMoves(); // all response is saved to global results variable
//    getMoves(0, 0, "A");
    System.out.println("result = " + result);
    System.out.println("result.size() = " + result.size());
  }

  public static void getAllMoves() {
    for (int y = 0; y < board.length; y++) {
      for (int x = 0; x < board[0].length; x++) {
        if (board[y][x] == null) continue;
        String move = board[y][x];
        getMoves(y, x, move);
      }
    }
  }

  // This method calling itself 8 times
  public static void getMoves(int y, int x, String move) {
    List<int[]> positions = getPossiblePositions(y, x);
    for (int[] position : positions) {
      move = move + board[position[0]][position[1]];
      if (move.length() == 8) {
        if (!hasMoreThanTwoVowels(move)) result.add(move);
      } else getMoves(position[0], position[1], move);
      move = move.substring(0, move.length() - 1);
    }
  }

  private static boolean hasMoreThanTwoVowels(String w) {
    int count = 0;
    for (String s : w.split("")) {
      if (vowels.contains(s)) count++;
      if (count > 2) return true;
    }
    return false;
  }

  private static List<int[]> getPossiblePositions(int yy, int xx) {
    int[] Y = {1, -1, 1, -1, 2, -2, 2, -2};
    int[] X = {2, 2, -2, -2, 1, 1, -1, -1};
    List<int[]> result = new ArrayList<>();

    for (int i = 0; i < 8; i++) {
      int y = yy + Y[i];
      int x = xx + X[i];
      if (
              y >= 0 && y <= 4 &&
                      x >= 0 && x <= 4 &&
                      board[y][x] != null
      ) result.add(new int[]{y, x});
    }
    return result;
  }

}
