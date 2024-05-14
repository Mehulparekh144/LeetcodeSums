package mst;
import java.util.*;

public class MaxIslandHard {
  public int largestIsland(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    DisjointSet ds = new DisjointSet(m * n);
    int[] dirX = new int[] { -1, 0, 1, 0 };
    int[] dirY = new int[] { 0, -1, 0, 1 };

    for(int i = 0 ; i < n ; i++){
      for(int j = 0; j < n ; j++){
        if(grid[i][j] == 0) continue;

        for(int k = 0 ; k < 4 ; k++){
          int newi = i + dirX[k];
          int newj = j + dirY[k];

          if(newi >= 0 && newj >= 0 && newi < m && newj < n && grid[newi][newj] == 1){
            int u = newi*n + newj;
            int v = i*n + j;
            ds.unionBySize(u , v);
          }
        }
      }
    }

    int maxi = 0;
    for(int i = 0 ; i < m ; i++){
      for(int j = 0 ; j < n ; j++){
        Set<Integer> components = new HashSet<>();
        if(grid[i][j] == 1) continue;

        for(int k = 0 ; k < 4 ; k++){
          int newi = i + dirX[k];
          int newj = j + dirY[k];

          if(newi >= 0 && newj >= 0 && newi < m && newj < n){
            if(grid[newi][newj] == 1){
              int node = newi*n + newj;
              components.add(ds.findUPar(node));
            }
          }
        }
        int totalSize = 1;
        for(int component : components){
          totalSize += ds.size.get(component);
        }

        maxi = Math.max(maxi , totalSize );
      }
    }

    for(int i = 0 ; i < m*n; i++){
      maxi = Math.max(maxi , ds.size.get(ds.findUPar(i)));
    }

    return maxi;

  }

  public static void main(String[] args) {
    MaxIslandHard obj = new MaxIslandHard();
    System.out.println(obj.largestIsland(new int[][] {{1,0} , {0,1}}));
    System.out.println(obj.largestIsland(new int[][] {{1,0,1}, {0,0,0} , {0,1,1}}));
  }
}
