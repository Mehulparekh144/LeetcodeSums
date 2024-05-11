package shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FloyddWarshalMedium {
  public void shortest_distance(int[][] matrix)
  {
    int n = matrix.length;

    for(int i = 0 ; i < n ; i++){
      for(int j = 0; j < n ; j++){
        if(matrix[i][j] == -1) matrix[i][j] = (int) 1e9;
      }
    }

    for(int via = 0 ; via < n ; via++ ){
      for(int i = 0 ; i < n ; i++){
        for(int j = 0 ; j < n ; j++){
          matrix[i][j] = Math.min(matrix[i][j] , matrix[i][via] + matrix[via][j]);
        }
      }
    }

    for(int i = 0 ; i < n ; i++){
      for(int j = 0 ; j < n ; j++){
        if(matrix[i][j] == 1e9) matrix[i][j] = -1;
      }
    }
  }

    public static void main(String[] args) {
      int[][] matrix = new int[][]{
              {0, 1, 43},
              {1, 0, 6},
              {-1, -1, 0}
      };
      int n = matrix.length;
      FloyddWarshalMedium obj = new FloyddWarshalMedium();
      obj.shortest_distance(matrix);
      System.out.println(Arrays.deepToString(matrix));
    }


}
