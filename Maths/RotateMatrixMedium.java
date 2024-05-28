package Maths;

public class RotateMatrixMedium {
  public void rotate(int[][] matrix) {
    int left = 0;
    int right = matrix.length - 1;

    while (left < right) {

      for (int i = 0; i < right - left; i++) {
        int top = left;
        int bottom = right;

        int topLeft = matrix[top][left + i];

        // TopLeft value becomes BottomLeft
        matrix[top][left + i] = matrix[bottom - i][left];

        // BottomLeft becomes BottomRight
        matrix[bottom - i][left] = matrix[bottom][right - i];

        // BottomRight becomes TopRight
        matrix[bottom][right - i] = matrix[top + i][right];

        // TopRight becomes TopLeft
        matrix[top + i][right] = topLeft;

      }

      left++;
      right--;
    }
  }
}
