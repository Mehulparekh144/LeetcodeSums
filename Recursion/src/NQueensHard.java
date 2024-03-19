import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueensHard {
  List<List<String>> result;

  public List<List<String>> solveNQueens(int n) {
    result = new ArrayList<>();
    char[][] board = new char[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        board[i][j] = '.';
      }
    }
    backtrack(0, board);
    return result;
  }

  public void backtrack(int col, char[][] board) {
    if (col == board.length) {
      result.add(construct(board.clone()));
      return;
    }
    for (int row = 0; row < board.length; row++) {
      if (isSafe(row, col, board)) {
        board[row][col] = 'Q';
        backtrack(col + 1, board);
        board[row][col] = '.';
      }
    }
  }

  public boolean isSafe(int row, int col, char[][] board) {

    int row_ = row;
    int col_ = col;

    // Check left diagonal
    while (row >= 0 && col >= 0) {
      if (board[row][col] == 'Q')
        return false;
      row--;
      col--;
    }

    // Check column
    row = row_;
    col = col_;
    while (col >= 0) {
      if (board[row][col] == 'Q')
        return false;
      col--;
    }

    // Check right diagonal
    row = row_;
    col = col_;
    while (row < board.length && col >= 0) {
      if (board[row][col] == 'Q')
        return false;
      row++;
      col--;
    }
    return true;
  }

  public List<String> construct(char[][] board) {
    List<String> boardWithQueens = new ArrayList<>();
    for (int i = 0; i < board.length; i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < board.length; j++) {
        sb.append(board[i][j]);
      }
      boardWithQueens.add(sb.toString());
    }
    return boardWithQueens;
  }

  public static void main(String[] args) {
    NQueensHard obj = new NQueensHard();
    System.out.println(obj.solveNQueens(4));
  }
}
