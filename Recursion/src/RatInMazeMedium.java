import java.util.ArrayList;

public class RatInMazeMedium {
  public ArrayList<String> findPath(int[][] m, int n) {
    ArrayList<String> result = new ArrayList<>();
    boolean[][] visited = new boolean[n][n];
    String path = "";
    backtrack(0, 0, m, result, path, visited);
    return result;
  }

  public void backtrack(int i, int j, int[][] m, ArrayList<String> result, String path, boolean[][] visited) {
    if (i == m.length - 1 && j == m.length - 1 && m[i][j] != 0) {
      result.add(new String(path));
      return;
    }
    if (i < 0 || j < 0 || i >= m.length || j >= m.length || m[i][j] == 0 || visited[i][j]) {
      return;
    }
    visited[i][j] = true;
    backtrack(i + 1, j, m, result, path + "D", visited);
    backtrack(i - 1, j, m, result, path + "U", visited);
    backtrack(i, j + 1, m, result, path + "R", visited);
    backtrack(i, j - 1, m, result, path + "L", visited);
    visited[i][j] = false;
  }

  public static void main(String[] args) {
    RatInMazeMedium obj = new RatInMazeMedium();
     int[][] maze = {
     { 1, 0, 0, 0 },
     { 1, 1, 0, 1 },
     { 1, 1, 0, 0 },
     { 0, 1, 1, 1 }
     };
//    int[][] maze = {
//        { 1, 0 },
//        { 1, 0 }
//    };
    int n = maze.length;
    ArrayList<String> paths = obj.findPath(maze, n);
    System.out.println("Paths: " + paths);

  }
}
