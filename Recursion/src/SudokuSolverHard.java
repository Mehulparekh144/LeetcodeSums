import java.util.Arrays;

public class SudokuSolverHard {

  public static boolean isValid(char[][] board, int row, int col, char c) {
    for(int i = 0 ; i < board.length ; i++){
      if(board[i][col] == c || board[row][i] == c || board[3*(row/3) + i/3][3*(col/3) + i%3] == c){
        return false;
      }
    }
    return true;
  }

  public static boolean solve(char[][] board) {
    String numbers = "123456789";
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == '.') {
          for (char c : numbers.toCharArray()) {
            if (isValid(board, i, j, c)) {
              board[i][j] = c;
              if(solve(board)) return true;
              else{
                board[i][j] = '.';
              }
            }
          }
          return false;
        }
      }
    }
    return true;
  }

  public static void solveSudoku(char[][] board) {
    solve(board);
  }

  public static void main(String[] args) {
    char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
    };
    solveSudoku(board);
    System.out.println(Arrays.deepToString(board));
  }
}
