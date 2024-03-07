import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

public class WordSearchMedium {

  public boolean solve(char[][] board, String word, int i, int j, int idx) {
    if (idx == word.length()) {
      return true;
    }
    if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '$') {
      return false;
    }
    if (board[i][j] != word.charAt(idx)) {
      return false;
    }
    char temp = board[i][j];
    board[i][j] = '$';
    boolean isSequence = 
    solve(board, word, i + 1, j, idx + 1) ||
    solve(board, word, i - 1, j, idx + 1) ||
    solve(board, word, i, j + 1, idx + 1) ||
    solve(board, word, i, j - 1, idx + 1);
    board[i][j] = temp;
    return isSequence;
  }

  public boolean exist(char[][] board, String word) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == word.charAt(0)) {
          if (solve(board, word, i, j, 0))
            return true;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    // Create a sample board
    char[][] board = {
        { 'A', 'B', 'C', 'E' },
        { 'S', 'F', 'C', 'S' },
        { 'A', 'D', 'E', 'E' }
    };

    // Create an instance of WordSearchMedium
    WordSearchMedium wordSearch = new WordSearchMedium();

    // Test the exist method
    String word = "ABCCED";
    boolean exists = wordSearch.exist(board, word);
    System.out.println("Word \"" + word + "\" exists: " + exists);

    word = "SEE";
    exists = wordSearch.exist(board, word);
    System.out.println("Word \"" + word + "\" exists: " + exists);

    word = "ABCB";
    exists = wordSearch.exist(board, word);
    System.out.println("Word \"" + word + "\" exists: " + exists);
  }

}
