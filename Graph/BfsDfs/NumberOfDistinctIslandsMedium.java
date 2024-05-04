package BfsDfs;
import java.util.*;

public class NumberOfDistinctIslandsMedium {
  static class Pair{
    int row;
    int col;
    public Pair(int row , int col){
      this.row = row;
      this.col = col;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Pair pair = (Pair) o;
      return row == pair.row && col == pair.col;
    }

    @Override
    public int hashCode() {
      return Objects.hash(row, col);
    }

  }

  private static void dfs(int i , int j , int[][] visited , int[][] arr , int startRow , int startCol , List<Pair> temp){
    if(i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || visited[i][j] == 1 || arr[i][j] == 0 ){
      return;
    }

    temp.add(new Pair(i - startRow , j - startCol));
    visited[i][j] = 1;
    dfs(i+1 , j , visited , arr , startRow , startCol , temp);
    dfs(i-1 , j , visited , arr , startRow , startCol , temp);
    dfs(i , j+1 , visited , arr , startRow , startCol , temp);
    dfs(i , j-1 , visited , arr , startRow , startCol , temp);



  }
  public static int distinctIsland(int [][] arr, int n, int m)
  {
    Set<List<Pair>> set = new HashSet<>();
    int[][] visited = new int[n][m];
    List<Pair> temp = new ArrayList<>();

    for(int i = 0 ; i < n ; i++){
      for(int j = 0 ; j < m ; j++){
        if(arr[i][j] == 1  && visited[i][j] == 0){
          temp = new ArrayList<>();
          dfs(i , j , visited , arr , i , j , temp);
          set.add(List.copyOf(temp));
        }
      }
    }

    return set.size();
  }
}
