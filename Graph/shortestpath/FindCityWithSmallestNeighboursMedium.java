package shortestpath;
import java.util.*;

public class FindCityWithSmallestNeighboursMedium {
  public int findTheCity(int n, int[][] edges, int distanceThreshold) {
    int[][] matrix = new int[n][n];
    for(int[] row : matrix){
      Arrays.fill(row , (int) 1e9);
    }

    for(int i = 0 ; i < n ; i++){
      matrix[i][i] = 0;
    }


    for(int[] edge : edges){
      matrix[edge[0]][edge[1]] = edge[2];
      matrix[edge[1]][edge[0]] = edge[2];
    }



    for(int via = 0 ; via < n ; via++){
      for(int i = 0 ; i < n ; i++){
        for(int j = 0 ; j < n ; j++){
          matrix[i][j] = Math.min(matrix[i][j] , matrix[i][via] + matrix[via][j]);
        }
      }
    }


    int maxCount = n;
    int res = 0;
    for(int i = 0 ; i < n ; i++){
      int count = 0;
      for(int j = 0 ; j < n ; j++){
        if(matrix[i][j] != 0 && matrix[i][j] <= distanceThreshold){
          count++;
        }
      }

      if(maxCount >= count){
        maxCount = count;
        res = i ;
      }
    }

    return res;
  }

  public static void main(String[] args) {
    FindCityWithSmallestNeighboursMedium obj = new FindCityWithSmallestNeighboursMedium();
    System.out.println(obj.findTheCity(4 , new int[][]{
            {0,1,3},
            {1,2,1},
            {1,3,4},
            {2,3,1}
    } , 4));
  }
}
