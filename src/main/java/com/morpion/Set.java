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

  Symbole[][] matrix;

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
