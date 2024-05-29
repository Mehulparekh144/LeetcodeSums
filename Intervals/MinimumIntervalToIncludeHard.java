import java.util.*;
public class MinimumIntervalToIncludeHard {
  
  public int[] minInterval(int[][] intervals, int[] queries) {
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    int[] originalQueries = queries.clone();
    Arrays.sort(queries);
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    Map<Integer,Integer> map = new HashMap<>();
    int[] res = new int[queries.length];
    int j = 0;
    for (int i = 0; i < queries.length; i++) {
      while (j < intervals.length && queries[i] >= intervals[j][0]) {
        int start = intervals[j][0];
        int end = intervals[j][1];
        int size = end - start + 1;
        pq.offer(new int[] { size, end });
        j++;
      }

      while (!pq.isEmpty() && pq.peek()[1] < queries[i]) {
        pq.poll();
      }
      if (pq.isEmpty()) {
        map.put(queries[i], -1);
      } else {
        map.put(queries[i], pq.peek()[0]);
      }
    }

    for (int i = 0; i < queries.length; i++) {
      res[i] = map.get(originalQueries[i]);
    }

    return res;
  }

  public static void main(String[] args) {
    MinimumIntervalToIncludeHard obj = new MinimumIntervalToIncludeHard();
    System.out.println(Arrays.toString(obj.minInterval(new int[][]{{1, 4}, {2, 4}, {3, 6} , {4,4}}, new int[]{2, 3, 4, 5})));
  }
}
