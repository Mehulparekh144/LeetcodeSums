package shortestpath;
import java.util.*;

public class PathWithMinEffortMedium {
  class Pair {
    int effort;
    int row;
    int col;

    public Pair(int effort , int row, int col) {
      this.effort = effort;
      this.row = row;
      this.col = col;
    }

  }

  public int minimumEffortPath(int[][] heights) {
    int m = heights.length;
    int n = heights[0].length;
    int[][] distances = new int[m][n];
    for(int[] row : distances){
      Arrays.fill(row , (int) 1e9);
    }

    PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt((x) -> x.effort));
    queue.offer(new Pair(0 , 0 , 0));
    distances[0][0] = 0;

    int[] dirX = new int[]{0,1,0,-1};
    int[] dirY = new int[]{1,0,-1,0};

    while(!queue.isEmpty()){
      Pair p = queue.poll();
      int row = p.row;
      int col = p.col;
      int effort = p.effort;

      if(row == m-1 && col == n-1) return effort;

      for(int i = 0 ; i < 4 ;i++){
        int newRow = row + dirX[i];
        int newCol = col + dirY[i];

        if(newRow < 0 || newCol < 0 || newRow >= m || newCol >= n) continue;

        int newEffort = Math.max(effort , Math.abs(heights[newRow][newCol] - heights[row][col] ));
        if(newEffort < distances[newRow][newCol]){
          distances[newRow][newCol] = newEffort;
          queue.offer(new Pair(newEffort , newRow , newCol));
        }
      }
    }

    return 0;
  }

  public static void main(String[] args) {
    PathWithMinEffortMedium pathWithMinEffortMedium = new PathWithMinEffortMedium();
    int[][] heights = new int[][]{{1,2,2},{3,8,2},{5,3,5}};
    System.out.println(pathWithMinEffortMedium.minimumEffortPath(heights));
  }
}
