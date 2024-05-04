package BfsDfs;

public class SurroundedRegionsMedium {

  private void dfs(int i, int j, int[][] visited, char[][] board) {
    int m = board.length;
    int n = board[0].length;

    if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j] == 1 || board[i][j] == 'X') {
      return;
    }

    visited[i][j] = 1;
    dfs(i + 1, j, visited, board);
    dfs(i - 1, j, visited, board);
    dfs(i, j + 1, visited, board);
    dfs(i, j - 1, visited, board);

  }

  public void solve(char[][] board) {
    int m = board.length;
    int n = board[0].length;
    int[][] visited = new int[m][n];

    for (int j = 0; j < n; j++) {
      if (board[0][j] == 'O' && visited[0][j] != 1) {
        dfs(0, j, visited, board);
      }
      if (board[m - 1][j] == 'O' && visited[m - 1][j] != 1) {
        dfs(m-1, j, visited, board);
      }
    }

    for (int i = 0; i < m; i++) {
      if (board[i][0] == 'O' && visited[i][0] != 1) {
        dfs(i, 0, visited, board);
      }

      if (board[i][n - 1] == 'O' && visited[i][n - 1] != 1) {
        dfs(i, n-1, visited, board);
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 'O' && visited[i][j] == 0) {
          board[i][j] = 'X';
        }
      }
    }

  }

  public static void main(String[] args) {
    SurroundedRegionsMedium obj = new SurroundedRegionsMedium();
    obj.solve(new char[][]{
            {'X'}
    });
  }
}
