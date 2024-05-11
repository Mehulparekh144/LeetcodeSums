package shortestpath;
import java.util.*;

public class ShortestPathInBinaryMatrixMedium {
  class Pair {
    int row;
    int col;

    public Pair(int row , int col){

      this.row = row;
      this.col = col
      ;
    }
  }

    public int shortestPathBinaryMatrix(int[][] grid) {
      if (grid[0][0] == 1) {
        return -1;
      }
      Queue<Pair> q = new LinkedList<>();
      int[][] distances = new int[grid.length][grid[0].length];
      for(int[] d : distances) Arrays.fill(d , (int) 1e9);
      distances[0][0] = 1;

      q.offer(new Pair(0, 0));

      while (!q.isEmpty()) {
        int row = q.peek().row;
        int col =  q.peek().col;
        q.poll();

        for (int i = -1; i <= 1; i++) {
          for (int j = -1; j <= 1; j++) {
            if (i != 0 || j != 0) {
              int newRow = row + i;
              int newCol = col + j;

              if(newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length || grid[newRow][newCol] == 1){
                continue;
              }

              if(grid[newRow][newCol] == 0){
                if(distances[newRow][newCol] > distances[row][col] + 1){
                  distances[newRow][newCol] = distances[row][col] + 1;
                  q.offer(new Pair(newRow , newCol));
                }
              }
            }
          }
        }
      }

      System.out.println(Arrays.deepToString(distances));

      return distances[grid.length - 1][grid[0].length - 1];
    }

  public static void main(String[] args) {
    ShortestPathInBinaryMatrixMedium shortestPathInBinaryMatrixMedium = new ShortestPathInBinaryMatrixMedium();
    int[][] grid = {
      {0, 0, 0},
      {1, 1, 0},
      {1, 1, 0}
    };
    System.out.println(shortestPathInBinaryMatrixMedium.shortestPathBinaryMatrix(grid));
  }
}
