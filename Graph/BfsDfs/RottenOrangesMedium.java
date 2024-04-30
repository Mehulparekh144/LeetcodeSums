package BfsDfs;


import java.util.LinkedList;
import java.util.Queue;

public class RottenOrangesMedium {
  class Pair{
    int row;
    int col;
    int minutes;

    public Pair(int row , int col , int minutes){
      this.row = row;
      this.col = col;
      this.minutes = minutes;
    }
  }
  public int orangesRotting(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    int[][] visited = new int[m][n];
    int fresh = 0;
    Queue<Pair> q = new LinkedList<>();

    for(int i = 0 ; i < m ; i++){
      for(int j = 0 ; j < n ; j++){
        if(grid[i][j] == 2){
          q.offer(new Pair(i , j , 0));
          visited[i][j] = 2;
        } else{
          visited[i][j] = 0;
        }

        if(grid[i][j] == 1){
          fresh += 1;
        }
      }
    }

    if(fresh == 0) return 0;
    int cnt = 0;
    int res = 0;
    while(!q.isEmpty()){
      Pair pair = q.poll();
      int x = pair.row;
      int y = pair.col;
      int minutes = pair.minutes;
      res = Math.max(res , minutes);
      int[] directionX = new int[]{-1,0,1,0};
      int[] directionY = new int[]{0,1,0,-1};
      for(int i = 0 ; i < 4 ; i++){
          int dx = x + directionX[i];
          int dy = y + directionY[i];

          if(dx < 0 || dx >= m || dy < 0 || dy >= n || grid[dx][dy] != 1){
            continue;
          }

          grid[dx][dy] = 2;
          q.offer(new Pair(dx,dy, minutes + 1));
          visited[dx][dy] = 2;
          cnt += 1;

        }
      }


    if(cnt != fresh) return -1;
    return res;

  }

  public static void main(String[] args) {
    RottenOrangesMedium rottenOrangesMedium = new RottenOrangesMedium();
    int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
    System.out.println(rottenOrangesMedium.orangesRotting(grid));
  }
}
