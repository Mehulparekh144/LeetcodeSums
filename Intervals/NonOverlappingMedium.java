import java.util.*;
public class NonOverlappingMedium {
  public int eraseOverlapIntervals(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
    for (int[] in : intervals) {
      System.out.println(Arrays.toString(in));
    }
    int lastE = intervals[0][1];
    int res = 0;

    for (int i = 1; i < intervals.length; i++) {
      int s = intervals[i][0];
      if (s >= lastE) {
        lastE = intervals[i][1];
      } else {
        res += 1;
        lastE = Math.min(lastE, intervals[i][1]);
      }
    }

    return res;
  }

  public static void main(String[] args) {
    NonOverlappingMedium obj = new NonOverlappingMedium();
    System.out.println(obj.eraseOverlapIntervals(new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } }));

  }
}
