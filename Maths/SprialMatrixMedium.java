package Maths;
public class SprialMatrixMedium{
  public List<Integer> spiralOrder(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int l = 0;
    int t = 0;
    int r = n - 1;
    int b = m - 1;
    List<Integer> list = new ArrayList<>();
    while (l <= r && t <= b) {
      // TOP LEFT - TOP RIGHT
      for (int i = l; i <= r; i++) {
        list.add(matrix[t][i]);
      }
      t++;

      // TOP RIGHT - BOTTOM RIGHT
      for (int i = t; i <= b; i++) {
        list.add(matrix[i][r]);
      }
      r--;

      // BOTTOM RIGHT - BOTTOM LEFT
      if (t <= b) {
        for (int i = r; i >= l; i--) {
          list.add(matrix[b][i]);
        }
        b--;
      }

      // BOTTOM LEFT - TOP LEFT
      if (l <= r) {
        for (int i = b; i >= t; i--) {
          list.add(matrix[i][l]);
        }
        l++;
      }
    }

    return list;
  }
}