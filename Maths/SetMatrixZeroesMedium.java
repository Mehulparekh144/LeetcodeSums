public class SetMatrixZeroesMedium {
    public void setZeroes(int[][] matrix) {
      int m = matrix.length;
      int n = matrix[0].length;
      boolean c0 = false;

      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (matrix[i][j] == 0) {
            matrix[0][j] = 0;

            if (i > 0) {
              matrix[i][0] = 0;
            } else {
              c0 = true;
            }
          }
        }
      }

      for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
          if (matrix[0][j] == 0 || matrix[i][0] == 0) {
            matrix[i][j] = 0;
          }
        }
      }

      if (matrix[0][0] == 0) {
        for (int i = 0; i < m; i++) {
          matrix[i][0] = 0;
        }
      }

      if (c0) {
        for (int j = 0; j < n; j++) {
          matrix[0][j] = 0;
        }
      }
    }
}
