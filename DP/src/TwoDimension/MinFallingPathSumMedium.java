package TwoDimension;

public class MinFallingPathSumMedium {

  private int solve(int i, int j, int[][] matrix) {
    if (i < 0 || j < 0 || i >= matrix.length || j >= matrix.length) {
      return (int)Math.pow(2, 29) ;
    }

    if (i == matrix.length - 1) {
      return matrix[i][j];
    }
    int straightDown = matrix[i][j] + solve(i + 1, j, matrix);
    int diagonalLeft = matrix[i][j] + solve(i + 1, j - 1, matrix);
    int diagonalRight = matrix[i][j] + solve(i + 1, j + 1, matrix);

    return Math.min(Math.min(diagonalLeft, diagonalRight), straightDown);
  }

  public int minFallingPathSum(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int mini = Integer.MAX_VALUE;
    for (int j = 0; j < n; j++) {
      mini = Math.min(solve(0, j, matrix), mini);
    }

    return mini;
  }


  public static void main(String[] args) {
    MinFallingPathSumMedium obj = new MinFallingPathSumMedium();
    System.out.println(obj.minFallingPathSum(new int[][]{
            {2,1,3},
            {6,5,4},
            {7,8,9}
    }));
  }
}
