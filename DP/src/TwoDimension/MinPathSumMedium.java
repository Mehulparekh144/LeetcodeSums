package TwoDimension;

public class MinPathSumMedium {

  public int solve(int i , int j , int[][] grid){
    if(i == grid.length - 1 &&  j == grid[0].length - 1){
      return grid[i][j];
    }

    if(i >= grid.length || j >= grid[0].length - 1){
      return (int) Math.pow(2,10);
    }
    int down = grid[i][j] + solve(i+1 , j , grid);
    int right = grid[i][j] + solve(i , j+ 1 , grid);
    return Math.min(down , right);
  }
  public int minPathSum(int[][] grid){
    int m = grid.length ;
    int n = grid[0].length;
    return solve(0 , 0 , grid);
  }

  public static void main(String[] args) {
    MinPathSumMedium obj = new MinPathSumMedium();
    System.out.println(obj.minPathSum(new int[][]{
            {1,3,1},
            {1,5,1},
            {4,2,1}
    }));
  }
}
