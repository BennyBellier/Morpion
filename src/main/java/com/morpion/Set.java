package com.morpion;

public class Set {

  public enum Symbole {
    CROSS,
    CIRCLE;

    @Override
    public String toString() {
      switch (this) {
        case CROSS:
          return "X";
        case CIRCLE:
          return "O";

        default:
          return "";
      }
    }
  }

  private Symbole[][] matrix;
  private int[] winnerLine;

  Set() {
    matrix = new Symbole[3][3];
  }

  boolean inMatrix(int x) {
    return x >= 0 && x < 3;
  }

  boolean add(int x, int y, Symbole sym) {
    if (!(inMatrix(x) && inMatrix(y)))
      return false;

    if (matrix[x][y] != null)
      return false;

    matrix[x][y] = sym;
    return true;
  }

  boolean remove(int x, int y) {
    if (!(inMatrix(x) && inMatrix(y)))
      return false;

    if (matrix[x][y] == null)
      return false;

    matrix[x][y] = null;
    return true;
  }

  Symbole[][] getMatrix() {
    Symbole[][] m = new Symbole[3][3];
    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m.length; j++) {
        m[i][j] = matrix[i][j];
      }
    }
    return m;
  }

  int[] winnerLine() {
    return winnerLine;
  }

  boolean gamEnded() {
    if (matrix[0][0] != null && (matrix[1][0] == matrix[0][0] && matrix[2][0] == matrix[0][0])) {
      winnerLine = new int[] { 0, 0, 2, 0 };
      return true;
    }
    if (matrix[0][0] != null && (matrix[0][1] == matrix[0][0] && matrix[0][2] == matrix[0][0])) {
      winnerLine = new int[] { 0, 0, 0, 2 };
      return true;
    }
    if (matrix[2][2] != null && (matrix[1][2] == matrix[2][2] && matrix[0][2] == matrix[2][2])) {
      winnerLine = new int[] { 0, 2, 2, 2 };
      return true;
    }
    if (matrix[2][2] != null && (matrix[2][1] == matrix[2][2] && matrix[2][0] == matrix[2][2])) {
      winnerLine = new int[] { 2, 0, 2, 2 };
      return true;
    }
    if (matrix[1][1] != null) {
      if (matrix[0][1] == matrix[1][1] && matrix[2][1] == matrix[1][1]) {
        winnerLine = new int[] { 0, 1, 2, 1 };
        return true;
      }
      if (matrix[1][0] == matrix[1][1] && matrix[1][2] == matrix[1][1]) {
        winnerLine = new int[] { 1, 0, 1, 2 };
        return true;
      }
      if (matrix[0][0] == matrix[1][1] && matrix[2][2] == matrix[1][1]) {
        winnerLine = new int[] { 0, 0, 2, 2 };
        return true;
      }
      if (matrix[2][0] == matrix[1][1] && matrix[0][2] == matrix[1][1]) {
        winnerLine = new int[] { 2, 0, 0, 2 };
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        if (matrix[j][i] != null)
          s.append(" " + matrix[j][i].toString() + " ");
        else
          s.append("   ");

        if (j < 2)
          s.append("|");
      }
      s.append("\n");
      if (i < 2)
        s.append("---+---+---\n");
    }
    return s.toString();
  }

  public static void main(String[] args) {
    Set set = new Set();
    System.out.println(set);
    System.out.println(set.add(1, 1, Symbole.CROSS));
    System.out.println(set);
    System.out.println(set.add(1, 1, Symbole.CIRCLE));
    System.out.println(set);
    System.out.println(set.remove(1, 1));
    System.out.println(set);
    System.out.println(set.add(1, 1, Symbole.CIRCLE));
    System.out.println(set);
  }
}
