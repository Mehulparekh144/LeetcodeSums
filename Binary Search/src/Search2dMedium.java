public class Search2dMedium {

  public boolean searchMatrix(int[][] matrix, int target) {
    int row = matrix.length;
    int col = matrix[0].length;
    int l = 0;
    int r = row * col - 1;

    while (l <= r) {
      int mid = (l + r) / 2;
      int row_ = mid / col;
      int col_ = mid % col;

      if (matrix[row_][col_] == target) {
        return true;
      } else if (matrix[row_][col_] < target) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    // Example 1: Matrix with target found
    int[][] matrix1 = { { 1, 3, 5, 7 }, { 10, 11, 16, 19 }, { 23, 24, 25, 26 } };
    int target1 = 16;
    boolean found1 = new Search2dMedium().searchMatrix(matrix1, target1);
    System.out.println("Matrix 1: Target " + target1 + " found - " + found1);

    // Example 2: Matrix with target not found
    int[][] matrix2 = { { 1, 3, 5, 7 }, { 10, 11, 16, 19 }, { 23, 24, 25, 26 } };
    int target2 = 20;
    boolean found2 = new Search2dMedium().searchMatrix(matrix2, target2);
    System.out.println("Matrix 2: Target " + target2 + " found - " + found2);

    // Example 3: Empty matrix
    int[][] matrix3 = {};
    int target3 = 10;
    boolean found3 = new Search2dMedium().searchMatrix(matrix3, target3);
    System.out.println("Matrix 3 (empty): Target " + target3 + " found - " + found3);
  }
}
