package shortestpath;
import java.util.*;

public class SwimInRisingWaterHard {
  class Pair {
    int h;
    int i;
    int j;

    public Pair(int h, int i, int j) {
      this.h = h;
      this.i = i;
      this.j = j;
    }
  }

    public int swimInWater(int[][] grid) {
      int n = grid.length;
      PriorityQueue<Pair> pq = new PriorityQueue<Pair>(Comparator.comparing(x -> x.h));
      boolean[][] visited = new boolean[n][n];
      pq.offer(new Pair(grid[0][0] , 0 , 0));
      visited[0][0] = true;
      int[] dirX = new int[]{-1,0,1,0};
      int[] dirY = new int[]{0,-1,0,1};
      while(!pq.isEmpty()){
        int h = pq.peek().h;
        int i = pq.peek().i;
        int j = pq.peek().j;
        pq.poll();

        if(i == n-1 && j == n-1) return h;

        for(int k = 0 ; k < 4 ; k++){
          int i1 = i + dirX[k];
          int j1 = j + dirY[k];

          if(i1 < 0 || j1 < 0 || i1 >= n || j1 >= n || visited[i1][j1]){
            continue;
          }

          visited[i1][j1] = true;
          pq.offer(new Pair(Math.max(h , grid[i1][j1]) , i1 , j1));
        }
      }

      return -1;
    }
  }

