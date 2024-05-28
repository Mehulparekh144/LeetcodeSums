import java.util.*;

public class InsertIntervalMedium {

  public int[][] insert(int[][] intervals, int[] newInterval) {
    int i = 0;
    int start = newInterval[0];
    int end = newInterval[1];
    List<int[]> res = new ArrayList<>();
    while (i < intervals.length && start > intervals[i][1]) {
      res.add(intervals[i++]);
    }
    while (i < intervals.length && end >= intervals[i][0]) {
      start = Math.min(start, intervals[i][0]);
      end = Math.max(end, intervals[i][1]);
      i++;
    }
    res.add(new int[] { start, end });
    while (i < intervals.length)
      res.add(intervals[i++]);
    int j = 0;
    int[][] ans = new int[res.size()][2];
    for (int[] num : res) {
      ans[j++] = num;
    }
    return ans;
  }
}