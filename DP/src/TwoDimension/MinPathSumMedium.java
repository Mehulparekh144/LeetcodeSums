package TwoDimension;

import java.util.Arrays;

public class MinPathSumMedium {

  public int minPathSum(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int[] prev = new int[n];
    for (int i = 0; i < m; i++) {
      int[] temp = new int[n];
      for (int j = 0; j < n; j++) {
        if (i == 0 && j == 0) {
          temp[j] = grid[0][0];
          continue;
        }
        int up = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        if (i > 0) {
          up = grid[i][j] + prev[j];
        }
        if (j > 0) {
          left = grid[i][j] + temp[j - 1];
        }
        temp[j] = Math.min(up, left);
      }
      prev = temp;
    }
    return prev[n - 1];
  }

  public static void main(String[] args) {
    MinPathSumMedium obj = new MinPathSumMedium();
    System.out.println(obj.minPathSum(new int[][]{
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
    }));
  }
}
