import java.util.*;

public class MergeIntervalMedium {
  public int[][] merge(int[][] intervals) {
    List<int[]> res = new ArrayList<>();
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    res.add(intervals[0]);

    for (int i = 1; i < intervals.length; i++) {
      int start = intervals[i][0];
      int end = intervals[i][1];

      int lastEnd = res.getLast()[1];
      if (start <= lastEnd) {
        res.getLast()[1] = Math.max(lastEnd, end);
      } else {
        res.add(intervals[i]);
      }
    }

    int[][] ans = new int[res.size()][2];
    int i = 0;
    for (int[] a : res)
      ans[i++] = a;
    return ans;
  }
}
