package mst;
import java.util.*;

public class NumberIslandsIIMedium {
  public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
    int[][] visited = new int[rows][cols];
    DisjointSet ds = new DisjointSet(rows*cols);
    int count = 0;
    List<Integer> res = new ArrayList<>();
    int[] dirX = new int[]{-1,0,1,0};
    int[] dirY = new int[]{0, -1 ,0, 1};
    for(int[] operator : operators){
      int i = operator[0];
      int j = operator[1];
      if(visited[i][j] == 0){
        count++;
        visited[i][j] = 1;
        for(int k = 0 ; k < 4; k++){
          int newR = i + dirX[k];
          int newC = j + dirY[k];

          if(newR < 0 || newC < 0 || newR >= rows || newC >= cols){
            continue;
          }

          if(visited[newR][newC] == 1){
            int u = cols*i + j;
            int v = cols*newR + newC;
            if(ds.findUPar(u) != ds.findUPar(v)){
              ds.unionBySize(u , v);
              count--;
            }

          }
        }
      }

      res.add(count);
    }

    return res;
  }

  public static void main(String[] args) {
    int n = 3;
    int m = 5;
    int[][] arr = {
            {1, 1},
            {0, 3},
            {2, 3},
            {2, 4},
            {2, 4},
            {2, 1},
            {1, 4},
            {0, 0},
            {1, 2},
            {2, 0}
    };

    NumberIslandsIIMedium obj = new NumberIslandsIIMedium();
    System.out.println(obj.numOfIslands(n, m, arr));
  }
}
